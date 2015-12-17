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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 50211.900)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;

import ims.core.clinical.domain.objects.PatientConcern;
import ims.core.clinical.vo.PatientConcernRefVo;
import ims.core.vo.PatientCurrentConcernVo;
import ims.core.vo.PatientCurrentConcernVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.PatientCurrentConcernVoAssembler;
import ims.core.vo.lookups.PatientConcernStatus;
import ims.domain.DomainFactory;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.interfaces.IMos;

public class MedConcernOnAdmisImpl extends DomainImpl implements ims.spinalinjuries.domain.MedConcernOnAdmis, ims.domain.impl.Transactional
{

	public PatientCurrentConcernVoCollection listPatientConcern(PatientShort patient, IMos voHcp, PatientConcernStatus patientConcernStatus) 
	{
		if(patient == null)
			throw new CodingRuntimeException("Patient is mandatory in method listPatientConcern");
		
		DomainFactory factory = getDomainFactory();
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		StringBuffer condStr = new StringBuffer();
		
		String hql = "from PatientConcern conc where conc.careContext.episodeOfCare.careSpell.patient.id = '" + patient.getID_Patient() + "'";
		
		if(voHcp != null && voHcp.getIMosHcpId() != null)
		{
			condStr.append(" and conc.allocToTeamMember.id = :idHcp");
 			markers.add("idHcp");
			values.add(voHcp.getIMosHcpId());
		}
		
		if(patientConcernStatus != null)
		{
			condStr.append(" and conc.concernStatus = :status");
 			markers.add("status");
			values.add(getDomLookup(patientConcernStatus));	
		}
			
		hql += condStr.toString();
		return PatientCurrentConcernVoAssembler.createPatientCurrentConcernVoCollectionFromPatientConcern(factory.find(hql,markers,values)).sort();
	}

	public PatientCurrentConcernVo getConcern(PatientConcernRefVo concernId) 
	{
		if(concernId == null || !concernId.getID_PatientConcernIsNotNull())
			throw new CodingRuntimeException("Can not get PatientConcern on null Id.");
		
		return PatientCurrentConcernVoAssembler.create((PatientConcern) getDomainFactory().getDomainObject(PatientConcern.class, concernId.getID_PatientConcern())); 
	}
	
}