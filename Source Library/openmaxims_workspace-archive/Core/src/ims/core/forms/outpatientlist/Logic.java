//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.45 build 2385.22037)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.outpatientlist;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.OutPatientListSearchCriteriaVo;
import ims.core.vo.OutPatientListVo;
import ims.core.vo.OutPatientListVoCollection;
import ims.core.vo.PatientIdCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.MedicGrade;
import ims.core.vo.lookups.PatIdType;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setSelectingPatientForm(null);
		clearInstanceControls();
	}

	private void clearInstanceControls()
	{
		clearClinicCombo();
		form.qmbClinic().setEnabled(false);
		form.cmbLocation().setValue(null);
		clearConsultantCombo();
		form.dteClinic().setValue(null);
		clearOutPatientList();
		form.cmbSpecialty().setValue(null);
		form.getGlobalContext().Core.setOutPatientSearchCriteria(null);

	}

	private void clearOutPatientList()
	{
		form.grdOutPatient().getRows().clear();
		form.grdOutPatient().setValue(null);

	}

	private void clearConsultantCombo()
	{
		form.qmbConsultant().clear();

	}

	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}

	private void search()
	{
		form.getGlobalContext().Core.setOutPatientSearchCriteria(null);

		clearOutPatientList();

		if (form.dteClinic().getValue() == null || (form.qmbClinic().getValue() == null && form.qmbConsultant().getValue() == null))
		{
			engine.showMessage("Valid search criteria must be specified - Please enter a Clinic Date and a Clinic and/or Consultant");
			return;
		}

		populateOutPatientList(domain.listOutpatients(form.qmbClinic().getValue(), form.qmbConsultant().getValue(), form.cmbSpecialty().getValue(), form.dteClinic().getValue()));

	}

	private void populateOutPatientList(OutPatientListVoCollection outpatientAttendances)
	{
		clearOutPatientList();

		if (outpatientAttendances == null || outpatientAttendances.size() == 0)
		{
			engine.showMessage("No matching patients found.");
			return;
		}

		storeSearchCriteria();
		
		GenForm.grdOutPatientRow row = null;
			
		for (OutPatientListVo outpatient : outpatientAttendances)
		{
			if (outpatient != null && outpatient.getPasEventIsNotNull() && outpatient.getPasEvent().getPatientIsNotNull())
			{
				PatientShort patient = outpatient.getPasEvent().getPatient();

				row = form.grdOutPatient().getRows().newRow();
				
				if (patient.getNameIsNotNull())
				{
					row.setcolForename(patient.getName().getForename());
					row.setcolSurname(patient.getName().getSurname());
				}

				ims.core.vo.PatientId voPatId = patient.getDisplayId();
				if (voPatId != null)
					row.setcolHospnum(voPatId.getValue());
				
				//WDEV-16710
				StringBuffer patientIdentifiers = new StringBuffer();
				PatientIdCollection identifiers = patient.getIdentifiers();
				
				if (identifiers != null)
				{
					for (int a = 0; a < identifiers.size(); a++)
					{
						patientIdentifiers.append("<b>" + identifiers.get(a).getType().toString() + ":</b> " + identifiers.get(a).getValue() + "<br>");
					}
				}
				
				row.setTooltipForcolHospnum(patientIdentifiers.toString());

				if (patient.getDobIsNotNull())
					row.setcolDob(patient.getDob().toString());

				if (patient.getAgeIsNotNull())
					row.setColAge(patient.getAge().toString());
				else
				{
					//WDEV-12716
					Integer age = patient.calculateAge();
					if (age != null) row.setColAge(age.toString());
				}

				if (patient.getSexIsNotNull())
					row.setcolSex(patient.getSex().getText());

				if (outpatient.getClinicIsNotNull())
					row.setcolClinic(outpatient.getClinic().getClinicName());

				if (outpatient.getPasEvent() != null && outpatient.getPasEvent().getSpecialty() != null)
					row.setcolSpecialty(outpatient.getPasEvent().getSpecialty().getText());

				if (outpatient.getAppointmentDateTimeIsNotNull())
					row.setcolClinicDate(outpatient.getAppointmentDateTime().toString());

				if (patient.getIsDead() != null && patient.getIsDead().booleanValue())
					row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());

				row.setValue(outpatient);
			}
		}
	}

	private void storeSearchCriteria()
	{
		OutPatientListSearchCriteriaVo voOutPatSearch = new OutPatientListSearchCriteriaVo();
		if(form.getLocalContext().getUserAccessVoIsNotNull()){
			voOutPatSearch.setClinic(form.cmbClinic().getValue());
			voOutPatSearch.setConsultant(form.cmbConsultant().getValue());
		}
		else{
			voOutPatSearch.setClinic(form.qmbClinic().getValue());
			voOutPatSearch.setConsultant(form.qmbConsultant().getValue());
		}
		voOutPatSearch.setClinicDate(form.dteClinic().getValue());
		voOutPatSearch.setLocation(form.cmbLocation().getValue());
		voOutPatSearch.setSpecialty(form.cmbSpecialty().getValue());
		form.getGlobalContext().Core.setOutPatientSearchCriteria(voOutPatSearch);

	}

	protected void onFormOpen() throws PresentationLogicException
	{
		initialize();
		open();

	}

	private void open()
	{
		if (form.getGlobalContext().Core.getOutPatientSearchCriteriaIsNotNull())
		{
			displaySearchCriteria();
			search();
		}

	}

	private void displaySearchCriteria()
	{
		form.dteClinic().setValue(form.getGlobalContext().Core.getOutPatientSearchCriteria().getClinicDate());
		form.qmbConsultant().setValue(form.getGlobalContext().Core.getOutPatientSearchCriteria().getConsultant());
		if (form.qmbConsultant().getValue() == null && form.getGlobalContext().Core.getOutPatientSearchCriteria().getConsultantIsNotNull())
		{
			form.qmbConsultant().newRow(form.getGlobalContext().Core.getOutPatientSearchCriteria().getConsultant(), form.getGlobalContext().Core.getOutPatientSearchCriteria().getConsultant().toString());
			form.qmbConsultant().setValue(form.getGlobalContext().Core.getOutPatientSearchCriteria().getConsultant());
		}

		form.cmbLocation().setValue(form.getGlobalContext().Core.getOutPatientSearchCriteria().getLocation());
		form.cmbSpecialty().setValue(form.getGlobalContext().Core.getOutPatientSearchCriteria().getSpecialty());
		if (form.cmbLocation().getValue() != null && form.getGlobalContext().Core.getOutPatientSearchCriteria().getClinicIsNotNull())
		{
			form.qmbClinic().newRow(form.getGlobalContext().Core.getOutPatientSearchCriteria().getClinic(), form.getGlobalContext().Core.getOutPatientSearchCriteria().getClinic().getClinicName());
			form.qmbClinic().setValue(form.getGlobalContext().Core.getOutPatientSearchCriteria().getClinic());
		}

	}

	private void initialize()
	{
		form.getGlobalContext().Core.setOutpatientAttendanceForOrder(null);
		
		form.qmbClinic().setEnabled(false);

		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		form.grdOutPatient().setcolHospnumCaption(dispIdType.getText());
		loadClinicLocationCombo();

		form.qmbClinic().setVisible(true);
		form.qmbClinic().setEnabled(true);
		form.cmbClinic().setVisible(false);
		form.qmbConsultant().setVisible(true);
		form.cmbConsultant().setVisible(false);
			// WDEV-2847
		populateQmbConsultants();
	
		form.dteClinic().setValue(new Date());

	}

	private void loadClinicLocationCombo()
	{
		LocationLiteVoCollection voLocationLiteColl = domain.listActiveHospitalsLite();
		if (voLocationLiteColl != null)
		{
			String currentLocName = "";
			for (int i = 0; i < voLocationLiteColl.size(); i++)
			{
				form.cmbLocation().newRow(voLocationLiteColl.get(i), voLocationLiteColl.get(i).getName().toString());
				//WDEV-4585
				
				if (engine.getCurrentLocation() != null)
				{
					// WDEV-2847
					currentLocName = engine.getCurrentLocation().getName();
					if (currentLocName.equals(voLocationLiteColl.get(i).getName()))
					{
						form.cmbLocation().setValue(voLocationLiteColl.get(i));
						form.qmbClinic().setEnabled(true);
					}
				}
			}

		}

	}

	protected void onGrdOutPatientSelectionChanged() throws PresentationLogicException
	{
		// Set form selecting the Patient as Outpatient List
		form.getGlobalContext().Core.setSelectingPatientForm(engine.getFormName());

		OutPatientListVo outpatient = form.grdOutPatient().getValue();
		
		if (outpatient != null && outpatient.getPasEvent() != null && outpatient.getPasEvent().getPatient() != null)
		{
			form.getGlobalContext().Core.setPatientShort(null);
			form.getGlobalContext().Core.setPatientToBeDisplayed(outpatient.getPasEvent().getPatient());
			
			form.getGlobalContext().Core.setOutpatientAttendanceForOrder(outpatient);

			engine.open(ConfigFlag.UI.DEMOGRAPHICS_FORM.getValue());
		}
	}

	protected void onCmbLocationValueChanged() throws PresentationLogicException
	{
		if (form.cmbLocation().getValue() != null)
			form.qmbClinic().setEnabled(true);
		else
			form.qmbClinic().setEnabled(false);
		
		form.qmbClinic().clear();//WDEV-15039 WDEV-17679

	}

	private void clearClinicCombo()
	{
		form.qmbClinic().clear();

	}

	protected void onQmbConsultantTextSubmited(String value) throws PresentationLogicException
	{
		clearConsultantCombo();
		if (value != null)
		{
			MedicLiteVoCollection voMedicColl = domain.listActiveMedics(value);
			if (voMedicColl != null)
			{
				for (int i = 0; i < voMedicColl.size(); i++)
				{
					MedicLiteVo med = voMedicColl.get(i);
					form.qmbConsultant().newRow(med, med.toString());
				}
			}
			if (voMedicColl != null && voMedicColl.size() == 1)
				form.qmbConsultant().setValue(voMedicColl.get(0));
			else if (voMedicColl != null && voMedicColl.size() > 1)
				form.qmbConsultant().showOpened();
		}
	}

	// WDEV-2847
	private void populateQmbConsultants()
	{
		MedicLiteVo voMedic = new MedicLiteVo();
		//WDEV-8199
		HcpLiteVo currHcpUser = (HcpLiteVo) domain.getHcpLiteUser();
		
		if (domain.getHcpUser() instanceof MedicVo && MedicGrade.CONS.equals(((MedicVo)domain.getHcpUser()).getGrade()))
		{
			voMedic.setMos(currHcpUser.getMos());
			voMedic.setID_Hcp(currHcpUser.getID_Hcp());//wdev-10188
			form.qmbConsultant().newRow(voMedic, voMedic.getName().toString());
			form.qmbConsultant().setValue(voMedic);
		}
	}

	protected void onQmbClinicTextSubmited(String value) throws PresentationLogicException
	{
		if (form.cmbLocation().getValue() == null)
		{
			engine.showMessage("Please select a Location");
			form.cmbLocation().setFocus();
			return;
		}
		loadClinicsbyLocation(form.cmbLocation().getValue(), value);

	}

	private void loadClinicsbyLocation(LocationLiteVo voLocLite, String strClinicName)
	{
		clearClinicCombo();

		if (voLocLite != null)
		{
			ClinicLiteVoCollection voClinicLiteColl = domain.listClinicsforLocation(voLocLite, strClinicName);

			if (voClinicLiteColl != null)
			{
				for (int i = 0; i < voClinicLiteColl.size(); i++)
				{
					form.qmbClinic().newRow(voClinicLiteColl.get(i), voClinicLiteColl.get(i).getClinicName());
				}
				if (voClinicLiteColl.size() == 1)
					form.qmbClinic().setValue(voClinicLiteColl.get(0));
				else if (voClinicLiteColl.size() > 1)
					form.qmbClinic().showOpened();
			}
		}

	}
}
