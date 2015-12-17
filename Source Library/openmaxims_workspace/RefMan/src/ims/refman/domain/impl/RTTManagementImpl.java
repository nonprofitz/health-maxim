//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Michael Noonan using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseRTTManagementImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.vo.CATSReferralRTTManagementVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.RTTManagementGridValueVo;
import ims.RefMan.vo.RTTManagementPatientPathwayJourneyVo;
import ims.RefMan.vo.domain.CATSReferralRTTManagementVoAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.ReferralRefVo;
import ims.core.clinical.domain.objects.Service;
import ims.core.configuration.domain.objects.ContractConfig;
import ims.core.configuration.domain.objects.ContractServiceLocationsConfig;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ReferralLiteVo;
import ims.core.vo.ReferralLiteVoCollection;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.pathways.configuration.vo.PathwayRefVo;
import ims.pathways.domain.PatientJourney;
import ims.pathways.domain.impl.PatientJourneyImpl;
import ims.pathways.domain.objects.PathwayClock;
import ims.pathways.domain.objects.PathwayRTTStatus;
import ims.pathways.domain.objects.PathwaysRTTClockImpact;
import ims.pathways.domain.objects.PatientEvent;
import ims.pathways.domain.objects.PatientJourneyTarget;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.vo.PathwayRTTStatusVo;
import ims.pathways.vo.PathwaysRTTClockImpactRefVo;
import ims.pathways.vo.PatientJourneyInterfaceVo;
import ims.pathways.vo.PatientJourneyTargetRefVo;
import ims.pathways.vo.PatientPathwayJourneyRefVo;
import ims.pathways.vo.PatientPathwaysAwaitingValidationWorklistVo;
import ims.pathways.vo.RTTManagementPathwayClockVo;
import ims.pathways.vo.domain.PatientPathwaysAwaitingValidationWorklistVoAssembler;
import ims.pathways.vo.lookups.EventStatus;
import ims.pathways.vo.lookups.RTTClockImpactSource;
import ims.pathways.vo.lookups.RTTClockState;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.vo.AppointmentOutcomeDetailsVoCollection;
import ims.scheduling.vo.domain.AppointmentOutcomeDetailsVoAssembler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class RTTManagementImpl extends BaseRTTManagementImpl
{

	private static final long serialVersionUID = 1L;

	@Override
	public ReferralLiteVoCollection listReferralWithPathways(PatientRefVo patient) {
		PatientJourney impl = (PatientJourney)getDomainImpl(PatientJourneyImpl.class);
		return impl.listReferralWithPathways(patient);
	}

	@Override
	public CATSReferralRTTManagementVo getReferralDetails(ReferralLiteVo referral)
	{
		if (referral == null || referral.getCatsReferralDetails() == null)
			return null;
	
		return getCatsReferralRTTManagement(referral.getCatsReferralDetails());
	}

	
	@Override
	public void updateReferralDate(Date newDate, CatsReferralRefVo catsReferral) throws StaleObjectException 
	{
		DomainFactory factory = getDomainFactory();
		CatsReferral referralDom = (CatsReferral)factory.getDomainObject(CatsReferral.class,catsReferral.getBoId());
		Date originalDate = new Date(referralDom.getReferralDetails().getDateOfReferral()); // WDEV-21128 
		
		if (newDate.compareTo(originalDate) == 0) //WDEV-23202 if dates are equal no need to save record with no updates
			return;

		referralDom.getReferralDetails().setDateOfReferral(newDate.getDate());
		
		/* if there is an original date it means that its an IPT and the breach date does not get updated */
		if(referralDom.getReferralDetails()!=null &&referralDom.getReferralDetails().getOriginalDateOfReferral()==null) 
		{
			Integer daysToRttBreachDate=getDaysToRttBreachDateByService(referralDom.getContract(),referralDom.getReferralDetails().getService());
			if(daysToRttBreachDate!=null)
			{
				DateTime jDTend18WW =  new DateTime(referralDom.getReferralDetails().getDateOfReferral());
				jDTend18WW.addDays(daysToRttBreachDate);
				referralDom.getReferralDetails().setEnd18WW(jDTend18WW.getJavaDate());
			}
		}
		
		// WDEV-21128 May need to update Patient Journey Clock and Target Information
		if (referralDom != null && referralDom.getJourney() != null)
		{
			PatientPathwayJourneyRefVo journeyRefVo = new PatientPathwayJourneyRefVo(referralDom.getJourney().getId(), referralDom.getJourney().getVersion());
			ims.pathways.domain.HL7PathwayIf impl = (ims.pathways.domain.HL7PathwayIf)getDomainImpl(ims.pathways.domain.impl.HL7PathwayIfImpl.class);
			impl.updateJourneyFromReferralDateChange(journeyRefVo, originalDate, newDate);
		}
		
		factory.save(referralDom);
	}
	
	
	
	private Integer getDaysToRttBreachDateByService(ContractConfig contract,Service service)
	{
		if (contract==null || service==null)
			return null;
		
		for (int i=0;contract.getServiceLocations()!=null && i<contract.getServiceLocations().size();i++)
		{
			if (contract.getServiceLocations().get(i)!=null && service.equals(((ContractServiceLocationsConfig)contract.getServiceLocations().get(i)).getService()))
				return ((ContractServiceLocationsConfig)contract.getServiceLocations().get(i)).getDaysToRTTBreachDate();
		}
		return contract.getDaysToRTTBreachDate();
	}



	
	
	@Override
	public void undoRTTEvent(RTTManagementGridValueVo event) throws StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		if(event!=null)
		{
			java.util.Date statusDateTime =null; 
			java.util.Date startDateTime =null;
			java.util.Date endDateTime =null;
			
			if(event.getRttStatus()!=null)
			{
				PathwayRTTStatus statusDom = (PathwayRTTStatus)factory.getDomainObject(event.getRttStatus());
				if(statusDom!=null)
				{
					statusDateTime=statusDom.getStatusDateTime();
					Calendar cal = new  GregorianCalendar();
					cal.setTime(statusDom.getStatusDateTime());
					cal.add(Calendar.MINUTE, 1);
					endDateTime = cal.getTime();
					cal.add(Calendar.MINUTE,-2);
					startDateTime =cal.getTime();
					
					
					statusDom.setIsRIE(true);
					factory.save(statusDom);
				}
			}
			PathwaysRTTClockImpact clockImpactDom =null;
			if(event.getClockImpactRef()!=null)
			{
				clockImpactDom = (PathwaysRTTClockImpact)factory.getDomainObject(event.getClockImpactRef());
				if(clockImpactDom!=null)
				{
					clockImpactDom.setIsRIE(true);
					if(clockImpactDom.isClockStopped())
					{
						clockImpactDom.getFinalClock().setStopDate(null);
					}
					else if(clockImpactDom.isClockStarted())
					{
						clockImpactDom.getFinalClock().setStartDate(null);
					}
					
					
					String hql ="select p1_1 from PatientEvent as p1_1 left join p1_1.event as e1_1 left join p1_1.journey as p2_1, PathwaysRTTClockImpact as p3_1 left join p3_1.outcomeEvent as r1_1 left join r1_1.event as e2_1 left join p3_1.journey as p4_1"+
							" where	(p3_1.id = :clockID) and e1_1=e2_1 and p2_1=p4_1 and p1_1.eventDateTime between :startTime and :endTime order by p1_1.id desc";
					List l = factory.find(hql,new String[]{"clockID","startTime","endTime"},new Object[]{clockImpactDom.getId(),startDateTime,endDateTime});
					if(l!=null && l.size()>0)
					{
						PatientEvent patientEvent = (PatientEvent)l.get(0);
						patientEvent.setIsRIE(true);
						patientEvent.setEventStatus(getDomLookup(EventStatus.RIE));
						factory.save(patientEvent);
					}
					
					
					
					if(clockImpactDom.getFinalClock()!=null && isAllStatusHistoryRIEed(clockImpactDom.getFinalClock()))
					{
						clockImpactDom.getFinalClock().setIsRIE(true);
						if(clockImpactDom.getJourney()!=null)
						{
							clockImpactDom.getJourney().setCurrentClock(clockImpactDom.getInitialClock());
							if(clockImpactDom.getJourney().getCurrentClock()!=null) //WDEV-20886
							{
								clockImpactDom.getJourney().getCurrentClock().setCurrentRTTStatus(clockImpactDom.getInitialRTTStatus());
							}
						}
					}

					if (event.getCatsReferralIsNotNull())
					{
						CatsReferral referral = (CatsReferral) factory.getDomainObject(event.getCatsReferral());
						if (referral != null)
						{
							referral.setCurrentRTTStatus(clockImpactDom.getInitialRTTStatus());

							if (clockImpactDom.getJourney() != null && clockImpactDom.getJourney().getCurrentClock() != null)
							{
								referral.getReferralDetails().setEnd18WW(clockImpactDom.getJourney().getCurrentClock().getTargetClockEnd());
							}

							factory.save(referral);
						}
					}
					
					factory.save(clockImpactDom);	
				}
			}
			else if(event.getClockIsNotNull()) // If there was no clock impact and all events are RIE'ed RIE the clock
			{
				PathwayClock pathwayClock=(PathwayClock)factory.getDomainObject( event.getClock());
				if(pathwayClock!=null)
				{
					if(isAllStatusHistoryRIEed(pathwayClock))
					{
						pathwayClock.setIsRIE(true);
						factory.save(pathwayClock);
					}
				}
			}
		}
	}

	private boolean isAllStatusHistoryRIEed(PathwayClock finalClock)
	{
		boolean allRIEed = true; 
		List<PathwayRTTStatus>  list = finalClock.getRTTStatusHistory();
		if(list!=null)
		{			 
			for (PathwayRTTStatus pathwayRTTStatus : list)
			{
				if(pathwayRTTStatus == null)
					continue;
				
				if(pathwayRTTStatus.getIsRIE()==null||Boolean.FALSE.equals(pathwayRTTStatus.getIsRIE()))
					return false;
			}
		}
		return allRIEed;
	}

	@Override
	public PatientJourneyInterfaceVo getPatientJourney(PatientPathwayJourneyRefVo profile, PathwayRefVo pathway)
	{
		PatientJourney impl = (PatientJourney)getDomainImpl(PatientJourneyImpl.class);
		return impl.getPatientJourney(profile, pathway);
	}

	@Override
	public Integer getCurrentPauseDetails(ReferralRefVo ref) {
		PatientJourney impl = (PatientJourney)getDomainImpl(PatientJourneyImpl.class);
		return impl.getCurrentPauseDetails( ref);
	}

	@Override
	public String getEventDescription(PathwaysRTTClockImpactRefVo impactRef)
	{
		if(impactRef!=null)
		{
			DomainFactory factory = getDomainFactory();
			String hql = "select e1_1.name from PathwaysRTTClockImpact as p1_1 left join p1_1.outcomeEvent as r1_1 left join r1_1.event as e1_1 where(p1_1.id = :clockId)";
			List l = factory.find(hql,new String[]{"clockId"},new Object[]{impactRef.getBoId()});
			if(l!=null&&l.size()>0)
			{
				return (String)l.get(0);
			}
		}
		return null;
	}

	
	/**
	 * wdev-20636 
	 * Method which will set the status of the target from in-scope to not-in-scope so that it will not be visible on the patient journey screen
	 */
	public void removeTargetFromScope(PatientJourneyTargetRefVo target, PatientPathwayJourneyRefVo journey) throws StaleObjectException, DomainInterfaceException
	{
		PatientJourneyTarget domPJT = (PatientJourneyTarget) getDomainFactory().getDomainObject(PatientJourneyTarget.class, target.getID_PatientJourneyTarget());
		if (domPJT != null && domPJT.getPathwayTarget() != null && domPJT.getPathwayTarget().getTarget() != null)
		{
			ims.pathways.domain.HL7PathwayIf impl = (ims.pathways.domain.HL7PathwayIf)getDomainImpl(ims.pathways.domain.impl.HL7PathwayIfImpl.class);
			impl.takeTargetOutOfScopeWithoutEvent(target, journey);
		}
	}


	//WDEV-21371
	@Override
	public void savePatientPathwaysAwaitingValidationWorklistVo(PatientPathwaysAwaitingValidationWorklistVo patientPathwaysAwaitingValidationWorklistVo) throws StaleObjectException
	{

		if(patientPathwaysAwaitingValidationWorklistVo == null)
			throw new CodingRuntimeException("Invalid patientPathwaysAwaitingValidationWorklistVo");

		DomainFactory factory = getDomainFactory();
		PatientPathwayJourney domPatientPathwayJourney = PatientPathwaysAwaitingValidationWorklistVoAssembler.extractPatientPathwayJourney(factory, patientPathwaysAwaitingValidationWorklistVo);
		
		if (patientPathwaysAwaitingValidationWorklistVo.getValidationCompletedBy() != null
				&& patientPathwaysAwaitingValidationWorklistVo.getValidationCompletedDT() != null)
		{
			domPatientPathwayJourney.setLastValidationDate(domPatientPathwayJourney.getNextValidationDate());
			domPatientPathwayJourney.setNextValidationDate(null);
		}
		factory.save(domPatientPathwayJourney);

	}

	//WDEV-21371
	@Override
	public PatientPathwaysAwaitingValidationWorklistVo getPatientPathwaysAwaitingValidationWorklistVo(PatientPathwayJourneyRefVo patientJourneyRefVo)
	{
		if (patientJourneyRefVo == null)
			throw new DomainRuntimeException("Invalid Journey");

		PatientPathwayJourney doPatientPathwayJourney = (PatientPathwayJourney) getDomainFactory().getDomainObject(PatientPathwayJourney.class, patientJourneyRefVo.getID_PatientPathwayJourney());

		if (doPatientPathwayJourney == null)
			throw new DomainRuntimeException("Journey not found");

		return PatientPathwaysAwaitingValidationWorklistVoAssembler.create(doPatientPathwayJourney);
	}



	public void markReferralAsNotSubjectToRTT(CatsReferralRefVo referralRef, Boolean markAllClocksAsRIE) throws StaleObjectException
	{
		// Test referral to be valid
		if (referralRef == null || referralRef.getID_CatsReferral() == null)
			throw new IllegalArgumentException("Cats Referral record cannot be null or not saved previously.");
		
		
		// Get the Cats Referral and Journey to modify
		CATSReferralRTTManagementVo referral = getCatsReferralRTTManagement(referralRef);
		RTTManagementPatientPathwayJourneyVo journey = referral.getJourney();
		
		
		// Update the CatsReferral
		referral.getReferralDetails().setEnd18WW(null);
		referral.setCurrentRTTStatus(null);
		referral.setRTTClockImpact(false);
		referral.setManuallyMarkedAsNotRTTImpact(true);
		
		// Commit referral to database
		CatsReferral domReferral = CATSReferralRTTManagementVoAssembler.extractCatsReferral(getDomainFactory(), referral);
		getDomainFactory().save(domReferral);
		
		if (Boolean.TRUE.equals(markAllClocksAsRIE))
		{
			// Update the Journey - mark as RIE the Clocks and RTT Statuses
			// Current clock should also be in history
			if (journey.getClockHistory() != null)
			{
				for (RTTManagementPathwayClockVo rttClock : journey.getClockHistory())
				{
					markClockAsRIE(rttClock, null);
				}
			}
		}
		else
		{
			if (journey.getCurrentClock() != null)
			{
				markClockAsRIE(journey.getCurrentClock(), null);
			}
		}
	}



	private void markClockAsRIE(RTTManagementPathwayClockVo rttClock, Integer patientID) throws StaleObjectException
	{
		if (rttClock == null)
			return;
		
		if (rttClock.getRTTStatusHistory() != null)
		{
			for (PathwayRTTStatusVo rttStatus : rttClock.getRTTStatusHistory())
			{
				markAsRie(rttStatus, null, patientID, null, null, "Marked as RIE on Referral set as Not RTT Impact.");
			}
			
			markAsRie(rttClock, null, patientID, null, null, "Marked as RIE on Referral set as Not RTT Impact.");
		}
	}

	
	
	private CATSReferralRTTManagementVo getCatsReferralRTTManagement(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;

		return CATSReferralRTTManagementVoAssembler.create((CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, referral.getID_CatsReferral()));
	}

	

	public AppointmentOutcomeDetailsVoCollection listAppointmentOutcomeDetails(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT appointment ");
		
		query.append(" FROM CatsReferral AS referral LEFT JOIN referral.rTTClockImpacts AS referralClockImpact ");
		query.append(" LEFT JOIN referralClockImpact.source AS impactSource, ");
	
		query.append(" Booking_Appointment AS appointment LEFT JOIN appointment.rTTClockImpact AS appointmentClockImpact ");
		
		query.append(" WHERE ");
		
		query.append(" referral.id = :REFERRAL_ID AND referralClockImpact.id = appointmentClockImpact.id AND impactSource.id = :APPOINTMENT_OUTCOME");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("REFERRAL_ID");					paramValues.add(referral.getID_CatsReferral());
		paramNames.add("APPOINTMENT_OUTCOME");			paramValues.add(RTTClockImpactSource.APPOINTMENT_OUTCOME.getID());
		
		return AppointmentOutcomeDetailsVoAssembler.createAppointmentOutcomeDetailsVoCollectionFromBooking_Appointment(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}


	public Boolean isClockImpactValidForAppointment(PathwaysRTTClockImpactRefVo clockImpact)
	{
		if (clockImpact == null || clockImpact.getID_PathwaysRTTClockImpact() == null)
			return Boolean.FALSE;
		
		String query = "SELECT appt FROM Booking_Appointment AS appt LEFT JOIN appt.rTTClockImpact AS clockImpact WHERE clockImpact.id = :CLOCK_IMPACT";
		Booking_Appointment appointment = (Booking_Appointment) getDomainFactory().findFirst(query, "CLOCK_IMPACT", clockImpact.getID_PathwaysRTTClockImpact());
		
		if (appointment == null || appointment.getOutcome() == null)
			return Boolean.FALSE;

		return Boolean.TRUE;
	}
	
	//WDEV-23296
	@Override
	public CareContextShortVo getCareContextShortVo(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		List <?> cats = factory.find(" select CC from CatsReferral as catsRef left join catsRef.careContext as CC where catsRef.id = :referralID",	new String[]{"referralID"},	new Object[]{referral.getID_CatsReferral()});
		
		if (cats != null && cats.size() > 0)
			return CareContextShortVoAssembler.create((CareContext)cats.get(0));
		
		return null;
	}

	public void updateRTTStatusAndClockWithNewDate(DateTime newDateTime, RTTManagementGridValueVo rowValue) throws StaleObjectException, DomainInterfaceException
	{
		if(newDateTime == null)
			return;
		
		if(rowValue == null || rowValue.getRttStatus() == null || rowValue.getRttStatus().getID_PathwayRTTStatus() == null)
			return;
		
		DomainFactory factory = getDomainFactory();
		
		if(rowValue.getCatsReferral() != null && rowValue.getCatsReferral().getID_CatsReferral() != null)
		{
			CatsReferral catsReferral = (CatsReferral) factory.getDomainObject(CatsReferral.class, rowValue.getCatsReferral().getID_CatsReferral());
			
			if(catsReferral != null && catsReferral.getReferralDetails() != null)
			{
				DateTime dateOfReferral = new DateTime(catsReferral.getReferralDetails().getDateOfReferral());
	
				if(dateOfReferral.isGreaterThan(newDateTime))
					throw new DomainInterfaceException("RTT Status Date/Time cannot be set earlier than Referral Date.");
			}
		}
		
		PathwaysRTTClockImpact clockImpact = null;
		if(rowValue.getClockImpactRef() != null && rowValue.getClockImpactRef().getID_PathwaysRTTClockImpact() != null)
		{
			clockImpact = (PathwaysRTTClockImpact) factory.getDomainObject(PathwaysRTTClockImpact.class, rowValue.getClockImpactRef().getID_PathwaysRTTClockImpact());
		}
		
		if(clockImpact != null)
		{
			PathwayClock initialClock = clockImpact.getInitialClock();
			PathwayClock finalClock = clockImpact.getFinalClock();
			
			boolean isInitialClockUpdated = false;
			boolean isFinalClockUpdated = false;
			
			if(RTTClockState.NOT_PRESENT.getID() == clockImpact.getInitialClockState().getId())
			{
				if(RTTClockState.STARTED.getID() == clockImpact.getFinalClockState().getId())
				{
					if(finalClock != null)
					{
						finalClock.setStartDate(newDateTime.getJavaDate());
						isFinalClockUpdated = true;
					}
				}
				else if(RTTClockState.STOPPED.getID() == clockImpact.getFinalClockState().getId())
				{
					if(finalClock != null)
					{
						finalClock.setStartDate(newDateTime.getJavaDate());
						finalClock.setStopDate(newDateTime.getJavaDate());
						isFinalClockUpdated = true;
					}
				}
			}
			else if(RTTClockState.STARTED.getID() == clockImpact.getInitialClockState().getId())
			{
				if(RTTClockState.STARTED.getID() == clockImpact.getFinalClockState().getId())
				{
					if(initialClock != null && finalClock != null && !initialClock.getId().equals(finalClock.getId()))
					{
						initialClock.setStopDate(newDateTime.getJavaDate());
						finalClock.setStartDate(newDateTime.getJavaDate());
						isInitialClockUpdated = true;
						isFinalClockUpdated = true;
					}
				}
				if(RTTClockState.STOPPED.getID() == clockImpact.getFinalClockState().getId())
				{
					if(initialClock != null && finalClock != null && initialClock.getId().equals(finalClock.getId()))
					{
						if(finalClock != null && finalClock.getStartDate() != null)
						{
							DateTime clockStartDate = new DateTime(finalClock.getStartDate());
							
							if(clockStartDate.isGreaterThan(newDateTime))
								throw new DomainInterfaceException("RTT Status Date/Time cannot be set earlier than Clock Start Date " + clockStartDate);
						}
						
						finalClock.setStopDate(newDateTime.getJavaDate());
						isFinalClockUpdated = true;
					}
					else if(initialClock != null && finalClock != null && !initialClock.getId().equals(finalClock.getId()))
					{
						initialClock.setStopDate(newDateTime.getJavaDate());
						finalClock.setStartDate(newDateTime.getJavaDate());
						finalClock.setStopDate(newDateTime.getJavaDate());
						isInitialClockUpdated = true;
						isFinalClockUpdated = true;
					}
				}
			}
			else if(RTTClockState.STOPPED.getID() == clockImpact.getInitialClockState().getId())
			{
				if(RTTClockState.STARTED.getID() == clockImpact.getFinalClockState().getId())
				{
					if(finalClock != null)
					{
						finalClock.setStartDate(newDateTime.getJavaDate());
						isFinalClockUpdated = true;
					}
					
				}
				else if(RTTClockState.STOPPED.getID() == clockImpact.getFinalClockState().getId())
				{
					if(initialClock != null && finalClock != null && !initialClock.getId().equals(finalClock.getId()))
					{
						finalClock.setStartDate(newDateTime.getJavaDate());
						finalClock.setStopDate(newDateTime.getJavaDate());
						isFinalClockUpdated = true;
					}
				}
			}
			
			if(!isFinalClockUpdated)
			{	
				if(rowValue.getClock() != null && rowValue.getClock().getID_PathwayClock() != null)
				{
					PathwayClock clock = (PathwayClock) factory.getDomainObject(PathwayClock.class, rowValue.getClock().getID_PathwayClock());
					
					if(clock != null && clock.getStartDate() != null)
					{
						DateTime clockStartDate = new DateTime(clock.getStartDate());
						
						if(clockStartDate.isGreaterThan(newDateTime))
							throw new DomainInterfaceException("RTT Status Date/Time cannot be set earlier than Clock Start Date " + clockStartDate);
					}
				}
			}
			
			if(isInitialClockUpdated)
			{
				factory.save(initialClock);
			}
			
			if(isFinalClockUpdated)
			{
				factory.save(finalClock);
			}
		}
		
		//WDEV-23973 - starts here
		PathwayRTTStatus rttStatus = (PathwayRTTStatus) factory.getDomainObject(PathwayRTTStatus.class, rowValue.getRttStatus().getID_PathwayRTTStatus());
		
		if(rttStatus != null)
		{
			if(rttStatus.getVersion() != rowValue.getRttStatus().getVersion_PathwayRTTStatus())//WDEV-23928
				throw new StaleObjectException(rttStatus);
			
			rttStatus.setStatusDateTime(newDateTime.getJavaDate());
			factory.save(rttStatus);
		}
		
		//WDEV-23973 - ends here
	}
}