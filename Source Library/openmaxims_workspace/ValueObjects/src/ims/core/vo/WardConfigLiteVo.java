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
 * Linked to core.admin.pas.WardBayConfig business object (ID: 1014100014).
 */
public class WardConfigLiteVo extends ims.core.admin.pas.vo.WardBayConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardConfigLiteVo()
	{
	}
	public WardConfigLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public WardConfigLiteVo(ims.core.vo.beans.WardConfigLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.bays = ims.core.vo.BayConfigLiteVoCollection.buildFromBeanCollection(bean.getBays());
		this.mainspecialty = bean.getMainSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getMainSpecialty());
		this.specialties = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getSpecialties());
		this.iswaitingarea = bean.getIsWaitingArea();
		this.numofbeds = bean.getNumOfBeds();
		this.numofoccupiedbeds = bean.getNumOfOccupiedBeds();
		this.wardavailabilitystatus = bean.getWardAvailabilityStatus() == null ? null : ims.core.vo.lookups.WardBayStatus.buildLookup(bean.getWardAvailabilityStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardConfigLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.bays = ims.core.vo.BayConfigLiteVoCollection.buildFromBeanCollection(bean.getBays());
		this.mainspecialty = bean.getMainSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getMainSpecialty());
		this.specialties = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getSpecialties());
		this.iswaitingarea = bean.getIsWaitingArea();
		this.numofbeds = bean.getNumOfBeds();
		this.numofoccupiedbeds = bean.getNumOfOccupiedBeds();
		this.wardavailabilitystatus = bean.getWardAvailabilityStatus() == null ? null : ims.core.vo.lookups.WardBayStatus.buildLookup(bean.getWardAvailabilityStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardConfigLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardConfigLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardConfigLiteVoBean();
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
		if(fieldName.equals("WARD"))
			return getWard();
		if(fieldName.equals("BAYS"))
			return getBays();
		if(fieldName.equals("MAINSPECIALTY"))
			return getMainSpecialty();
		if(fieldName.equals("SPECIALTIES"))
			return getSpecialties();
		if(fieldName.equals("ISWAITINGAREA"))
			return getIsWaitingArea();
		if(fieldName.equals("NUMOFBEDS"))
			return getNumOfBeds();
		if(fieldName.equals("NUMOFOCCUPIEDBEDS"))
			return getNumOfOccupiedBeds();
		if(fieldName.equals("WARDAVAILABILITYSTATUS"))
			return getWardAvailabilityStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getBaysIsNotNull()
	{
		return this.bays != null;
	}
	public ims.core.vo.BayConfigLiteVoCollection getBays()
	{
		return this.bays;
	}
	public void setBays(ims.core.vo.BayConfigLiteVoCollection value)
	{
		this.isValidated = false;
		this.bays = value;
	}
	public boolean getMainSpecialtyIsNotNull()
	{
		return this.mainspecialty != null;
	}
	public ims.core.vo.lookups.Specialty getMainSpecialty()
	{
		return this.mainspecialty;
	}
	public void setMainSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.mainspecialty = value;
	}
	public boolean getSpecialtiesIsNotNull()
	{
		return this.specialties != null;
	}
	public ims.core.vo.lookups.SpecialtyCollection getSpecialties()
	{
		return this.specialties;
	}
	public void setSpecialties(ims.core.vo.lookups.SpecialtyCollection value)
	{
		this.isValidated = false;
		this.specialties = value;
	}
	public boolean getIsWaitingAreaIsNotNull()
	{
		return this.iswaitingarea != null;
	}
	public Boolean getIsWaitingArea()
	{
		return this.iswaitingarea;
	}
	public void setIsWaitingArea(Boolean value)
	{
		this.isValidated = false;
		this.iswaitingarea = value;
	}
	public boolean getNumOfBedsIsNotNull()
	{
		return this.numofbeds != null;
	}
	public Integer getNumOfBeds()
	{
		return this.numofbeds;
	}
	public void setNumOfBeds(Integer value)
	{
		this.isValidated = false;
		this.numofbeds = value;
	}
	public boolean getNumOfOccupiedBedsIsNotNull()
	{
		return this.numofoccupiedbeds != null;
	}
	public Integer getNumOfOccupiedBeds()
	{
		return this.numofoccupiedbeds;
	}
	public void setNumOfOccupiedBeds(Integer value)
	{
		this.isValidated = false;
		this.numofoccupiedbeds = value;
	}
	public boolean getWardAvailabilityStatusIsNotNull()
	{
		return this.wardavailabilitystatus != null;
	}
	public ims.core.vo.lookups.WardBayStatus getWardAvailabilityStatus()
	{
		return this.wardavailabilitystatus;
	}
	public void setWardAvailabilityStatus(ims.core.vo.lookups.WardBayStatus value)
	{
		this.isValidated = false;
		this.wardavailabilitystatus = value;
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
		if(this.ward == null)
			listOfErrors.add("Ward is mandatory");
		if(this.bays == null || this.bays.size() == 0)
			listOfErrors.add("Bays are mandatory");
		if(this.mainspecialty == null)
			listOfErrors.add("MainSpecialty is mandatory");
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
	
		WardConfigLiteVo clone = new WardConfigLiteVo(this.id, this.version);
		
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.bays == null)
			clone.bays = null;
		else
			clone.bays = (ims.core.vo.BayConfigLiteVoCollection)this.bays.clone();
		if(this.mainspecialty == null)
			clone.mainspecialty = null;
		else
			clone.mainspecialty = (ims.core.vo.lookups.Specialty)this.mainspecialty.clone();
		if(this.specialties == null)
			clone.specialties = null;
		else
			clone.specialties = (ims.core.vo.lookups.SpecialtyCollection)this.specialties.clone();
		clone.iswaitingarea = this.iswaitingarea;
		clone.numofbeds = this.numofbeds;
		clone.numofoccupiedbeds = this.numofoccupiedbeds;
		if(this.wardavailabilitystatus == null)
			clone.wardavailabilitystatus = null;
		else
			clone.wardavailabilitystatus = (ims.core.vo.lookups.WardBayStatus)this.wardavailabilitystatus.clone();
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
		if (!(WardConfigLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardConfigLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((WardConfigLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((WardConfigLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.ward != null)
			count++;
		if(this.bays != null)
			count++;
		if(this.mainspecialty != null)
			count++;
		if(this.specialties != null)
			count++;
		if(this.iswaitingarea != null)
			count++;
		if(this.numofbeds != null)
			count++;
		if(this.numofoccupiedbeds != null)
			count++;
		if(this.wardavailabilitystatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.core.vo.BayConfigLiteVoCollection bays;
	protected ims.core.vo.lookups.Specialty mainspecialty;
	protected ims.core.vo.lookups.SpecialtyCollection specialties;
	protected Boolean iswaitingarea;
	protected Integer numofbeds;
	protected Integer numofoccupiedbeds;
	protected ims.core.vo.lookups.WardBayStatus wardavailabilitystatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
