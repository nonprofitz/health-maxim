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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.70 build 3314.22227)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseDMDVTMSelectionImpl;
import ims.clinical.vo.domain.VTMVoAssembler;
import ims.domain.DomainFactory;

public class DMDVTMSelectionImpl extends BaseDMDVTMSelectionImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Search for VTM
	*/
	public ims.clinical.vo.VTMVoCollection searchVTMByName(String name) throws ims.domain.exceptions.DomainInterfaceException
	{
		if(name == null || name.trim().length() == 0)
			return null;
		
		DomainFactory domainFactory = getDomainFactory();
		
		return VTMVoAssembler.createVTMVoCollectionFromVTM(domainFactory.find("from VTM vt WHERE vt.name like '" + name + "%'"));			
	}
}
