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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4198.17562)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.oncology.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.nursing.vo.CarePlanCollection;
import ims.nursing.vo.domain.CarePlanAssembler;
import ims.oncology.domain.base.impl.BaseChemoCycleDrugDetailsImpl;
import ims.oncology.vo.ChemoRegimensDrugConfigVo;
import ims.oncology.vo.ChemoRegimensDrugConfigVoCollection;
import ims.oncology.vo.ChemoTherapyDayDetailsVo;
import ims.oncology.vo.ChemoTherapyDayDetailsVoCollection;
import ims.oncology.vo.ChemotherapyCycleDetailsRefVo;
import ims.oncology.vo.domain.ChemoRegimensDrugConfigVoAssembler;
import ims.oncology.vo.domain.ChemoTherapyDayDetailsVoAssembler;
import ims.oncology.vo.domain.RadiotherapyDetailsShortVoAssembler;

public class ChemoCycleDrugDetailsImpl extends BaseChemoCycleDrugDetailsImpl
{

	private static final long serialVersionUID = 1L;

	//wdev-12819
	public ims.oncology.vo.ChemoRegimensDrugConfigVo getChemoRegimenConfig(Integer regimenId)
	{
		if(regimenId == null)
			return null;
		// Build query (for complex queries - that depend on conditions - remember to change to StringBuilder)
		String query = "select c1_1 from ChemoRegimensDrugConfig as c1_1 left join c1_1.regimen as l1_1 where (l1_1.id = :REG_ID) ";

		// Build parameters (names and values)
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		paramNames.add("REG_ID");
		paramValues.add(regimenId);
		List list = getDomainFactory().find(query, paramNames, paramValues);
		
		if(list != null && list.size() > 0)
		{ 
			ChemoRegimensDrugConfigVoCollection voColl = ChemoRegimensDrugConfigVoAssembler.createChemoRegimensDrugConfigVoCollectionFromChemoRegimensDrugConfig(list);
			if(voColl != null && voColl.size() > 0)
				return voColl.get(0);
		}
		return null;
		
	}

	//wdev-12819
	public ChemoTherapyDayDetailsVo getChemoTherapyDayDetails(ChemotherapyCycleDetailsRefVo chemoCycleDetailsRefVo) 
	{
		if(chemoCycleDetailsRefVo == null)
			return null;
		
		String query = "select c2_1 from ChemotherapyCycleDetails as c1_1 left join c1_1.dayDetails as c2_1 where (c1_1.id = :CYCLE_ID and c2_1.dayNumber = (select max (xc2_1.dayNumber) from ChemotherapyCycleDetails as xc1_1 left join xc1_1.dayDetails as xc2_1  where xc1_1.id=c1_1.id)) ) ";

		// Build parameters (names and values)
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		paramNames.add("CYCLE_ID");
		paramValues.add(chemoCycleDetailsRefVo.getID_ChemotherapyCycleDetails());
		List list = getDomainFactory().find(query, paramNames, paramValues);
		
		if(list != null && list.size() > 0)
		{ 
			ChemoTherapyDayDetailsVoCollection voColl = ChemoTherapyDayDetailsVoAssembler.createChemoTherapyDayDetailsVoCollectionFromChemoTherapyDayDetails(list);
			if(voColl != null && voColl.size() > 0)
				return voColl.get(0);
		}
		return null;
	}

	
}