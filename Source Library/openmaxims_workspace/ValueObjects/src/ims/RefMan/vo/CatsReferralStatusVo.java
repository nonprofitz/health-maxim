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

package ims.RefMan.vo;

/**
 * Linked to RefMan.CATSReferralStatus business object (ID: 1096100007).
 */
public class CatsReferralStatusVo extends ims.RefMan.vo.CatsReferralStatusLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CatsReferralStatusVo()
	{
	}
	public CatsReferralStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public CatsReferralStatusVo(ims.RefMan.vo.beans.CatsReferralStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referralstatus = bean.getReferralStatus() == null ? null : ims.RefMan.vo.lookups.ReferralApptStatus.buildLookup(bean.getReferralStatus());
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
		this.authoringuser = bean.getAuthoringUser() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getAuthoringUser().getId()), bean.getAuthoringUser().getVersion());
		this.comment = bean.getComment();
		this.secondopinioncategory = bean.getSecondOpinionCategory() == null ? null : ims.RefMan.vo.lookups.SecondOpinionCategory.buildLookup(bean.getSecondOpinionCategory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CatsReferralStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referralstatus = bean.getReferralStatus() == null ? null : ims.RefMan.vo.lookups.ReferralApptStatus.buildLookup(bean.getReferralStatus());
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
		this.authoringuser = bean.getAuthoringUser() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getAuthoringUser().getId()), bean.getAuthoringUser().getVersion());
		this.comment = bean.getComment();
		this.secondopinioncategory = bean.getSecondOpinionCategory() == null ? null : ims.RefMan.vo.lookups.SecondOpinionCategory.buildLookup(bean.getSecondOpinionCategory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CatsReferralStatusVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CatsReferralStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CatsReferralStatusVoBean();
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
		if(fieldName.equals("AUTHORINGUSER"))
			return getAuthoringUser();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("SECONDOPINIONCATEGORY"))
			return getSecondOpinionCategory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringUserIsNotNull()
	{
		return this.authoringuser != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getAuthoringUser()
	{
		return this.authoringuser;
	}
	public void setAuthoringUser(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.authoringuser = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 1500;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getSecondOpinionCategoryIsNotNull()
	{
		return this.secondopinioncategory != null;
	}
	public ims.RefMan.vo.lookups.SecondOpinionCategory getSecondOpinionCategory()
	{
		return this.secondopinioncategory;
	}
	public void setSecondOpinionCategory(ims.RefMan.vo.lookups.SecondOpinionCategory value)
	{
		this.isValidated = false;
		this.secondopinioncategory = value;
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
		if(this.referralstatus == null)
			listOfErrors.add("ReferralStatus is mandatory");
		if(this.statusdatetime == null)
			listOfErrors.add("StatusDateTime is mandatory");
		if(this.comment != null)
			if(this.comment.length() > 1500)
				listOfErrors.add("The length of the field [comment] in the value object [ims.RefMan.vo.CatsReferralStatusVo] is too big. It should be less or equal to 1500");
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
	
		CatsReferralStatusVo clone = new CatsReferralStatusVo(this.id, this.version);
		
		if(this.referralstatus == null)
			clone.referralstatus = null;
		else
			clone.referralstatus = (ims.RefMan.vo.lookups.ReferralApptStatus)this.referralstatus.clone();
		if(this.statusdatetime == null)
			clone.statusdatetime = null;
		else
			clone.statusdatetime = (ims.framework.utils.DateTime)this.statusdatetime.clone();
		clone.authoringuser = this.authoringuser;
		clone.comment = this.comment;
		if(this.secondopinioncategory == null)
			clone.secondopinioncategory = null;
		else
			clone.secondopinioncategory = (ims.RefMan.vo.lookups.SecondOpinionCategory)this.secondopinioncategory.clone();
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
		if (!(CatsReferralStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CatsReferralStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CatsReferralStatusVo compareObj = (CatsReferralStatusVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getStatusDateTime() == null && compareObj.getStatusDateTime() != null)
				return -1;
			if(this.getStatusDateTime() != null && compareObj.getStatusDateTime() == null)
				return 1;
			if(this.getStatusDateTime() != null && compareObj.getStatusDateTime() != null)
				retVal = this.getStatusDateTime().compareTo(compareObj.getStatusDateTime());
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
		if(this.authoringuser != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.secondopinioncategory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.core.resource.people.vo.MemberOfStaffRefVo authoringuser;
	protected String comment;
	protected ims.RefMan.vo.lookups.SecondOpinionCategory secondopinioncategory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
