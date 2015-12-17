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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo.beans;

public class TrackingMovementVoBean extends ims.vo.ValueObjectBean
{
	public TrackingMovementVoBean()
	{
	}
	public TrackingMovementVoBean(ims.core.vo.TrackingMovementVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.movementtype = vo.getMovementType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMovementType().getBean();
		this.patientreturned = vo.getPatientReturned();
		this.leftwardtime = vo.getLeftWardTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLeftWardTime().getBean();
		this.expectedreturntime = vo.getExpectedReturnTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedReturnTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.TrackingMovementVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.movementtype = vo.getMovementType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMovementType().getBean();
		this.patientreturned = vo.getPatientReturned();
		this.leftwardtime = vo.getLeftWardTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLeftWardTime().getBean();
		this.expectedreturntime = vo.getExpectedReturnTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedReturnTime().getBean();
	}

	public ims.core.vo.TrackingMovementVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.TrackingMovementVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.TrackingMovementVo vo = null;
		if(map != null)
			vo = (ims.core.vo.TrackingMovementVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.TrackingMovementVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.LookupInstanceBean getMovementType()
	{
		return this.movementtype;
	}
	public void setMovementType(ims.vo.LookupInstanceBean value)
	{
		this.movementtype = value;
	}
	public Boolean getPatientReturned()
	{
		return this.patientreturned;
	}
	public void setPatientReturned(Boolean value)
	{
		this.patientreturned = value;
	}
	public ims.framework.utils.beans.DateTimeBean getLeftWardTime()
	{
		return this.leftwardtime;
	}
	public void setLeftWardTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.leftwardtime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getExpectedReturnTime()
	{
		return this.expectedreturntime;
	}
	public void setExpectedReturnTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.expectedreturntime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean movementtype;
	private Boolean patientreturned;
	private ims.framework.utils.beans.DateTimeBean leftwardtime;
	private ims.framework.utils.beans.DateTimeBean expectedreturntime;
}