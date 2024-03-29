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
 * Generated on 12/10/2015, 13:25
 *
 */
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Cristian Belciug
 */
public class SeenByHCPForTrackingVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.SeenByHCPForTrackingVo copy(ims.emergency.vo.SeenByHCPForTrackingVo valueObjectDest, ims.emergency.vo.SeenByHCPForTrackingVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_SeenByHCP(valueObjectSrc.getID_SeenByHCP());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AllocatedDateTime
		valueObjectDest.setAllocatedDateTime(valueObjectSrc.getAllocatedDateTime());
		// AllocatedMedic
		valueObjectDest.setAllocatedMedic(valueObjectSrc.getAllocatedMedic());
		// AllocatedNurse
		valueObjectDest.setAllocatedNurse(valueObjectSrc.getAllocatedNurse());
		// SeenDateTime
		valueObjectDest.setSeenDateTime(valueObjectSrc.getSeenDateTime());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createSeenByHCPForTrackingVoCollectionFromSeenByHCP(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.emergency.domain.objects.SeenByHCP objects.
	 */
	public static ims.emergency.vo.SeenByHCPForTrackingVoCollection createSeenByHCPForTrackingVoCollectionFromSeenByHCP(java.util.Set domainObjectSet)	
	{
		return createSeenByHCPForTrackingVoCollectionFromSeenByHCP(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.emergency.domain.objects.SeenByHCP objects.
	 */
	public static ims.emergency.vo.SeenByHCPForTrackingVoCollection createSeenByHCPForTrackingVoCollectionFromSeenByHCP(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.SeenByHCPForTrackingVoCollection voList = new ims.emergency.vo.SeenByHCPForTrackingVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.emergency.domain.objects.SeenByHCP domainObject = (ims.emergency.domain.objects.SeenByHCP) iterator.next();
			ims.emergency.vo.SeenByHCPForTrackingVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.emergency.domain.objects.SeenByHCP objects.
	 */
	public static ims.emergency.vo.SeenByHCPForTrackingVoCollection createSeenByHCPForTrackingVoCollectionFromSeenByHCP(java.util.List domainObjectList) 
	{
		return createSeenByHCPForTrackingVoCollectionFromSeenByHCP(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.emergency.domain.objects.SeenByHCP objects.
	 */
	public static ims.emergency.vo.SeenByHCPForTrackingVoCollection createSeenByHCPForTrackingVoCollectionFromSeenByHCP(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.SeenByHCPForTrackingVoCollection voList = new ims.emergency.vo.SeenByHCPForTrackingVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.emergency.domain.objects.SeenByHCP domainObject = (ims.emergency.domain.objects.SeenByHCP) domainObjectList.get(i);
			ims.emergency.vo.SeenByHCPForTrackingVo vo = create(map, domainObject);

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
	 * Create the ims.emergency.domain.objects.SeenByHCP set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractSeenByHCPSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.SeenByHCPForTrackingVoCollection voCollection) 
	 {
	 	return extractSeenByHCPSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractSeenByHCPSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.SeenByHCPForTrackingVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.SeenByHCPForTrackingVo vo = voCollection.get(i);
			ims.emergency.domain.objects.SeenByHCP domainObject = SeenByHCPForTrackingVoAssembler.extractSeenByHCP(domainFactory, vo, domMap);

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
	 * Create the ims.emergency.domain.objects.SeenByHCP list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractSeenByHCPList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.SeenByHCPForTrackingVoCollection voCollection) 
	 {
	 	return extractSeenByHCPList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractSeenByHCPList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.SeenByHCPForTrackingVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.SeenByHCPForTrackingVo vo = voCollection.get(i);
			ims.emergency.domain.objects.SeenByHCP domainObject = SeenByHCPForTrackingVoAssembler.extractSeenByHCP(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.emergency.domain.objects.SeenByHCP object.
	 * @param domainObject ims.emergency.domain.objects.SeenByHCP
	 */
	 public static ims.emergency.vo.SeenByHCPForTrackingVo create(ims.emergency.domain.objects.SeenByHCP domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.emergency.domain.objects.SeenByHCP object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.SeenByHCPForTrackingVo create(DomainObjectMap map, ims.emergency.domain.objects.SeenByHCP domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.SeenByHCPForTrackingVo valueObject = (ims.emergency.vo.SeenByHCPForTrackingVo) map.getValueObject(domainObject, ims.emergency.vo.SeenByHCPForTrackingVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.SeenByHCPForTrackingVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.emergency.domain.objects.SeenByHCP
	 */
	 public static ims.emergency.vo.SeenByHCPForTrackingVo insert(ims.emergency.vo.SeenByHCPForTrackingVo valueObject, ims.emergency.domain.objects.SeenByHCP domainObject) 
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
	 * @param domainObject ims.emergency.domain.objects.SeenByHCP
	 */
	 public static ims.emergency.vo.SeenByHCPForTrackingVo insert(DomainObjectMap map, ims.emergency.vo.SeenByHCPForTrackingVo valueObject, ims.emergency.domain.objects.SeenByHCP domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_SeenByHCP(domainObject.getId());
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
			
		// AllocatedDateTime
		java.util.Date AllocatedDateTime = domainObject.getAllocatedDateTime();
		if ( null != AllocatedDateTime ) 
		{
			valueObject.setAllocatedDateTime(new ims.framework.utils.DateTime(AllocatedDateTime) );
		}
		// AllocatedMedic
		valueObject.setAllocatedMedic(ims.emergency.vo.domain.MedicForTrackingVoAssembler.create(map, domainObject.getAllocatedMedic()) );
		// AllocatedNurse
		valueObject.setAllocatedNurse(ims.emergency.vo.domain.NurseForTrackingVoAssembler.create(map, domainObject.getAllocatedNurse()) );
		// SeenDateTime
		java.util.Date SeenDateTime = domainObject.getSeenDateTime();
		if ( null != SeenDateTime ) 
		{
			valueObject.setSeenDateTime(new ims.framework.utils.DateTime(SeenDateTime) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.emergency.domain.objects.SeenByHCP extractSeenByHCP(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.SeenByHCPForTrackingVo valueObject) 
	{
		return 	extractSeenByHCP(domainFactory, valueObject, new HashMap());
	}

	public static ims.emergency.domain.objects.SeenByHCP extractSeenByHCP(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.SeenByHCPForTrackingVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_SeenByHCP();
		ims.emergency.domain.objects.SeenByHCP domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.emergency.domain.objects.SeenByHCP)domMap.get(valueObject);
			}
			// ims.emergency.vo.SeenByHCPForTrackingVo ID_SeenByHCP field is unknown
			domainObject = new ims.emergency.domain.objects.SeenByHCP();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_SeenByHCP());
			if (domMap.get(key) != null)
			{
				return (ims.emergency.domain.objects.SeenByHCP)domMap.get(key);
			}
			domainObject = (ims.emergency.domain.objects.SeenByHCP) domainFactory.getDomainObject(ims.emergency.domain.objects.SeenByHCP.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_SeenByHCP());

		ims.framework.utils.DateTime dateTime1 = valueObject.getAllocatedDateTime();
		java.util.Date value1 = null;
		if ( dateTime1 != null ) 
		{
			value1 = dateTime1.getJavaDate();
		}
		domainObject.setAllocatedDateTime(value1);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Medic value2 = null;
		if ( null != valueObject.getAllocatedMedic() ) 
		{
			if (valueObject.getAllocatedMedic().getBoId() == null)
			{
				if (domMap.get(valueObject.getAllocatedMedic()) != null)
				{
					value2 = (ims.core.resource.people.domain.objects.Medic)domMap.get(valueObject.getAllocatedMedic());
				}
			}
			else
			{
				value2 = (ims.core.resource.people.domain.objects.Medic)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Medic.class, valueObject.getAllocatedMedic().getBoId());
			}
		}
		domainObject.setAllocatedMedic(value2);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Nurse value3 = null;
		if ( null != valueObject.getAllocatedNurse() ) 
		{
			if (valueObject.getAllocatedNurse().getBoId() == null)
			{
				if (domMap.get(valueObject.getAllocatedNurse()) != null)
				{
					value3 = (ims.core.resource.people.domain.objects.Nurse)domMap.get(valueObject.getAllocatedNurse());
				}
			}
			else
			{
				value3 = (ims.core.resource.people.domain.objects.Nurse)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Nurse.class, valueObject.getAllocatedNurse().getBoId());
			}
		}
		domainObject.setAllocatedNurse(value3);
		ims.framework.utils.DateTime dateTime4 = valueObject.getSeenDateTime();
		java.util.Date value4 = null;
		if ( dateTime4 != null ) 
		{
			value4 = dateTime4.getJavaDate();
		}
		domainObject.setSeenDateTime(value4);

		return domainObject;
	}

}
