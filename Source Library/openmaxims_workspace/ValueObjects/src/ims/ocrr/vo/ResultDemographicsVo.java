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

package ims.ocrr.vo;

/**
 * Linked to core.patient.MinDemographics business object (ID: 1001100011).
 */
public class ResultDemographicsVo extends ims.core.patient.vo.MinDemographicsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ResultDemographicsVo()
	{
	}
	public ResultDemographicsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ResultDemographicsVo(ims.ocrr.vo.beans.ResultDemographicsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.nhsnumber = bean.getNhsNumber();
		this.hospnum = bean.getHospNum();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ResultDemographicsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.nhsnumber = bean.getNhsNumber();
		this.hospnum = bean.getHospNum();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ResultDemographicsVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ResultDemographicsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ResultDemographicsVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("DOB"))
			return getDob();
		if(fieldName.equals("SEX"))
			return getSex();
		if(fieldName.equals("NHSNUMBER"))
			return getNhsNumber();
		if(fieldName.equals("HOSPNUM"))
			return getHospNum();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getDobIsNotNull()
	{
		return this.dob != null;
	}
	public ims.framework.utils.PartialDate getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.dob = value;
	}
	public boolean getSexIsNotNull()
	{
		return this.sex != null;
	}
	public ims.core.vo.lookups.Sex getSex()
	{
		return this.sex;
	}
	public void setSex(ims.core.vo.lookups.Sex value)
	{
		this.isValidated = false;
		this.sex = value;
	}
	public boolean getNhsNumberIsNotNull()
	{
		return this.nhsnumber != null;
	}
	public String getNhsNumber()
	{
		return this.nhsnumber;
	}
	public static int getNhsNumberMaxLength()
	{
		return 20;
	}
	public void setNhsNumber(String value)
	{
		this.isValidated = false;
		this.nhsnumber = value;
	}
	public boolean getHospNumIsNotNull()
	{
		return this.hospnum != null;
	}
	public String getHospNum()
	{
		return this.hospnum;
	}
	public static int getHospNumMaxLength()
	{
		return 30;
	}
	public void setHospNum(String value)
	{
		this.isValidated = false;
		this.hospnum = value;
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
		if(this.name != null)
		{
			if(!this.name.isValidated())
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
		if(this.name != null)
		{
			String[] listOfOtherErrors = this.name.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.nhsnumber != null)
			if(this.nhsnumber.length() > 20)
				listOfErrors.add("The length of the field [nhsnumber] in the value object [ims.ocrr.vo.ResultDemographicsVo] is too big. It should be less or equal to 20");
		if(this.hospnum != null)
			if(this.hospnum.length() > 30)
				listOfErrors.add("The length of the field [hospnum] in the value object [ims.ocrr.vo.ResultDemographicsVo] is too big. It should be less or equal to 30");
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
	
		ResultDemographicsVo clone = new ResultDemographicsVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.dob == null)
			clone.dob = null;
		else
			clone.dob = (ims.framework.utils.PartialDate)this.dob.clone();
		if(this.sex == null)
			clone.sex = null;
		else
			clone.sex = (ims.core.vo.lookups.Sex)this.sex.clone();
		clone.nhsnumber = this.nhsnumber;
		clone.hospnum = this.hospnum;
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
		if (!(ResultDemographicsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ResultDemographicsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ResultDemographicsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ResultDemographicsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.dob != null)
			count++;
		if(this.sex != null)
			count++;
		if(this.nhsnumber != null)
			count++;
		if(this.hospnum != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.PersonName name;
	protected ims.framework.utils.PartialDate dob;
	protected ims.core.vo.lookups.Sex sex;
	protected String nhsnumber;
	protected String hospnum;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
