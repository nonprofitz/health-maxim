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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 12/10/2015, 13:24
 *
 */
package ims.chooseandbook.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Barbara Worwood
 */
public class NtpfApptCancConvVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.chooseandbook.vo.NtpfApptCancConvVo copy(ims.chooseandbook.vo.NtpfApptCancConvVo valueObjectDest, ims.chooseandbook.vo.NtpfApptCancConvVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Conversation(valueObjectSrc.getID_Conversation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// dummy
		valueObjectDest.setDummy(valueObjectSrc.getDummy());
		// cid
		valueObjectDest.setCid(valueObjectSrc.getCid());
		// current
		valueObjectDest.setCurrent(valueObjectSrc.getCurrent());
		// points
		valueObjectDest.setPoints(valueObjectSrc.getPoints());
		// msgUids
		valueObjectDest.setMsgUids(valueObjectSrc.getMsgUids());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createNtpfApptCancConvVoCollectionFromNtfyApptCancConv(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.choose_book.domain.objects.NtfyApptCancConv objects.
	 */
	public static ims.chooseandbook.vo.NtpfApptCancConvVoCollection createNtpfApptCancConvVoCollectionFromNtfyApptCancConv(java.util.Set domainObjectSet)	
	{
		return createNtpfApptCancConvVoCollectionFromNtfyApptCancConv(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.choose_book.domain.objects.NtfyApptCancConv objects.
	 */
	public static ims.chooseandbook.vo.NtpfApptCancConvVoCollection createNtpfApptCancConvVoCollectionFromNtfyApptCancConv(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.chooseandbook.vo.NtpfApptCancConvVoCollection voList = new ims.chooseandbook.vo.NtpfApptCancConvVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.choose_book.domain.objects.NtfyApptCancConv domainObject = (ims.choose_book.domain.objects.NtfyApptCancConv) iterator.next();
			ims.chooseandbook.vo.NtpfApptCancConvVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.choose_book.domain.objects.NtfyApptCancConv objects.
	 */
	public static ims.chooseandbook.vo.NtpfApptCancConvVoCollection createNtpfApptCancConvVoCollectionFromNtfyApptCancConv(java.util.List domainObjectList) 
	{
		return createNtpfApptCancConvVoCollectionFromNtfyApptCancConv(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.choose_book.domain.objects.NtfyApptCancConv objects.
	 */
	public static ims.chooseandbook.vo.NtpfApptCancConvVoCollection createNtpfApptCancConvVoCollectionFromNtfyApptCancConv(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.chooseandbook.vo.NtpfApptCancConvVoCollection voList = new ims.chooseandbook.vo.NtpfApptCancConvVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.choose_book.domain.objects.NtfyApptCancConv domainObject = (ims.choose_book.domain.objects.NtfyApptCancConv) domainObjectList.get(i);
			ims.chooseandbook.vo.NtpfApptCancConvVo vo = create(map, domainObject);

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
	 * Create the ims.choose_book.domain.objects.NtfyApptCancConv set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractNtfyApptCancConvSet(ims.domain.ILightweightDomainFactory domainFactory, ims.chooseandbook.vo.NtpfApptCancConvVoCollection voCollection) 
	 {
	 	return extractNtfyApptCancConvSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractNtfyApptCancConvSet(ims.domain.ILightweightDomainFactory domainFactory, ims.chooseandbook.vo.NtpfApptCancConvVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.chooseandbook.vo.NtpfApptCancConvVo vo = voCollection.get(i);
			ims.choose_book.domain.objects.NtfyApptCancConv domainObject = NtpfApptCancConvVoAssembler.extractNtfyApptCancConv(domainFactory, vo, domMap);

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
	 * Create the ims.choose_book.domain.objects.NtfyApptCancConv list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractNtfyApptCancConvList(ims.domain.ILightweightDomainFactory domainFactory, ims.chooseandbook.vo.NtpfApptCancConvVoCollection voCollection) 
	 {
	 	return extractNtfyApptCancConvList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractNtfyApptCancConvList(ims.domain.ILightweightDomainFactory domainFactory, ims.chooseandbook.vo.NtpfApptCancConvVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.chooseandbook.vo.NtpfApptCancConvVo vo = voCollection.get(i);
			ims.choose_book.domain.objects.NtfyApptCancConv domainObject = NtpfApptCancConvVoAssembler.extractNtfyApptCancConv(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.choose_book.domain.objects.NtfyApptCancConv object.
	 * @param domainObject ims.choose_book.domain.objects.NtfyApptCancConv
	 */
	 public static ims.chooseandbook.vo.NtpfApptCancConvVo create(ims.choose_book.domain.objects.NtfyApptCancConv domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.choose_book.domain.objects.NtfyApptCancConv object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.chooseandbook.vo.NtpfApptCancConvVo create(DomainObjectMap map, ims.choose_book.domain.objects.NtfyApptCancConv domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.chooseandbook.vo.NtpfApptCancConvVo valueObject = (ims.chooseandbook.vo.NtpfApptCancConvVo) map.getValueObject(domainObject, ims.chooseandbook.vo.NtpfApptCancConvVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.chooseandbook.vo.NtpfApptCancConvVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.choose_book.domain.objects.NtfyApptCancConv
	 */
	 public static ims.chooseandbook.vo.NtpfApptCancConvVo insert(ims.chooseandbook.vo.NtpfApptCancConvVo valueObject, ims.choose_book.domain.objects.NtfyApptCancConv domainObject) 
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
	 * @param domainObject ims.choose_book.domain.objects.NtfyApptCancConv
	 */
	 public static ims.chooseandbook.vo.NtpfApptCancConvVo insert(DomainObjectMap map, ims.chooseandbook.vo.NtpfApptCancConvVo valueObject, ims.choose_book.domain.objects.NtfyApptCancConv domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Conversation(domainObject.getId());
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
			
		// dummy
		valueObject.setDummy( domainObject.isDummy() );
		// cid
		valueObject.setCid(ims.chooseandbook.vo.domain.ConvIdVoAssembler.create(map, domainObject.getCid()) );
		// current
		valueObject.setCurrent(ims.chooseandbook.vo.domain.SeqPointVoAssembler.create(map, domainObject.getCurrent()) );
		// points
		valueObject.setPoints(ims.chooseandbook.vo.domain.ConvPointVoAssembler.createConvPointVoCollectionFromConvPoint(map, domainObject.getPoints()) );
		// msgUids
		valueObject.setMsgUids(ims.chooseandbook.vo.domain.ConvUidVoAssembler.createConvUidVoCollectionFromConvUid(map, domainObject.getMsgUids()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.choose_book.domain.objects.NtfyApptCancConv extractNtfyApptCancConv(ims.domain.ILightweightDomainFactory domainFactory, ims.chooseandbook.vo.NtpfApptCancConvVo valueObject) 
	{
		return 	extractNtfyApptCancConv(domainFactory, valueObject, new HashMap());
	}

	public static ims.choose_book.domain.objects.NtfyApptCancConv extractNtfyApptCancConv(ims.domain.ILightweightDomainFactory domainFactory, ims.chooseandbook.vo.NtpfApptCancConvVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Conversation();
		ims.choose_book.domain.objects.NtfyApptCancConv domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.choose_book.domain.objects.NtfyApptCancConv)domMap.get(valueObject);
			}
			// ims.chooseandbook.vo.NtpfApptCancConvVo ID_NtfyApptCancConv field is unknown
			domainObject = new ims.choose_book.domain.objects.NtfyApptCancConv();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Conversation());
			if (domMap.get(key) != null)
			{
				return (ims.choose_book.domain.objects.NtfyApptCancConv)domMap.get(key);
			}
			domainObject = (ims.choose_book.domain.objects.NtfyApptCancConv) domainFactory.getDomainObject(ims.choose_book.domain.objects.NtfyApptCancConv.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Conversation());

		domainObject.setDummy(valueObject.getDummy());
		domainObject.setCid(ims.chooseandbook.vo.domain.ConvIdVoAssembler.extractConvId(domainFactory, valueObject.getCid(), domMap));
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.choose_book.domain.objects.SeqPoint value3 = null;
		if ( null != valueObject.getCurrent() ) 
		{
			if (valueObject.getCurrent().getBoId() == null)
			{
				if (domMap.get(valueObject.getCurrent()) != null)
				{
					value3 = (ims.choose_book.domain.objects.SeqPoint)domMap.get(valueObject.getCurrent());
				}
			}
			else
			{
				value3 = (ims.choose_book.domain.objects.SeqPoint)domainFactory.getDomainObject(ims.choose_book.domain.objects.SeqPoint.class, valueObject.getCurrent().getBoId());
			}
		}
		domainObject.setCurrent(value3);
		domainObject.setPoints(ims.chooseandbook.vo.domain.ConvPointVoAssembler.extractConvPointList(domainFactory, valueObject.getPoints(), domainObject.getPoints(), domMap));		
		domainObject.setMsgUids(ims.chooseandbook.vo.domain.ConvUidVoAssembler.extractConvUidList(domainFactory, valueObject.getMsgUids(), domainObject.getMsgUids(), domMap));		

		return domainObject;
	}

}
