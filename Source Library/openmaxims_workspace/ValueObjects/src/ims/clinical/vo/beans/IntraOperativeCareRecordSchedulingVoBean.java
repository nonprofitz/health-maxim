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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo.beans;

public class IntraOperativeCareRecordSchedulingVoBean extends ims.vo.ValueObjectBean
{
	public IntraOperativeCareRecordSchedulingVoBean()
	{
	}
	public IntraOperativeCareRecordSchedulingVoBean(ims.clinical.vo.IntraOperativeCareRecordSchedulingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.intopacutime = vo.getIntoPacuTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getIntoPacuTime().getBean();
		this.anaesthetiststarttime = vo.getAnaesthetistStartTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAnaesthetistStartTime().getBean();
		this.intheatretime = vo.getInTheatreTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getInTheatreTime().getBean();
		this.surgerystarttime = vo.getSurgeryStartTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSurgeryStartTime().getBean();
		this.surgeryendtime = vo.getSurgeryEndTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSurgeryEndTime().getBean();
		this.timeintorecovery = vo.getTimeIntoRecovery() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTimeIntoRecovery().getBean();
		this.timeoutofrecovery = vo.getTimeOutOfRecovery() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTimeOutOfRecovery().getBean();
		this.proceduredate = vo.getProcedureDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getProcedureDate().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.IntraOperativeCareRecordSchedulingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.intopacutime = vo.getIntoPacuTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getIntoPacuTime().getBean();
		this.anaesthetiststarttime = vo.getAnaesthetistStartTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAnaesthetistStartTime().getBean();
		this.intheatretime = vo.getInTheatreTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getInTheatreTime().getBean();
		this.surgerystarttime = vo.getSurgeryStartTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSurgeryStartTime().getBean();
		this.surgeryendtime = vo.getSurgeryEndTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSurgeryEndTime().getBean();
		this.timeintorecovery = vo.getTimeIntoRecovery() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTimeIntoRecovery().getBean();
		this.timeoutofrecovery = vo.getTimeOutOfRecovery() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTimeOutOfRecovery().getBean();
		this.proceduredate = vo.getProcedureDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getProcedureDate().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public ims.clinical.vo.IntraOperativeCareRecordSchedulingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.IntraOperativeCareRecordSchedulingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.IntraOperativeCareRecordSchedulingVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.IntraOperativeCareRecordSchedulingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.IntraOperativeCareRecordSchedulingVo();
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
	public ims.framework.utils.beans.DateTimeBean getIntoPacuTime()
	{
		return this.intopacutime;
	}
	public void setIntoPacuTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.intopacutime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAnaesthetistStartTime()
	{
		return this.anaesthetiststarttime;
	}
	public void setAnaesthetistStartTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.anaesthetiststarttime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getInTheatreTime()
	{
		return this.intheatretime;
	}
	public void setInTheatreTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.intheatretime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getSurgeryStartTime()
	{
		return this.surgerystarttime;
	}
	public void setSurgeryStartTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.surgerystarttime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getSurgeryEndTime()
	{
		return this.surgeryendtime;
	}
	public void setSurgeryEndTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.surgeryendtime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTimeIntoRecovery()
	{
		return this.timeintorecovery;
	}
	public void setTimeIntoRecovery(ims.framework.utils.beans.DateTimeBean value)
	{
		this.timeintorecovery = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTimeOutOfRecovery()
	{
		return this.timeoutofrecovery;
	}
	public void setTimeOutOfRecovery(ims.framework.utils.beans.DateTimeBean value)
	{
		this.timeoutofrecovery = value;
	}
	public ims.framework.utils.beans.DateBean getProcedureDate()
	{
		return this.proceduredate;
	}
	public void setProcedureDate(ims.framework.utils.beans.DateBean value)
	{
		this.proceduredate = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean intopacutime;
	private ims.framework.utils.beans.DateTimeBean anaesthetiststarttime;
	private ims.framework.utils.beans.DateTimeBean intheatretime;
	private ims.framework.utils.beans.DateTimeBean surgerystarttime;
	private ims.framework.utils.beans.DateTimeBean surgeryendtime;
	private ims.framework.utils.beans.DateTimeBean timeintorecovery;
	private ims.framework.utils.beans.DateTimeBean timeoutofrecovery;
	private ims.framework.utils.beans.DateBean proceduredate;
	private ims.vo.SysInfoBean sysinfo;
}