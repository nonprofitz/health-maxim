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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.careuk.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Cristian Belciug
 */
public class ReferralERODHistoryVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.ReferralERODHistoryVo copy(ims.careuk.vo.ReferralERODHistoryVo valueObjectDest, ims.careuk.vo.ReferralERODHistoryVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReferralEROD(valueObjectSrc.getID_ReferralEROD());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ERODDate1
		valueObjectDest.setERODDate1(valueObjectSrc.getERODDate1());
		// ERODDate2
		valueObjectDest.setERODDate2(valueObjectSrc.getERODDate2());
		// PatAvailFromDate
		valueObjectDest.setPatAvailFromDate(valueObjectSrc.getPatAvailFromDate());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createReferralERODHistoryVoCollectionFromReferralEROD(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.ReferralEROD objects.
	 */
	public static ims.careuk.vo.ReferralERODHistoryVoCollection createReferralERODHistoryVoCollectionFromReferralEROD(java.util.Set domainObjectSet)	
	{
		return createReferralERODHistoryVoCollectionFromReferralEROD(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.ReferralEROD objects.
	 */
	public static ims.careuk.vo.ReferralERODHistoryVoCollection createReferralERODHistoryVoCollectionFromReferralEROD(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.ReferralERODHistoryVoCollection voList = new ims.careuk.vo.ReferralERODHistoryVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.careuk.domain.objects.ReferralEROD domainObject = (ims.careuk.domain.objects.ReferralEROD) iterator.next();
			ims.careuk.vo.ReferralERODHistoryVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.careuk.domain.objects.ReferralEROD objects.
	 */
	public static ims.careuk.vo.ReferralERODHistoryVoCollection createReferralERODHistoryVoCollectionFromReferralEROD(java.util.List domainObjectList) 
	{
		return createReferralERODHistoryVoCollectionFromReferralEROD(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.careuk.domain.objects.ReferralEROD objects.
	 */
	public static ims.careuk.vo.ReferralERODHistoryVoCollection createReferralERODHistoryVoCollectionFromReferralEROD(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.ReferralERODHistoryVoCollection voList = new ims.careuk.vo.ReferralERODHistoryVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.careuk.domain.objects.ReferralEROD domainObject = (ims.careuk.domain.objects.ReferralEROD) domainObjectList.get(i);
			ims.careuk.vo.ReferralERODHistoryVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.careuk.domain.objects.ReferralEROD set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReferralERODSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralERODHistoryVoCollection voCollection) 
	 {
	 	return extractReferralERODSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReferralERODSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralERODHistoryVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.ReferralERODHistoryVo vo = voCollection.get(i);
			ims.careuk.domain.objects.ReferralEROD domainObject = ReferralERODHistoryVoAssembler.extractReferralEROD(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.careuk.domain.objects.ReferralEROD list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReferralERODList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralERODHistoryVoCollection voCollection) 
	 {
	 	return extractReferralERODList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReferralERODList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralERODHistoryVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.ReferralERODHistoryVo vo = voCollection.get(i);
			ims.careuk.domain.objects.ReferralEROD domainObject = ReferralERODHistoryVoAssembler.extractReferralEROD(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.careuk.domain.objects.ReferralEROD object.
	 * @param domainObject ims.careuk.domain.objects.ReferralEROD
	 */
	 public static ims.careuk.vo.ReferralERODHistoryVo create(ims.careuk.domain.objects.ReferralEROD domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.careuk.domain.objects.ReferralEROD object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.ReferralERODHistoryVo create(DomainObjectMap map, ims.careuk.domain.objects.ReferralEROD domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.ReferralERODHistoryVo valueObject = (ims.careuk.vo.ReferralERODHistoryVo) map.getValueObject(domainObject, ims.careuk.vo.ReferralERODHistoryVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.ReferralERODHistoryVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.ReferralEROD
	 */
	 public static ims.careuk.vo.ReferralERODHistoryVo insert(ims.careuk.vo.ReferralERODHistoryVo valueObject, ims.careuk.domain.objects.ReferralEROD domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.ReferralEROD
	 */
	 public static ims.careuk.vo.ReferralERODHistoryVo insert(DomainObjectMap map, ims.careuk.vo.ReferralERODHistoryVo valueObject, ims.careuk.domain.objects.ReferralEROD domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReferralEROD(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// ERODDate1
		java.util.Date ERODDate1 = domainObject.getERODDate1();
		if ( null != ERODDate1 ) 
		{
			valueObject.setERODDate1(new ims.framework.utils.Date(ERODDate1) );
		}
		// ERODDate2
		java.util.Date ERODDate2 = domainObject.getERODDate2();
		if ( null != ERODDate2 ) 
		{
			valueObject.setERODDate2(new ims.framework.utils.Date(ERODDate2) );
		}
		// PatAvailFromDate
		java.util.Date PatAvailFromDate = domainObject.getPatAvailFromDate();
		if ( null != PatAvailFromDate ) 
		{
			valueObject.setPatAvailFromDate(new ims.framework.utils.Date(PatAvailFromDate) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.careuk.domain.objects.ReferralEROD extractReferralEROD(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralERODHistoryVo valueObject) 
	{
		return 	extractReferralEROD(domainFactory, valueObject, new HashMap());
	}

	public static ims.careuk.domain.objects.ReferralEROD extractReferralEROD(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralERODHistoryVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReferralEROD();
		ims.careuk.domain.objects.ReferralEROD domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.careuk.domain.objects.ReferralEROD)domMap.get(valueObject);
			}
			// ims.careuk.vo.ReferralERODHistoryVo ID_ReferralEROD field is unknown
			domainObject = new ims.careuk.domain.objects.ReferralEROD();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReferralEROD());
			if (domMap.get(key) != null)
			{
				return (ims.careuk.domain.objects.ReferralEROD)domMap.get(key);
			}
			domainObject = (ims.careuk.domain.objects.ReferralEROD) domainFactory.getDomainObject(ims.careuk.domain.objects.ReferralEROD.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReferralEROD());

		java.util.Date value1 = null;
		ims.framework.utils.Date date1 = valueObject.getERODDate1();		
		if ( date1 != null ) 
		{
			value1 = date1.getDate();
		}
		domainObject.setERODDate1(value1);
		java.util.Date value2 = null;
		ims.framework.utils.Date date2 = valueObject.getERODDate2();		
		if ( date2 != null ) 
		{
			value2 = date2.getDate();
		}
		domainObject.setERODDate2(value2);
		java.util.Date value3 = null;
		ims.framework.utils.Date date3 = valueObject.getPatAvailFromDate();		
		if ( date3 != null ) 
		{
			value3 = date3.getDate();
		}
		domainObject.setPatAvailFromDate(value3);

		return domainObject;
	}

}