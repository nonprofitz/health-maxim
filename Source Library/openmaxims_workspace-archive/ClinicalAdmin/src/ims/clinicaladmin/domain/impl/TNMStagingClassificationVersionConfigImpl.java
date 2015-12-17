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
// This code was generated by Andrei Stefan Bondar using IMS Development Environment (version 1.80 build 4041.27591)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import java.util.List;

import ims.clinicaladmin.domain.base.impl.BaseTNMStagingClassificationVersionConfigImpl;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.oncology.configuration.domain.objects.TNMStagingClassificationVersion;
import ims.oncology.vo.domain.TNMStagingClassificationVersionVoAssembler;

public class TNMStagingClassificationVersionConfigImpl extends BaseTNMStagingClassificationVersionConfigImpl
{

	private static final long serialVersionUID = 1L;

	public ims.oncology.vo.TNMStagingClassificationVersionVoCollection listClassificationVersions()
	{		
		DomainFactory factory = getDomainFactory();	
		
		String query = "from TNMStagingClassificationVersion as tnm order by versionNumber";
		
		return TNMStagingClassificationVersionVoAssembler.createTNMStagingClassificationVersionVoCollectionFromTNMStagingClassificationVersion(factory.find(query));
	}

	public ims.oncology.vo.TNMStagingClassificationVersionVo getClassificationVersion(ims.oncology.configuration.vo.TNMStagingClassificationVersionRefVo classificationVersionRefVo)
	{
		if(classificationVersionRefVo == null)
			return null;
		
		DomainFactory factory = getDomainFactory();		
		
		return TNMStagingClassificationVersionVoAssembler.create((TNMStagingClassificationVersion) factory.getDomainObject(TNMStagingClassificationVersion.class, classificationVersionRefVo.getID_TNMStagingClassificationVersion()));
	}

	public ims.oncology.vo.TNMStagingClassificationVersionVo saveClassificationVersion(ims.oncology.vo.TNMStagingClassificationVersionVo classificationVersionVo) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException
	{
		if(classificationVersionVo == null)
			throw new DomainRuntimeException("classificationVersionVo parameter is null in method saveClassificationVersion");
		
		if(!classificationVersionVo.isValidated())
			throw new DomainRuntimeException("This Classification Version has not been validated");
		
		DomainFactory factory = getDomainFactory();
		
		String query = new String();
		if (classificationVersionVo.getID_TNMStagingClassificationVersionIsNotNull())
			query = "from TNMStagingClassificationVersion as tnm where tnm.versionNumber = '" + classificationVersionVo.getVersionNumber() + "' and tnm.id <> " + classificationVersionVo.getID_TNMStagingClassificationVersion().toString() + " and tnm.isRIE is null";
		else
			query = "from TNMStagingClassificationVersion as tnm where tnm.versionNumber = '" + classificationVersionVo.getVersionNumber() + "' and tnm.isRIE is null";

		List results = factory.find(query);
		if (results != null && results.size() > 0)
			throw new UniqueKeyViolationException("Another Classification Version with the same Version Number already exists in the system");
		
		TNMStagingClassificationVersion doClassificationVersion = TNMStagingClassificationVersionVoAssembler.extractTNMStagingClassificationVersion(factory, classificationVersionVo);
		factory.save(doClassificationVersion);

		return TNMStagingClassificationVersionVoAssembler.create(doClassificationVersion);
	}
}