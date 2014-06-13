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

package ims.icp.vo;

/**
 * Linked to ICPs.Instantiation.PatientICPStage business object (ID: 1100100001).
 */
public class PatientICPStage_PresentationVo extends ims.icps.instantiation.vo.PatientICPStageRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IInstantiationICPStagePhaseAction
{
	private static final long serialVersionUID = 1L;

	public PatientICPStage_PresentationVo()
	{
	}
	public PatientICPStage_PresentationVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPStage_PresentationVo(ims.icp.vo.beans.PatientICPStage_PresentationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.phases = ims.icp.vo.PatientICPPhase_PresentationVoCollection.buildFromBeanCollection(bean.getPhases());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPStage_PresentationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.phases = ims.icp.vo.PatientICPPhase_PresentationVoCollection.buildFromBeanCollection(bean.getPhases());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPStage_PresentationVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPStage_PresentationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPStage_PresentationVoBean();
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
		if(fieldName.equals("ICP"))
			return getICP();
		if(fieldName.equals("STAGE"))
			return getStage();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("PHASES"))
			return getPhases();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getICPIsNotNull()
	{
		return this.icp != null;
	}
	public ims.icps.instantiation.vo.PatientICPRefVo getICP()
	{
		return this.icp;
	}
	public void setICP(ims.icps.instantiation.vo.PatientICPRefVo value)
	{
		this.isValidated = false;
		this.icp = value;
	}
	public boolean getStageIsNotNull()
	{
		return this.stage != null;
	}
	public ims.icp.vo.ICPStageLiteVo getStage()
	{
		return this.stage;
	}
	public void setStage(ims.icp.vo.ICPStageLiteVo value)
	{
		this.isValidated = false;
		this.stage = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.icp.vo.PatientICPStageStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.PatientICPStageStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getPhasesIsNotNull()
	{
		return this.phases != null;
	}
	public ims.icp.vo.PatientICPPhase_PresentationVoCollection getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.icp.vo.PatientICPPhase_PresentationVoCollection value)
	{
		this.isValidated = false;
		this.phases = value;
	}
	/**
	* IInstantiationICPStagePhaseAction
	*/
	public String getHelpURL()
	{
		if (this.stage == null)
			return null;
			
		return this.stage.helpurl;
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
		if(this.stage != null)
		{
			if(!this.stage.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
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
		if(this.icp == null)
			listOfErrors.add("ICP is mandatory");
		if(this.stage == null)
			listOfErrors.add("Stage is mandatory");
		if(this.stage != null)
		{
			String[] listOfOtherErrors = this.stage.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
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
	
		PatientICPStage_PresentationVo clone = new PatientICPStage_PresentationVo(this.id, this.version);
		
		clone.icp = this.icp;
		if(this.stage == null)
			clone.stage = null;
		else
			clone.stage = (ims.icp.vo.ICPStageLiteVo)this.stage.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPStageStatusVo)this.currentstatus.clone();
		if(this.phases == null)
			clone.phases = null;
		else
			clone.phases = (ims.icp.vo.PatientICPPhase_PresentationVoCollection)this.phases.clone();
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
		if (!(PatientICPStage_PresentationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPStage_PresentationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPStage_PresentationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPStage_PresentationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.icp != null)
			count++;
		if(this.stage != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.phases != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.icps.instantiation.vo.PatientICPRefVo icp;
	protected ims.icp.vo.ICPStageLiteVo stage;
	protected ims.icp.vo.PatientICPStageStatusVo currentstatus;
	protected ims.icp.vo.PatientICPPhase_PresentationVoCollection phases;
	private boolean isValidated = false;
	private boolean isBusy = false;
}