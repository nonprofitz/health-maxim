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

package ims.nursing.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class CarePlanStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public CarePlanStatus()
	{
		super();
	}
	public CarePlanStatus(int id)
	{
		super(id, "", true);
	}
	public CarePlanStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public CarePlanStatus(int id, String text, boolean active, CarePlanStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public CarePlanStatus(int id, String text, boolean active, CarePlanStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public CarePlanStatus(int id, String text, boolean active, CarePlanStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static CarePlanStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new CarePlanStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (CarePlanStatus)super.getParentInstance();
	}
	public CarePlanStatus getParent()
	{
		return (CarePlanStatus)super.getParentInstance();
	}
	public void setParent(CarePlanStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		CarePlanStatus[] typedChildren = new CarePlanStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (CarePlanStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof CarePlanStatus)
		{
			super.addChild((CarePlanStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof CarePlanStatus)
		{
			super.removeChild((CarePlanStatus)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		CarePlanStatusCollection result = new CarePlanStatusCollection();
		result.add(ACTIVE);
		result.add(DISCONTINUED);
		result.add(COMPLETE);
		result.add(SUSPENDED);
		result.add(ALL);
		result.add(ALL_ADMISSIONS);
		return result;
	}
	public static CarePlanStatus[] getNegativeInstances()
	{
		CarePlanStatus[] instances = new CarePlanStatus[6];
		instances[0] = ACTIVE;
		instances[1] = DISCONTINUED;
		instances[2] = COMPLETE;
		instances[3] = SUSPENDED;
		instances[4] = ALL;
		instances[5] = ALL_ADMISSIONS;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[6];
		negativeInstances[0] = "ACTIVE";
		negativeInstances[1] = "DISCONTINUED";
		negativeInstances[2] = "COMPLETE";
		negativeInstances[3] = "SUSPENDED";
		negativeInstances[4] = "ALL";
		negativeInstances[5] = "ALL_ADMISSIONS";
		return negativeInstances;
	}
	public static CarePlanStatus getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static CarePlanStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		CarePlanStatus[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1001044;
	public static final CarePlanStatus ACTIVE = new CarePlanStatus(-155, "Active", true, null, null, Color.Black);
	public static final CarePlanStatus DISCONTINUED = new CarePlanStatus(-91, "Discontinued", true, null, null, Color.Black);
	public static final CarePlanStatus COMPLETE = new CarePlanStatus(-156, "Complete", true, null, null, Color.Black);
	public static final CarePlanStatus SUSPENDED = new CarePlanStatus(-30, "Suspended", true, null, null, Color.Black);
	public static final CarePlanStatus ALL = new CarePlanStatus(-684, "All", true, null, null, Color.Black);
	public static final CarePlanStatus ALL_ADMISSIONS = new CarePlanStatus(-2183, "All including previous admissions ", true, null, null, Color.Default);
}
