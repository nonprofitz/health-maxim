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
package ims.medical.domain.objects;

/**
 * 
 * @author Kevin O'Carroll
 * Generated.
 */


public class OPDVisitDetails extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1023100024;
	private static final long serialVersionUID = 1023100024L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Authoring Care Professional */
	private ims.core.resource.people.domain.objects.Hcp authoringCP;
	/** Authoring Date Time */
	private java.util.Date authoringDateTime;
	/** Collection of relatives present
	  * Collection of ims.core.admin.domain.objects.OPDRelPres.
	  */
	private java.util.Set relPresent;
	/** Clinical Contact */
	private ims.core.admin.domain.objects.ClinicalContact clinicalContact;
	/** Other HCPs present
	  * Collection of ims.medical.domain.objects.OPDVisitHcpPresent.
	  */
	private java.util.Set otherHcpsPresent;
	/** CareContext */
	private ims.core.admin.domain.objects.CareContext careContext;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public OPDVisitDetails (Integer id, int ver)
    {
    	super(id, ver);
    }
    public OPDVisitDetails ()
    {
    	super();
    }
    public OPDVisitDetails (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.medical.domain.objects.OPDVisitDetails.class;
	}


	public ims.core.resource.people.domain.objects.Hcp getAuthoringCP() {
		return authoringCP;
	}
	public void setAuthoringCP(ims.core.resource.people.domain.objects.Hcp authoringCP) {
		this.authoringCP = authoringCP;
	}

	public java.util.Date getAuthoringDateTime() {
		return authoringDateTime;
	}
	public void setAuthoringDateTime(java.util.Date authoringDateTime) {
		this.authoringDateTime = authoringDateTime;
	}

	public java.util.Set getRelPresent() {
		if ( null == relPresent ) {
			relPresent = new java.util.HashSet();
		}
		return relPresent;
	}
	public void setRelPresent(java.util.Set paramValue) {
		this.relPresent = paramValue;
	}

	public ims.core.admin.domain.objects.ClinicalContact getClinicalContact() {
		return clinicalContact;
	}
	public void setClinicalContact(ims.core.admin.domain.objects.ClinicalContact clinicalContact) {
		this.clinicalContact = clinicalContact;
	}

	public java.util.Set getOtherHcpsPresent() {
		if ( null == otherHcpsPresent ) {
			otherHcpsPresent = new java.util.HashSet();
		}
		return otherHcpsPresent;
	}
	public void setOtherHcpsPresent(java.util.Set paramValue) {
		this.otherHcpsPresent = paramValue;
	}

	public ims.core.admin.domain.objects.CareContext getCareContext() {
		return careContext;
	}
	public void setCareContext(ims.core.admin.domain.objects.CareContext careContext) {
		this.careContext = careContext;
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
		
		auditStr.append("\r\n*authoringCP* :");
		if (authoringCP != null)
		{
			auditStr.append(toShortClassName(authoringCP));
				
		    auditStr.append(authoringCP.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*authoringDateTime* :");
		auditStr.append(authoringDateTime);
	    auditStr.append("; ");
		auditStr.append("\r\n*relPresent* :");
		if (relPresent != null)
		{
			java.util.Iterator it3 = relPresent.iterator();
			int i3=0;
			while (it3.hasNext())
			{
				if (i3 > 0)
					auditStr.append(",");
				ims.core.admin.domain.objects.OPDRelPres obj = (ims.core.admin.domain.objects.OPDRelPres)it3.next();
		if (obj != null)
		{
		   if (i3 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i3++;
		}
		if (i3 > 0)
			auditStr.append("] " + i3);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*clinicalContact* :");
		if (clinicalContact != null)
		{
			auditStr.append(toShortClassName(clinicalContact));
				
		    auditStr.append(clinicalContact.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*otherHcpsPresent* :");
		if (otherHcpsPresent != null)
		{
			java.util.Iterator it5 = otherHcpsPresent.iterator();
			int i5=0;
			while (it5.hasNext())
			{
				if (i5 > 0)
					auditStr.append(",");
				ims.medical.domain.objects.OPDVisitHcpPresent obj = (ims.medical.domain.objects.OPDVisitHcpPresent)it5.next();
		if (obj != null)
		{
		   if (i5 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i5++;
		}
		if (i5 > 0)
			auditStr.append("] " + i5);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*careContext* :");
		if (careContext != null)
		{
			auditStr.append(toShortClassName(careContext));
				
		    auditStr.append(careContext.getId());
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
		
		String keyClassName = "OPDVisitDetails";
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
		if (this.getAuthoringCP() != null)
		{
			sb.append("<authoringCP>");
			sb.append(this.getAuthoringCP().toXMLString(domMap)); 	
			sb.append("</authoringCP>");		
		}
		if (this.getAuthoringDateTime() != null)
		{
			sb.append("<authoringDateTime>");
			sb.append(new ims.framework.utils.DateTime(this.getAuthoringDateTime()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</authoringDateTime>");		
		}
		if (this.getRelPresent() != null)
		{
			if (this.getRelPresent().size() > 0 )
			{
			sb.append("<relPresent>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getRelPresent(), domMap));
			sb.append("</relPresent>");		
			}
		}
		if (this.getClinicalContact() != null)
		{
			sb.append("<clinicalContact>");
			sb.append(this.getClinicalContact().toXMLString(domMap)); 	
			sb.append("</clinicalContact>");		
		}
		if (this.getOtherHcpsPresent() != null)
		{
			if (this.getOtherHcpsPresent().size() > 0 )
			{
			sb.append("<otherHcpsPresent>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getOtherHcpsPresent(), domMap));
			sb.append("</otherHcpsPresent>");		
			}
		}
		if (this.getCareContext() != null)
		{
			sb.append("<careContext>");
			sb.append(this.getCareContext().toXMLString(domMap)); 	
			sb.append("</careContext>");		
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
			OPDVisitDetails domainObject = getOPDVisitDetailsfromXML(itemEl, factory, domMap);

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
			OPDVisitDetails domainObject = getOPDVisitDetailsfromXML(itemEl, factory, domMap);

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
		
	public static OPDVisitDetails getOPDVisitDetailsfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getOPDVisitDetailsfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static OPDVisitDetails getOPDVisitDetailsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!OPDVisitDetails.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!OPDVisitDetails.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the OPDVisitDetails class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (OPDVisitDetails)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(OPDVisitDetails.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		OPDVisitDetails ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (OPDVisitDetails)factory.getImportedDomainObject(OPDVisitDetails.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new OPDVisitDetails();
		}
		String keyClassName = "OPDVisitDetails";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (OPDVisitDetails)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, OPDVisitDetails obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("authoringCP");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setAuthoringCP(ims.core.resource.people.domain.objects.Hcp.getHcpfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("authoringDateTime");
		if(fldEl != null)
		{	
    		obj.setAuthoringDateTime(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("relPresent");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setRelPresent(ims.core.admin.domain.objects.OPDRelPres.fromSetXMLString(fldEl, factory, obj.getRelPresent(), domMap));
		}
		fldEl = el.element("clinicalContact");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setClinicalContact(ims.core.admin.domain.objects.ClinicalContact.getClinicalContactfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("otherHcpsPresent");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setOtherHcpsPresent(ims.medical.domain.objects.OPDVisitHcpPresent.fromSetXMLString(fldEl, factory, obj.getOtherHcpsPresent(), domMap));
		}
		fldEl = el.element("careContext");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setCareContext(ims.core.admin.domain.objects.CareContext.getCareContextfromXML(fldEl, factory, domMap)); 
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "relPresent"
		, "otherHcpsPresent"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String AuthoringCP = "authoringCP";
		public static final String AuthoringDateTime = "authoringDateTime";
		public static final String RelPresent = "relPresent";
		public static final String ClinicalContact = "clinicalContact";
		public static final String OtherHcpsPresent = "otherHcpsPresent";
		public static final String CareContext = "careContext";
	}
}

