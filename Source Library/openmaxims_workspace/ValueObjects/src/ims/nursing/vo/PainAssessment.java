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

package ims.nursing.vo;

/**
 * Linked to core.clinical.Assessment business object (ID: 1003100002).
 */
public class PainAssessment extends ims.core.vo.AssessmentVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PainAssessment()
	{
	}
	public PainAssessment(Integer id, int version)
	{
		super(id, version);
	}
	public PainAssessment(ims.nursing.vo.beans.PainAssessmentBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo();
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.sitedetails = ims.nursing.vo.PainAssessmentFindingsCollection.buildFromBeanCollection(bean.getSiteDetails());
		this.assessmentdatetime = bean.getAssessmentDateTime() == null ? null : bean.getAssessmentDateTime().buildDateTime();
		this.imageversion = bean.getImageVersion() == null ? null : bean.getImageVersion().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.PainAssessmentBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcpinitiated = bean.getHcpInitiated() == null ? null : bean.getHcpInitiated().buildVo(map);
		this.datetimeinitiated = bean.getDateTimeInitiated() == null ? null : bean.getDateTimeInitiated().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.sitedetails = ims.nursing.vo.PainAssessmentFindingsCollection.buildFromBeanCollection(bean.getSiteDetails());
		this.assessmentdatetime = bean.getAssessmentDateTime() == null ? null : bean.getAssessmentDateTime().buildDateTime();
		this.imageversion = bean.getImageVersion() == null ? null : bean.getImageVersion().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.PainAssessmentBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.PainAssessmentBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.PainAssessmentBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("SITEDETAILS"))
			return getSiteDetails();
		if(fieldName.equals("ASSESSMENTDATETIME"))
			return getAssessmentDateTime();
		if(fieldName.equals("IMAGEVERSION"))
			return getImageVersion();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSiteDetailsIsNotNull()
	{
		return this.sitedetails != null;
	}
	public ims.nursing.vo.PainAssessmentFindingsCollection getSiteDetails()
	{
		return this.sitedetails;
	}
	public void setSiteDetails(ims.nursing.vo.PainAssessmentFindingsCollection value)
	{
		this.isValidated = false;
		this.sitedetails = value;
	}
	public boolean getAssessmentDateTimeIsNotNull()
	{
		return this.assessmentdatetime != null;
	}
	public ims.framework.utils.DateTime getAssessmentDateTime()
	{
		return this.assessmentdatetime;
	}
	public void setAssessmentDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.assessmentdatetime = value;
	}
	public boolean getImageVersionIsNotNull()
	{
		return this.imageversion != null;
	}
	public ims.core.vo.DrawingImageVersionVo getImageVersion()
	{
		return this.imageversion;
	}
	public void setImageVersion(ims.core.vo.DrawingImageVersionVo value)
	{
		this.isValidated = false;
		this.imageversion = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.sitedetails != null)
		{
			if(!this.sitedetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.imageversion != null)
		{
			if(!this.imageversion.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.sitedetails != null)
		{
			String[] listOfOtherErrors = this.sitedetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.imageversion != null)
		{
			String[] listOfOtherErrors = this.imageversion.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PainAssessment clone = new PainAssessment(this.id, this.version);
		
		if(this.hcpinitiated == null)
			clone.hcpinitiated = null;
		else
			clone.hcpinitiated = (ims.core.vo.HcpLiteVo)this.hcpinitiated.clone();
		if(this.datetimeinitiated == null)
			clone.datetimeinitiated = null;
		else
			clone.datetimeinitiated = (ims.framework.utils.DateTime)this.datetimeinitiated.clone();
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		if(this.sitedetails == null)
			clone.sitedetails = null;
		else
			clone.sitedetails = (ims.nursing.vo.PainAssessmentFindingsCollection)this.sitedetails.clone();
		if(this.assessmentdatetime == null)
			clone.assessmentdatetime = null;
		else
			clone.assessmentdatetime = (ims.framework.utils.DateTime)this.assessmentdatetime.clone();
		if(this.imageversion == null)
			clone.imageversion = null;
		else
			clone.imageversion = (ims.core.vo.DrawingImageVersionVo)this.imageversion.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PainAssessment.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PainAssessment object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PainAssessment compareObj = (PainAssessment)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDateTimeInitiated() == null && compareObj.getDateTimeInitiated() != null)
				return -1;
			if(this.getDateTimeInitiated() != null && compareObj.getDateTimeInitiated() == null)
				return 1;
			if(this.getDateTimeInitiated() != null && compareObj.getDateTimeInitiated() != null)
				retVal = this.getDateTimeInitiated().compareTo(compareObj.getDateTimeInitiated());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.sitedetails != null)
			count++;
		if(this.assessmentdatetime != null)
			count++;
		if(this.imageversion != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.nursing.vo.PainAssessmentFindingsCollection sitedetails;
	protected ims.framework.utils.DateTime assessmentdatetime;
	protected ims.core.vo.DrawingImageVersionVo imageversion;
	private boolean isValidated = false;
	private boolean isBusy = false;
}