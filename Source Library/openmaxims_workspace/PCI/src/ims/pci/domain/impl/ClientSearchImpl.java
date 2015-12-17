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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.62 build 3023.13950)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.pci.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.LocSiteLiteVoCollection;
import ims.core.vo.PatientFilter;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.pci.domain.base.impl.BaseClientSearchImpl;
import ims.pci.vo.ClientSearchVoCollection;
import ims.pci.vo.domain.ClientSearchVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class ClientSearchImpl extends BaseClientSearchImpl
{

	private static final long serialVersionUID = 1L;

	private String formatStringForSearch(String stringToFormat, int number) 
	{
		stringToFormat = stringToFormat.toUpperCase().trim();
		stringToFormat = stringToFormat.replaceAll("[^a-zA-Z]", "");
			
		if(stringToFormat.length() >= number)
			stringToFormat = stringToFormat.substring(0,number);
			
		stringToFormat += '%';
		return stringToFormat;
	}

	public LocSiteLiteVoCollection listCCAs()
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listCCAs();
	}


	public ClientSearchVoCollection searchClientsById(PatIdType clientIdType, String clientIdValue) throws DomainInterfaceException 
	{
		if(clientIdType == null)
			throw new CodingRuntimeException("Cannot search on null client id type!");
		
		if(clientIdValue == null)
			throw new CodingRuntimeException("Cannot search on null client id value!");
		
		boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue();  //WDEV-18817
		DomainFactory factory = getDomainFactory();
		List<?> clients = null;
		
		StringBuffer hql = new StringBuffer(" from Patient p " +
				" join p.identifiers as ids" +
				" where ids.type = :idType ");
		if (!isCaseSensitivePatIdSearch)  //WDEV-18817
		{	
			clientIdValue = clientIdValue.toUpperCase();
		}
		clientIdValue = clientIdValue.trim();		
		if (clientIdType.equals(PatIdType.NHSN))
		{
			hql.append(" and " + (!isCaseSensitivePatIdSearch ? "UPPER(ids.value)" :"ids.value") + " like :idValue"); //WDEV-18817
			clientIdValue += "%";
		}
		else
			hql.append(" and " + (!isCaseSensitivePatIdSearch ? "UPPER(ids.value)" :"ids.value") + " = :idValue"); //WDEV-18817
		
		hql.append(" and (p.isActive = :isActive or p.associatedPatient is not null) and (p.isRIE is null or p.isRIE = :isRecordInError)");
		
		clients = factory.find(hql.toString(), new String[]{"idValue", "idType", "isActive", "isRecordInError"}, new Object[]{clientIdValue, getDomLookup(clientIdType), Boolean.TRUE, Boolean.FALSE});
		
		ClientSearchVoCollection clientsColl = ClientSearchVoAssembler.createClientSearchVoCollectionFromPatient(clients);
		
		if(clientsColl != null)
		{
			for(int i=0; i<clientsColl.size(); i++)
			{
				if(clientsColl.get(i).getAge() == null)
					clientsColl.get(i).calculateAge();
			}
		}
		
		return clientsColl;
	}

	public ClientSearchVoCollection searchClient(PatientFilter filter) throws DomainInterfaceException 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from Patient p left join p.otherNames pOth";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		List clients = null;

		if(filter.getSurnameIsNotNull())
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
	//		hql.append("p.name.upperSurname like :surname");
			hql.append("( p.name.upperSurname like :surname");
			hql.append(" or pOth.upperSurname like :surname )");

			markers.add("surname");
		
			values.add(formatStringForSearch(filter.getSurname(), 40));
		}
		
		if(filter.getForenameIsNotNull())
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("p.name.upperForename like :forename");
			markers.add("forename");
			
			values.add(formatStringForSearch(filter.getForename(), 9));
		}
		
		if(filter.getDobIsNotNull() && ! filter.getDob().toString().equals("__/__/____"))
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("p.dob  between :dobFrom and :dobTo");
			
			markers.add("dobFrom");
			markers.add("dobTo");
			
			Integer[] range = filter.getDob().toSearchRange();
			values.add(range[0]);
			values.add(range[1]);
		}
		
		if(filter.getSexIsNotNull())
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("p.sex = :sex");
			
			markers.add("sex");
			values.add(getDomLookup(filter.getSex()));
		}
		
		if(filter.getAddressIsNotNull())
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("(upper(p.address.line1) like :partialAddress ");
			hql.append("or upper(p.address.line2) like :partialAddress");
			hql.append("or upper(p.address.line3) like :partialAddress");
			hql.append("or upper(p.address.line4) like :partialAddress");
			hql.append("or upper(p.address.line5) like :partialAddress )");
			
			markers.add("partialAddress");
			values.add(filter.getAddress().toUpperCase() + "%");
		}
		
		if(filter.getCCAIsNotNull())
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("p.communityCare.cca.id = :cca ");
			markers.add("cca");
			values.add(filter.getCCA().getID());
		}
		
		if(filter.getCountyIsNotNull())
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("p.address.county = :county ");
			markers.add("county");
			values.add(getDomLookup(filter.getCounty()));
		}
		
		if(markers.size() > 0)
			hql.append(" and ");
		
		hql.append(" (p.isActive = :isActive or p.associatedPatient is not null) and (p.isRIE is null or p.isRIE = :isRecordInError)");
		markers.add("isActive");
		values.add(Boolean.TRUE);
		markers.add("isRecordInError");
		values.add(Boolean.FALSE);
		
		if (markers.size() > 0)
			query += " where ";
		
		query += hql.toString();
		
		int maxPats = ConfigFlag.DOM.PAT_SEARCH_MAX_SIZE.getValue();
		clients = factory.find(query, markers, values, maxPats);
		
		ClientSearchVoCollection clientsColl = ClientSearchVoAssembler.createClientSearchVoCollectionFromPatient(clients);
		
		if(clientsColl != null)
		{
			for(int i=0; i<clientsColl.size(); i++)
			{
				if(clientsColl.get(i).getAge() == null)
					clientsColl.get(i).calculateAge();
			}
		}
		
		return clientsColl;
	}

}