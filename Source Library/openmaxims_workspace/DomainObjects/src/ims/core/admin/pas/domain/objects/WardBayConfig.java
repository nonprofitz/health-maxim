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
 * Generated: 12/10/2015, 13:28
 *
 */
package ims.core.admin.pas.domain.objects;

/**
 * 
 * @author Neil McAnaspie
 * Generated.
 */


public class WardBayConfig extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1014100014;
	private static final long serialVersionUID = 1014100014L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Ward */
	private ims.core.resource.place.domain.objects.Location ward;
	/** Bays
	  * Collection of ims.core.layout.domain.objects.BayConfig.
	  */
	private java.util.Set bays;
	/** Main Specialty */
	private ims.domain.lookups.LookupInstance mainSpecialty;
	/** Specialties
	  * Collection of ims.domain.lookups.LookupInstance.
	  */
	private java.util.List specialties;
	/** Does this ward have a Waiting Area */
	private Boolean isWaitingArea;
	/** Number Of Beds allocated by specialty
	  * Collection of ims.core.admin.pas.domain.objects.BedsAllocatedSpecialty.
	  */
	private java.util.List bedsAllocated;
	private Integer numOfBeds;
	private Integer numOfOccupiedBeds;
	private ims.domain.lookups.LookupInstance wardStatus;
	/** 
	  * Collection of ims.core.admin.pas.domain.objects.WardBayClosingDetails.
	  */
	private java.util.List closingDetails;
	/** 
	  * Collection of ims.core.admin.pas.domain.objects.WardBayBlockingDetails.
	  */
	private java.util.List blockingDetails;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public WardBayConfig (Integer id, int ver)
    {
    	super(id, ver);
    }
    public WardBayConfig ()
    {
    	super();
    }
    public WardBayConfig (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.admin.pas.domain.objects.WardBayConfig.class;
	}


	public ims.core.resource.place.domain.objects.Location getWard() {
		return ward;
	}
	public void setWard(ims.core.resource.place.domain.objects.Location ward) {
		this.ward = ward;
	}

	public java.util.Set getBays() {
		if ( null == bays ) {
			bays = new java.util.HashSet();
		}
		return bays;
	}
	public void setBays(java.util.Set paramValue) {
		this.bays = paramValue;
	}

	public ims.domain.lookups.LookupInstance getMainSpecialty() {
		return mainSpecialty;
	}
	public void setMainSpecialty(ims.domain.lookups.LookupInstance mainSpecialty) {
		this.mainSpecialty = mainSpecialty;
	}

	public java.util.List getSpecialties() {
		if ( null == specialties ) {
			specialties = new java.util.ArrayList();
		}
		return specialties;
	}
	public void setSpecialties(java.util.List paramValue) {
		this.specialties = paramValue;
	}

	public Boolean isIsWaitingArea() {
		return isWaitingArea;
	}
	public void setIsWaitingArea(Boolean isWaitingArea) {
		this.isWaitingArea = isWaitingArea;
	}

	public java.util.List getBedsAllocated() {
		if ( null == bedsAllocated ) {
			bedsAllocated = new java.util.ArrayList();
		}
		return bedsAllocated;
	}
	public void setBedsAllocated(java.util.List paramValue) {
		this.bedsAllocated = paramValue;
	}

	public Integer getNumOfBeds() {
		return numOfBeds;
	}
	public void setNumOfBeds(Integer numOfBeds) {
		this.numOfBeds = numOfBeds;
	}

	public Integer getNumOfOccupiedBeds() {
		return numOfOccupiedBeds;
	}
	public void setNumOfOccupiedBeds(Integer numOfOccupiedBeds) {
		this.numOfOccupiedBeds = numOfOccupiedBeds;
	}

	public ims.domain.lookups.LookupInstance getWardStatus() {
		return wardStatus;
	}
	public void setWardStatus(ims.domain.lookups.LookupInstance wardStatus) {
		this.wardStatus = wardStatus;
	}

	public java.util.List getClosingDetails() {
		if ( null == closingDetails ) {
			closingDetails = new java.util.ArrayList();
		}
		return closingDetails;
	}
	public void setClosingDetails(java.util.List paramValue) {
		this.closingDetails = paramValue;
	}

	public java.util.List getBlockingDetails() {
		if ( null == blockingDetails ) {
			blockingDetails = new java.util.ArrayList();
		}
		return blockingDetails;
	}
	public void setBlockingDetails(java.util.List paramValue) {
		this.blockingDetails = paramValue;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*ward* :");
		if (ward != null)
		{
			auditStr.append(toShortClassName(ward));
				
		    auditStr.append(ward.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*bays* :");
		if (bays != null)
		{
			java.util.Iterator it2 = bays.iterator();
			int i2=0;
			while (it2.hasNext())
			{
				if (i2 > 0)
					auditStr.append(",");
				ims.core.layout.domain.objects.BayConfig obj = (ims.core.layout.domain.objects.BayConfig)it2.next();
		if (obj != null)
		{
		   if (i2 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i2++;
		}
		if (i2 > 0)
			auditStr.append("] " + i2);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*mainSpecialty* :");
		if (mainSpecialty != null)
			auditStr.append(mainSpecialty.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*specialties* :");
		if (specialties != null)
		{
			java.util.Iterator it4 = specialties.iterator();
			int i4=0;
			while (it4.hasNext())
			{
				if (i4 > 0)
					auditStr.append(",");
				ims.domain.lookups.LookupInstance obj = (ims.domain.lookups.LookupInstance)it4.next();
			auditStr.append(obj.getText());
			i4++;
		}
		if (i4 > 0)
			auditStr.append("] " + i4);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*isWaitingArea* :");
		auditStr.append(isWaitingArea);
	    auditStr.append("; ");
		auditStr.append("\r\n*bedsAllocated* :");
		if (bedsAllocated != null)
		{
		int i6=0;
		for (i6=0; i6<bedsAllocated.size(); i6++)
		{
			if (i6 > 0)
				auditStr.append(",");
			ims.core.admin.pas.domain.objects.BedsAllocatedSpecialty obj = (ims.core.admin.pas.domain.objects.BedsAllocatedSpecialty)bedsAllocated.get(i6);
		    if (obj != null)
			{
				if (i6 == 0)
				{
				auditStr.append(toShortClassName(obj));
				auditStr.append("[");
				}
		        auditStr.append(obj.toString());
			}
		}
		if (i6 > 0)
			auditStr.append("] " + i6);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*numOfBeds* :");
		auditStr.append(numOfBeds);
	    auditStr.append("; ");
		auditStr.append("\r\n*numOfOccupiedBeds* :");
		auditStr.append(numOfOccupiedBeds);
	    auditStr.append("; ");
		auditStr.append("\r\n*wardStatus* :");
		if (wardStatus != null)
			auditStr.append(wardStatus.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*closingDetails* :");
		if (closingDetails != null)
		{
		int i10=0;
		for (i10=0; i10<closingDetails.size(); i10++)
		{
			if (i10 > 0)
				auditStr.append(",");
			ims.core.admin.pas.domain.objects.WardBayClosingDetails obj = (ims.core.admin.pas.domain.objects.WardBayClosingDetails)closingDetails.get(i10);
		    if (obj != null)
			{
				if (i10 == 0)
				{
				auditStr.append(toShortClassName(obj));
				auditStr.append("[");
				}
		        auditStr.append(obj.getId());
			}
		}
		if (i10 > 0)
			auditStr.append("] " + i10);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*blockingDetails* :");
		if (blockingDetails != null)
		{
		int i11=0;
		for (i11=0; i11<blockingDetails.size(); i11++)
		{
			if (i11 > 0)
				auditStr.append(",");
			ims.core.admin.pas.domain.objects.WardBayBlockingDetails obj = (ims.core.admin.pas.domain.objects.WardBayBlockingDetails)blockingDetails.get(i11);
		    if (obj != null)
			{
				if (i11 == 0)
				{
				auditStr.append(toShortClassName(obj));
				auditStr.append("[");
				}
		        auditStr.append(obj.getId());
			}
		}
		if (i11 > 0)
			auditStr.append("] " + i11);
		}
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "WardBayConfig";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getWard() != null)
		{
			sb.append("<ward>");
			sb.append(this.getWard().toXMLString(domMap)); 	
			sb.append("</ward>");		
		}
		if (this.getBays() != null)
		{
			if (this.getBays().size() > 0 )
			{
			sb.append("<bays>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getBays(), domMap));
			sb.append("</bays>");		
			}
		}
		if (this.getMainSpecialty() != null)
		{
			sb.append("<mainSpecialty>");
			sb.append(this.getMainSpecialty().toXMLString()); 
			sb.append("</mainSpecialty>");		
		}
		if (this.getSpecialties() != null)
		{
			if (this.getSpecialties().size() > 0 )
			{
			sb.append("<specialties>");
			sb.append(ims.domain.lookups.LookupInstance.toXMLString(this.getSpecialties())); 
			sb.append("</specialties>");		
			}
		}
		if (this.isIsWaitingArea() != null)
		{
			sb.append("<isWaitingArea>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isIsWaitingArea().toString()));
			sb.append("</isWaitingArea>");		
		}
		if (this.getBedsAllocated() != null)
		{
			if (this.getBedsAllocated().size() > 0 )
			{
			sb.append("<bedsAllocated>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getBedsAllocated(), domMap));
			sb.append("</bedsAllocated>");		
			}
		}
		if (this.getNumOfBeds() != null)
		{
			sb.append("<numOfBeds>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getNumOfBeds().toString()));
			sb.append("</numOfBeds>");		
		}
		if (this.getNumOfOccupiedBeds() != null)
		{
			sb.append("<numOfOccupiedBeds>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getNumOfOccupiedBeds().toString()));
			sb.append("</numOfOccupiedBeds>");		
		}
		if (this.getWardStatus() != null)
		{
			sb.append("<wardStatus>");
			sb.append(this.getWardStatus().toXMLString()); 
			sb.append("</wardStatus>");		
		}
		if (this.getClosingDetails() != null)
		{
			if (this.getClosingDetails().size() > 0 )
			{
			sb.append("<closingDetails>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getClosingDetails(), domMap));
			sb.append("</closingDetails>");		
			}
		}
		if (this.getBlockingDetails() != null)
		{
			if (this.getBlockingDetails().size() > 0 )
			{
			sb.append("<blockingDetails>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getBlockingDetails(), domMap));
			sb.append("</blockingDetails>");		
			}
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			WardBayConfig domainObject = getWardBayConfigfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
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
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			WardBayConfig domainObject = getWardBayConfigfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static WardBayConfig getWardBayConfigfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getWardBayConfigfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static WardBayConfig getWardBayConfigfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!WardBayConfig.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!WardBayConfig.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the WardBayConfig class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (WardBayConfig)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(WardBayConfig.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		WardBayConfig ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (WardBayConfig)factory.getImportedDomainObject(WardBayConfig.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new WardBayConfig();
		}
		String keyClassName = "WardBayConfig";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (WardBayConfig)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, WardBayConfig obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("ward");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setWard(ims.core.resource.place.domain.objects.Location.getLocationfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("bays");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setBays(ims.core.layout.domain.objects.BayConfig.fromSetXMLString(fldEl, factory, obj.getBays(), domMap));
		}
		fldEl = el.element("mainSpecialty");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setMainSpecialty(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("specialties");
		if(fldEl != null)
		{
			fldEl = fldEl.element("list");	
			obj.setSpecialties(ims.domain.lookups.LookupInstance.fromListXMLString(fldEl, factory, obj.getSpecialties())); 
		}
		fldEl = el.element("isWaitingArea");
		if(fldEl != null)
		{	
    		obj.setIsWaitingArea(new Boolean(fldEl.getTextTrim()));	
		}
		fldEl = el.element("bedsAllocated");
		if(fldEl != null)
		{
			fldEl = fldEl.element("list");	
			obj.setBedsAllocated(ims.core.admin.pas.domain.objects.BedsAllocatedSpecialty.fromListXMLString(fldEl, factory, obj.getBedsAllocated(), domMap));
		}
		fldEl = el.element("numOfBeds");
		if(fldEl != null)
		{	
    		obj.setNumOfBeds(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("numOfOccupiedBeds");
		if(fldEl != null)
		{	
    		obj.setNumOfOccupiedBeds(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("wardStatus");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setWardStatus(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("closingDetails");
		if(fldEl != null)
		{
			fldEl = fldEl.element("list");	
			obj.setClosingDetails(ims.core.admin.pas.domain.objects.WardBayClosingDetails.fromListXMLString(fldEl, factory, obj.getClosingDetails(), domMap));
		}
		fldEl = el.element("blockingDetails");
		if(fldEl != null)
		{
			fldEl = fldEl.element("list");	
			obj.setBlockingDetails(ims.core.admin.pas.domain.objects.WardBayBlockingDetails.fromListXMLString(fldEl, factory, obj.getBlockingDetails(), domMap));
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "bays"
		, "specialties"
		, "bedsAllocated"
		, "closingDetails"
		, "blockingDetails"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String Ward = "ward";
		public static final String Bays = "bays";
		public static final String MainSpecialty = "mainSpecialty";
		public static final String Specialties = "specialties";
		public static final String IsWaitingArea = "isWaitingArea";
		public static final String BedsAllocated = "bedsAllocated";
		public static final String NumOfBeds = "numOfBeds";
		public static final String NumOfOccupiedBeds = "numOfOccupiedBeds";
		public static final String WardStatus = "wardStatus";
		public static final String ClosingDetails = "closingDetails";
		public static final String BlockingDetails = "blockingDetails";
	}
}

