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

package ims.ocrr.vo.beans;

public class RadiologyResultListVoBean extends ims.vo.ValueObjectBean
{
	public RadiologyResultListVoBean()
	{
	}
	public RadiologyResultListVoBean(ims.ocrr.vo.RadiologyResultListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.NewResultInvestigationVoBean)vo.getInvestigation().getBean();
		this.orderdetails = vo.getOrderDetails() == null ? null : (ims.ocrr.vo.beans.OcsOrderShortVoBean)vo.getOrderDetails().getBean();
		this.resultdemographics = vo.getResultDemographics() == null ? null : (ims.ocrr.vo.beans.ResultDemographicsVoBean)vo.getResultDemographics().getBean();
		this.reptimesupplied = vo.getRepTimeSupplied();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.displayflag = vo.getDisplayFlag() == null ? null : (ims.vo.LookupInstanceBean)vo.getDisplayFlag().getBean();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusClinicalImagingVoBean)vo.getOrdInvCurrentStatus().getBean();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAppointmentDate().getBean();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.ordinvxostatushistory = vo.getOrdInvXOStatusHistory() == null ? null : vo.getOrdInvXOStatusHistory().getBeanCollection();
		this.resultconclusioncomments = vo.getResultConclusionComments() == null ? null : vo.getResultConclusionComments().getBeanCollection();
		this.resultdetails = vo.getResultDetails() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForRadiologyResultListVoBean)vo.getResultDetails().getBean();
		this.allocatedhcpforreview = vo.getAllocatedHCPforReview() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAllocatedHCPforReview().getBean();
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPatientLocation().getBean();
		this.patientclinic = vo.getPatientClinic() == null ? null : new ims.vo.RefVoBean(vo.getPatientClinic().getBoId(), vo.getPatientClinic().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.RadiologyResultListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.NewResultInvestigationVoBean)vo.getInvestigation().getBean(map);
		this.orderdetails = vo.getOrderDetails() == null ? null : (ims.ocrr.vo.beans.OcsOrderShortVoBean)vo.getOrderDetails().getBean(map);
		this.resultdemographics = vo.getResultDemographics() == null ? null : (ims.ocrr.vo.beans.ResultDemographicsVoBean)vo.getResultDemographics().getBean(map);
		this.reptimesupplied = vo.getRepTimeSupplied();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.displayflag = vo.getDisplayFlag() == null ? null : (ims.vo.LookupInstanceBean)vo.getDisplayFlag().getBean();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusClinicalImagingVoBean)vo.getOrdInvCurrentStatus().getBean(map);
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAppointmentDate().getBean();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.ordinvxostatushistory = vo.getOrdInvXOStatusHistory() == null ? null : vo.getOrdInvXOStatusHistory().getBeanCollection();
		this.resultconclusioncomments = vo.getResultConclusionComments() == null ? null : vo.getResultConclusionComments().getBeanCollection();
		this.resultdetails = vo.getResultDetails() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForRadiologyResultListVoBean)vo.getResultDetails().getBean(map);
		this.allocatedhcpforreview = vo.getAllocatedHCPforReview() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAllocatedHCPforReview().getBean(map);
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPatientLocation().getBean(map);
		this.patientclinic = vo.getPatientClinic() == null ? null : new ims.vo.RefVoBean(vo.getPatientClinic().getBoId(), vo.getPatientClinic().getBoVersion());
	}

	public ims.ocrr.vo.RadiologyResultListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.RadiologyResultListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.RadiologyResultListVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.RadiologyResultListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.RadiologyResultListVo();
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
	public ims.ocrr.vo.beans.NewResultInvestigationVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.beans.NewResultInvestigationVoBean value)
	{
		this.investigation = value;
	}
	public ims.ocrr.vo.beans.OcsOrderShortVoBean getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.beans.OcsOrderShortVoBean value)
	{
		this.orderdetails = value;
	}
	public ims.ocrr.vo.beans.ResultDemographicsVoBean getResultDemographics()
	{
		return this.resultdemographics;
	}
	public void setResultDemographics(ims.ocrr.vo.beans.ResultDemographicsVoBean value)
	{
		this.resultdemographics = value;
	}
	public Boolean getRepTimeSupplied()
	{
		return this.reptimesupplied;
	}
	public void setRepTimeSupplied(Boolean value)
	{
		this.reptimesupplied = value;
	}
	public ims.vo.LookupInstanceBean getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.vo.LookupInstanceBean value)
	{
		this.resultstatus = value;
	}
	public ims.vo.LookupInstanceBean getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.vo.LookupInstanceBean value)
	{
		this.displayflag = value;
	}
	public ims.ocrr.vo.beans.OrderedInvestigationStatusClinicalImagingVoBean getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.beans.OrderedInvestigationStatusClinicalImagingVoBean value)
	{
		this.ordinvcurrentstatus = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.displaydatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.appointmentdate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.repdatetime = value;
	}
	public ims.ocrr.vo.beans.OrdInvXOStatusHistoryLiteVoBean[] getOrdInvXOStatusHistory()
	{
		return this.ordinvxostatushistory;
	}
	public void setOrdInvXOStatusHistory(ims.ocrr.vo.beans.OrdInvXOStatusHistoryLiteVoBean[] value)
	{
		this.ordinvxostatushistory = value;
	}
	public ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] getResultConclusionComments()
	{
		return this.resultconclusioncomments;
	}
	public void setResultConclusionComments(ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] value)
	{
		this.resultconclusioncomments = value;
	}
	public ims.ocrr.vo.beans.ResultDetailsForRadiologyResultListVoBean getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.beans.ResultDetailsForRadiologyResultListVoBean value)
	{
		this.resultdetails = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getAllocatedHCPforReview()
	{
		return this.allocatedhcpforreview;
	}
	public void setAllocatedHCPforReview(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.allocatedhcpforreview = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.patientlocation = value;
	}
	public ims.vo.RefVoBean getPatientClinic()
	{
		return this.patientclinic;
	}
	public void setPatientClinic(ims.vo.RefVoBean value)
	{
		this.patientclinic = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.NewResultInvestigationVoBean investigation;
	private ims.ocrr.vo.beans.OcsOrderShortVoBean orderdetails;
	private ims.ocrr.vo.beans.ResultDemographicsVoBean resultdemographics;
	private Boolean reptimesupplied;
	private ims.vo.LookupInstanceBean resultstatus;
	private ims.vo.LookupInstanceBean displayflag;
	private ims.ocrr.vo.beans.OrderedInvestigationStatusClinicalImagingVoBean ordinvcurrentstatus;
	private ims.framework.utils.beans.DateTimeBean displaydatetime;
	private ims.framework.utils.beans.DateTimeBean appointmentdate;
	private ims.framework.utils.beans.DateTimeBean repdatetime;
	private ims.ocrr.vo.beans.OrdInvXOStatusHistoryLiteVoBean[] ordinvxostatushistory;
	private ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] resultconclusioncomments;
	private ims.ocrr.vo.beans.ResultDetailsForRadiologyResultListVoBean resultdetails;
	private ims.core.vo.beans.HcpLiteVoBean allocatedhcpforreview;
	private ims.core.vo.beans.LocationLiteVoBean patientlocation;
	private ims.vo.RefVoBean patientclinic;
}
