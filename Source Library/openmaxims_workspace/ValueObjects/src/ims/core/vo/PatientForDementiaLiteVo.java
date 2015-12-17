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

package ims.core.vo;

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientForDementiaLiteVo extends ims.core.patient.vo.PatientRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientForDementiaLiteVo()
	{
	}
	public PatientForDementiaLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientForDementiaLiteVo(ims.core.vo.beans.PatientForDementiaLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dementiabreachdatetime = bean.getDementiaBreachDateTime() == null ? null : bean.getDementiaBreachDateTime().buildDateTime();
		this.dementiaworkliststatus = bean.getDementiaWorklistStatus() == null ? null : ims.core.vo.lookups.DementiaWorklistStatus.buildLookup(bean.getDementiaWorklistStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientForDementiaLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dementiabreachdatetime = bean.getDementiaBreachDateTime() == null ? null : bean.getDementiaBreachDateTime().buildDateTime();
		this.dementiaworkliststatus = bean.getDementiaWorklistStatus() == null ? null : ims.core.vo.lookups.DementiaWorklistStatus.buildLookup(bean.getDementiaWorklistStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientForDementiaLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientForDementiaLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientForDementiaLiteVoBean();
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
		if(fieldName.equals("DEMENTIABREACHDATETIME"))
			return getDementiaBreachDateTime();
		if(fieldName.equals("DEMENTIAWORKLISTSTATUS"))
			return getDementiaWorklistStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDementiaBreachDateTimeIsNotNull()
	{
		return this.dementiabreachdatetime != null;
	}
	public ims.framework.utils.DateTime getDementiaBreachDateTime()
	{
		return this.dementiabreachdatetime;
	}
	public void setDementiaBreachDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dementiabreachdatetime = value;
	}
	public boolean getDementiaWorklistStatusIsNotNull()
	{
		return this.dementiaworkliststatus != null;
	}
	public ims.core.vo.lookups.DementiaWorklistStatus getDementiaWorklistStatus()
	{
		return this.dementiaworkliststatus;
	}
	public void setDementiaWorklistStatus(ims.core.vo.lookups.DementiaWorklistStatus value)
	{
		this.isValidated = false;
		this.dementiaworkliststatus = value;
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
	
		PatientForDementiaLiteVo clone = new PatientForDementiaLiteVo(this.id, this.version);
		
		if(this.dementiabreachdatetime == null)
			clone.dementiabreachdatetime = null;
		else
			clone.dementiabreachdatetime = (ims.framework.utils.DateTime)this.dementiabreachdatetime.clone();
		if(this.dementiaworkliststatus == null)
			clone.dementiaworkliststatus = null;
		else
			clone.dementiaworkliststatus = (ims.core.vo.lookups.DementiaWorklistStatus)this.dementiaworkliststatus.clone();
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
		if (!(PatientForDementiaLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientForDementiaLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientForDementiaLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientForDementiaLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.dementiabreachdatetime != null)
			count++;
		if(this.dementiaworkliststatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.framework.utils.DateTime dementiabreachdatetime;
	protected ims.core.vo.lookups.DementiaWorklistStatus dementiaworkliststatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}