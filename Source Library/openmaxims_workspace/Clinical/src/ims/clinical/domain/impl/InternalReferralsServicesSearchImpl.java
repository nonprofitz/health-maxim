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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseInternalReferralsServicesSearchImpl;
import ims.clinical.vo.ServiceConfigIntReferralForIncomingListVoCollection;
import ims.clinical.vo.ServiceForIncomingReferralListVoCollection;
import ims.clinical.vo.domain.ServiceConfigIntReferralForIncomingListVoAssembler;
import ims.clinical.vo.domain.ServiceForIncomingReferralListVoAssembler;
import ims.core.vo.lookups.ServiceCategory;
import ims.domain.DomainFactory;

import java.util.ArrayList;

public class InternalReferralsServicesSearchImpl extends BaseInternalReferralsServicesSearchImpl
{

	private static final long serialVersionUID = 1L;

	public ServiceConfigIntReferralForIncomingListVoCollection listServiceConfigs() 
	{
		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer("select serviceC from ServiceConfigIntReferral as serviceC left join serviceC.service as s where serviceC.active = :isActive ");

		markers.add("isActive");
		values.add(Boolean.TRUE);

		hql.append(" order by s.upperName asc"); //WDEV-20219  UPPER(s.serviceName)

		return ServiceConfigIntReferralForIncomingListVoAssembler.createServiceConfigIntReferralForIncomingListVoCollectionFromServiceConfigIntReferral(factory.find(hql.toString(), markers, values));
	}

	public ServiceForIncomingReferralListVoCollection listServices() 
	{
		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "select service from Service as service left join service.serviceCategory as servCateg where service.isActive = :isActive and servCateg.id = :serviceCategId ";

		markers.add("isActive");
		values.add(Boolean.TRUE);
		
		markers.add("serviceCategId");
		values.add(ServiceCategory.CLINICAL.getID());
		
		hql += " order by service.serviceName asc";

		return ServiceForIncomingReferralListVoAssembler.createServiceForIncomingReferralListVoCollectionFromService(factory.find(hql, markers, values));
	}
}