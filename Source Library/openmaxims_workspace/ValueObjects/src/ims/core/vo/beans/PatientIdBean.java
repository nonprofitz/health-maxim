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

public class PatientIdBean extends ims.vo.ValueObjectBean
{
	public PatientIdBean()
	{
	}
	public PatientIdBean(ims.core.vo.PatientId vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.idvalue = vo.getIdValue();
		this.verified = vo.getVerified();
		this.merged = vo.getMerged();
		this.duplicatenhsnum = vo.getDuplicateNHSNum();
		this.beffdate = vo.getBeffdate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getBeffdate().getBean();
		this.beffdatecnf = vo.getBeffdatecnf();
		this.betdate = vo.getBetdate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getBetdate().getBean();
		this.betdatecnf = vo.getBetdatecnf();
		this.superseeded = vo.getSuperseeded();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientId vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.idvalue = vo.getIdValue();
		this.verified = vo.getVerified();
		this.merged = vo.getMerged();
		this.duplicatenhsnum = vo.getDuplicateNHSNum();
		this.beffdate = vo.getBeffdate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getBeffdate().getBean();
		this.beffdatecnf = vo.getBeffdatecnf();
		this.betdate = vo.getBetdate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getBetdate().getBean();
		this.betdatecnf = vo.getBetdatecnf();
		this.superseeded = vo.getSuperseeded();
	}

	public ims.core.vo.PatientId buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientId buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientId vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientId)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientId();
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
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public String getIdValue()
	{
		return this.idvalue;
	}
	public void setIdValue(String value)
	{
		this.idvalue = value;
	}
	public Boolean getVerified()
	{
		return this.verified;
	}
	public void setVerified(Boolean value)
	{
		this.verified = value;
	}
	public Boolean getMerged()
	{
		return this.merged;
	}
	public void setMerged(Boolean value)
	{
		this.merged = value;
	}
	public Integer getDuplicateNHSNum()
	{
		return this.duplicatenhsnum;
	}
	public void setDuplicateNHSNum(Integer value)
	{
		this.duplicatenhsnum = value;
	}
	public ims.framework.utils.beans.DateBean getBeffdate()
	{
		return this.beffdate;
	}
	public void setBeffdate(ims.framework.utils.beans.DateBean value)
	{
		this.beffdate = value;
	}
	public Boolean getBeffdatecnf()
	{
		return this.beffdatecnf;
	}
	public void setBeffdatecnf(Boolean value)
	{
		this.beffdatecnf = value;
	}
	public ims.framework.utils.beans.DateBean getBetdate()
	{
		return this.betdate;
	}
	public void setBetdate(ims.framework.utils.beans.DateBean value)
	{
		this.betdate = value;
	}
	public Boolean getBetdatecnf()
	{
		return this.betdatecnf;
	}
	public void setBetdatecnf(Boolean value)
	{
		this.betdatecnf = value;
	}
	public Boolean getSuperseeded()
	{
		return this.superseeded;
	}
	public void setSuperseeded(Boolean value)
	{
		this.superseeded = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean type;
	private String idvalue;
	private Boolean verified;
	private Boolean merged;
	private Integer duplicatenhsnum;
	private ims.framework.utils.beans.DateBean beffdate;
	private Boolean beffdatecnf;
	private ims.framework.utils.beans.DateBean betdate;
	private Boolean betdatecnf;
	private Boolean superseeded;
}
