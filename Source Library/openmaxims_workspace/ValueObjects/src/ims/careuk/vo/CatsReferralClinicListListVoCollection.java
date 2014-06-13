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

package ims.careuk.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to CAREUK.CatsReferral business object (ID: 1004100035).
 */
public class CatsReferralClinicListListVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<CatsReferralClinicListListVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<CatsReferralClinicListListVo> col = new ArrayList<CatsReferralClinicListListVo>();
	public String getBoClassName()
	{
		return "ims.careuk.domain.objects.CatsReferral";
	}
	public boolean add(CatsReferralClinicListListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, CatsReferralClinicListListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(CatsReferralClinicListListVo instance)
	{
		return col.indexOf(instance);
	}
	public CatsReferralClinicListListVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, CatsReferralClinicListListVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(CatsReferralClinicListListVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(CatsReferralClinicListListVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		CatsReferralClinicListListVoCollection clone = new CatsReferralClinicListListVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((CatsReferralClinicListListVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public CatsReferralClinicListListVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public CatsReferralClinicListListVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public CatsReferralClinicListListVoCollection sort(SortOrder order)
	{
		return sort(new CatsReferralClinicListListVoComparator(order));
	}
	public CatsReferralClinicListListVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new CatsReferralClinicListListVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public CatsReferralClinicListListVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.careuk.vo.CatsReferralRefVoCollection toRefVoCollection()
	{
		ims.careuk.vo.CatsReferralRefVoCollection result = new ims.careuk.vo.CatsReferralRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public CatsReferralClinicListListVo[] toArray()
	{
		CatsReferralClinicListListVo[] arr = new CatsReferralClinicListListVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<CatsReferralClinicListListVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class CatsReferralClinicListListVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public CatsReferralClinicListListVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public CatsReferralClinicListListVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public CatsReferralClinicListListVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			CatsReferralClinicListListVo voObj1 = (CatsReferralClinicListListVo)obj1;
			CatsReferralClinicListListVo voObj2 = (CatsReferralClinicListListVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.careuk.vo.beans.CatsReferralClinicListListVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.careuk.vo.beans.CatsReferralClinicListListVoBean[] getBeanCollectionArray()
	{
		ims.careuk.vo.beans.CatsReferralClinicListListVoBean[] result = new ims.careuk.vo.beans.CatsReferralClinicListListVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			CatsReferralClinicListListVo vo = ((CatsReferralClinicListListVo)col.get(i));
			result[i] = (ims.careuk.vo.beans.CatsReferralClinicListListVoBean)vo.getBean();
		}
		return result;
	}
	public static CatsReferralClinicListListVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		CatsReferralClinicListListVoCollection coll = new CatsReferralClinicListListVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.careuk.vo.beans.CatsReferralClinicListListVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static CatsReferralClinicListListVoCollection buildFromBeanCollection(ims.careuk.vo.beans.CatsReferralClinicListListVoBean[] beans)
	{
		CatsReferralClinicListListVoCollection coll = new CatsReferralClinicListListVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}