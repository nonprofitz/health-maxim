// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class SuspensionReason extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SuspensionReason()
	{
		super();
	}
	public SuspensionReason(int id)
	{
		super(id, "", true);
	}
	public SuspensionReason(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SuspensionReason(int id, String text, boolean active, SuspensionReason parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SuspensionReason(int id, String text, boolean active, SuspensionReason parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SuspensionReason(int id, String text, boolean active, SuspensionReason parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SuspensionReason buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SuspensionReason(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SuspensionReason)super.getParentInstance();
	}
	public SuspensionReason getParent()
	{
		return (SuspensionReason)super.getParentInstance();
	}
	public void setParent(SuspensionReason parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SuspensionReason[] typedChildren = new SuspensionReason[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SuspensionReason)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SuspensionReason)
		{
			super.addChild((SuspensionReason)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SuspensionReason)
		{
			super.removeChild((SuspensionReason)child);
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
		SuspensionReasonCollection result = new SuspensionReasonCollection();
		result.add(MEDICALREASON);
		result.add(PATIETNREASON);
		return result;
	}
	public static SuspensionReason[] getNegativeInstances()
	{
		SuspensionReason[] instances = new SuspensionReason[2];
		instances[0] = MEDICALREASON;
		instances[1] = PATIETNREASON;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "MEDICALREASON";
		negativeInstances[1] = "PATIETNREASON";
		return negativeInstances;
	}
	public static SuspensionReason getNegativeInstance(String name)
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
	public static SuspensionReason getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SuspensionReason[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341044;
	public static final SuspensionReason MEDICALREASON = new SuspensionReason(-2635, "Medical Reason", true, null, null, Color.Default);
	public static final SuspensionReason PATIETNREASON = new SuspensionReason(-2636, "Patient Reason", true, null, null, Color.Default);
}