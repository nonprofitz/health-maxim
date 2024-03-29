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
package ims.core.configuration.domain.objects;

/**
 * 
 * @author Rory Fitzpatrick
 * Generated.
 */


public class PACSConfiguration extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1028100071;
	private static final long serialVersionUID = 1028100071L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Server Address */
	private String serverAddress;
	/** UserNameParam */
	private String userNameParam;
	/** Username */
	private String username;
	/** PasswordParam */
	private String passwordParam;
	/** Password */
	private String password;
	/** AccessionParam */
	private String accessionParam;
	/** AccessionTestValue */
	private String accessionTestValue;
	/** PACS client type */
	private ims.domain.lookups.LookupInstance pACSClientType;
	/** When True used the username of the logged in user */
	private Boolean useLoggedUserName;
	/** When a patient  */
	private ims.domain.lookups.LookupInstance primaryIdentifier;
	private ims.domain.lookups.LookupInstance secondaryIdentifier;
	private String patientIdentifierParam;
	private String issuerOfIdentifierParam;
	private String sessionTimeParam;
	private String primaryIdentifierCode;
	private String secondaryIdentifierCode;
	private String aESKey;
	private Boolean useEncryptedToken;
	/** URL parameter for encrypted token */
	private String encryptedTokenParam;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public PACSConfiguration (Integer id, int ver)
    {
    	super(id, ver);
    }
    public PACSConfiguration ()
    {
    	super();
    }
    public PACSConfiguration (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.configuration.domain.objects.PACSConfiguration.class;
	}


	public String getServerAddress() {
		return serverAddress;
	}
	public void setServerAddress(String serverAddress) {
		if ( null != serverAddress && serverAddress.length() > 250 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for serverAddress. Tried to set value: "+
				serverAddress);
		}
		this.serverAddress = serverAddress;
	}

	public String getUserNameParam() {
		return userNameParam;
	}
	public void setUserNameParam(String userNameParam) {
		if ( null != userNameParam && userNameParam.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for userNameParam. Tried to set value: "+
				userNameParam);
		}
		this.userNameParam = userNameParam;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if ( null != username && username.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for username. Tried to set value: "+
				username);
		}
		this.username = username;
	}

	public String getPasswordParam() {
		return passwordParam;
	}
	public void setPasswordParam(String passwordParam) {
		if ( null != passwordParam && passwordParam.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for passwordParam. Tried to set value: "+
				passwordParam);
		}
		this.passwordParam = passwordParam;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if ( null != password && password.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for password. Tried to set value: "+
				password);
		}
		this.password = password;
	}

	public String getAccessionParam() {
		return accessionParam;
	}
	public void setAccessionParam(String accessionParam) {
		if ( null != accessionParam && accessionParam.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for accessionParam. Tried to set value: "+
				accessionParam);
		}
		this.accessionParam = accessionParam;
	}

	public String getAccessionTestValue() {
		return accessionTestValue;
	}
	public void setAccessionTestValue(String accessionTestValue) {
		if ( null != accessionTestValue && accessionTestValue.length() > 20 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for accessionTestValue. Tried to set value: "+
				accessionTestValue);
		}
		this.accessionTestValue = accessionTestValue;
	}

	public ims.domain.lookups.LookupInstance getPACSClientType() {
		return pACSClientType;
	}
	public void setPACSClientType(ims.domain.lookups.LookupInstance pACSClientType) {
		this.pACSClientType = pACSClientType;
	}

	public Boolean isUseLoggedUserName() {
		return useLoggedUserName;
	}
	public void setUseLoggedUserName(Boolean useLoggedUserName) {
		this.useLoggedUserName = useLoggedUserName;
	}

	public ims.domain.lookups.LookupInstance getPrimaryIdentifier() {
		return primaryIdentifier;
	}
	public void setPrimaryIdentifier(ims.domain.lookups.LookupInstance primaryIdentifier) {
		this.primaryIdentifier = primaryIdentifier;
	}

	public ims.domain.lookups.LookupInstance getSecondaryIdentifier() {
		return secondaryIdentifier;
	}
	public void setSecondaryIdentifier(ims.domain.lookups.LookupInstance secondaryIdentifier) {
		this.secondaryIdentifier = secondaryIdentifier;
	}

	public String getPatientIdentifierParam() {
		return patientIdentifierParam;
	}
	public void setPatientIdentifierParam(String patientIdentifierParam) {
		if ( null != patientIdentifierParam && patientIdentifierParam.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for patientIdentifierParam. Tried to set value: "+
				patientIdentifierParam);
		}
		this.patientIdentifierParam = patientIdentifierParam;
	}

	public String getIssuerOfIdentifierParam() {
		return issuerOfIdentifierParam;
	}
	public void setIssuerOfIdentifierParam(String issuerOfIdentifierParam) {
		if ( null != issuerOfIdentifierParam && issuerOfIdentifierParam.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for issuerOfIdentifierParam. Tried to set value: "+
				issuerOfIdentifierParam);
		}
		this.issuerOfIdentifierParam = issuerOfIdentifierParam;
	}

	public String getSessionTimeParam() {
		return sessionTimeParam;
	}
	public void setSessionTimeParam(String sessionTimeParam) {
		if ( null != sessionTimeParam && sessionTimeParam.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for sessionTimeParam. Tried to set value: "+
				sessionTimeParam);
		}
		this.sessionTimeParam = sessionTimeParam;
	}

	public String getPrimaryIdentifierCode() {
		return primaryIdentifierCode;
	}
	public void setPrimaryIdentifierCode(String primaryIdentifierCode) {
		if ( null != primaryIdentifierCode && primaryIdentifierCode.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for primaryIdentifierCode. Tried to set value: "+
				primaryIdentifierCode);
		}
		this.primaryIdentifierCode = primaryIdentifierCode;
	}

	public String getSecondaryIdentifierCode() {
		return secondaryIdentifierCode;
	}
	public void setSecondaryIdentifierCode(String secondaryIdentifierCode) {
		if ( null != secondaryIdentifierCode && secondaryIdentifierCode.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for secondaryIdentifierCode. Tried to set value: "+
				secondaryIdentifierCode);
		}
		this.secondaryIdentifierCode = secondaryIdentifierCode;
	}

	public String getAESKey() {
		return aESKey;
	}
	public void setAESKey(String aESKey) {
		if ( null != aESKey && aESKey.length() > 1024 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for aESKey. Tried to set value: "+
				aESKey);
		}
		this.aESKey = aESKey;
	}

	public Boolean isUseEncryptedToken() {
		return useEncryptedToken;
	}
	public void setUseEncryptedToken(Boolean useEncryptedToken) {
		this.useEncryptedToken = useEncryptedToken;
	}

	public String getEncryptedTokenParam() {
		return encryptedTokenParam;
	}
	public void setEncryptedTokenParam(String encryptedTokenParam) {
		if ( null != encryptedTokenParam && encryptedTokenParam.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for encryptedTokenParam. Tried to set value: "+
				encryptedTokenParam);
		}
		this.encryptedTokenParam = encryptedTokenParam;
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
		if ( "Configuration".equals("Configuration") )
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
		
		auditStr.append("\r\n*serverAddress* :");
		auditStr.append(serverAddress);
	    auditStr.append("; ");
		auditStr.append("\r\n*userNameParam* :");
		auditStr.append(userNameParam);
	    auditStr.append("; ");
		auditStr.append("\r\n*username* :");
		auditStr.append(username);
	    auditStr.append("; ");
		auditStr.append("\r\n*passwordParam* :");
		auditStr.append(passwordParam);
	    auditStr.append("; ");
		auditStr.append("\r\n*password* :");
		auditStr.append(password);
	    auditStr.append("; ");
		auditStr.append("\r\n*accessionParam* :");
		auditStr.append(accessionParam);
	    auditStr.append("; ");
		auditStr.append("\r\n*accessionTestValue* :");
		auditStr.append(accessionTestValue);
	    auditStr.append("; ");
		auditStr.append("\r\n*pACSClientType* :");
		if (pACSClientType != null)
			auditStr.append(pACSClientType.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*useLoggedUserName* :");
		auditStr.append(useLoggedUserName);
	    auditStr.append("; ");
		auditStr.append("\r\n*primaryIdentifier* :");
		if (primaryIdentifier != null)
			auditStr.append(primaryIdentifier.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*secondaryIdentifier* :");
		if (secondaryIdentifier != null)
			auditStr.append(secondaryIdentifier.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*patientIdentifierParam* :");
		auditStr.append(patientIdentifierParam);
	    auditStr.append("; ");
		auditStr.append("\r\n*issuerOfIdentifierParam* :");
		auditStr.append(issuerOfIdentifierParam);
	    auditStr.append("; ");
		auditStr.append("\r\n*sessionTimeParam* :");
		auditStr.append(sessionTimeParam);
	    auditStr.append("; ");
		auditStr.append("\r\n*primaryIdentifierCode* :");
		auditStr.append(primaryIdentifierCode);
	    auditStr.append("; ");
		auditStr.append("\r\n*secondaryIdentifierCode* :");
		auditStr.append(secondaryIdentifierCode);
	    auditStr.append("; ");
		auditStr.append("\r\n*aESKey* :");
		auditStr.append(aESKey);
	    auditStr.append("; ");
		auditStr.append("\r\n*useEncryptedToken* :");
		auditStr.append(useEncryptedToken);
	    auditStr.append("; ");
		auditStr.append("\r\n*encryptedTokenParam* :");
		auditStr.append(encryptedTokenParam);
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
		
		String keyClassName = "PACSConfiguration";
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
		if (this.getServerAddress() != null)
		{
			sb.append("<serverAddress>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getServerAddress().toString()));
			sb.append("</serverAddress>");		
		}
		if (this.getUserNameParam() != null)
		{
			sb.append("<userNameParam>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getUserNameParam().toString()));
			sb.append("</userNameParam>");		
		}
		if (this.getUsername() != null)
		{
			sb.append("<username>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getUsername().toString()));
			sb.append("</username>");		
		}
		if (this.getPasswordParam() != null)
		{
			sb.append("<passwordParam>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getPasswordParam().toString()));
			sb.append("</passwordParam>");		
		}
		if (this.getPassword() != null)
		{
			sb.append("<password>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getPassword().toString()));
			sb.append("</password>");		
		}
		if (this.getAccessionParam() != null)
		{
			sb.append("<accessionParam>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getAccessionParam().toString()));
			sb.append("</accessionParam>");		
		}
		if (this.getAccessionTestValue() != null)
		{
			sb.append("<accessionTestValue>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getAccessionTestValue().toString()));
			sb.append("</accessionTestValue>");		
		}
		if (this.getPACSClientType() != null)
		{
			sb.append("<pACSClientType>");
			sb.append(this.getPACSClientType().toXMLString()); 
			sb.append("</pACSClientType>");		
		}
		if (this.isUseLoggedUserName() != null)
		{
			sb.append("<useLoggedUserName>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isUseLoggedUserName().toString()));
			sb.append("</useLoggedUserName>");		
		}
		if (this.getPrimaryIdentifier() != null)
		{
			sb.append("<primaryIdentifier>");
			sb.append(this.getPrimaryIdentifier().toXMLString()); 
			sb.append("</primaryIdentifier>");		
		}
		if (this.getSecondaryIdentifier() != null)
		{
			sb.append("<secondaryIdentifier>");
			sb.append(this.getSecondaryIdentifier().toXMLString()); 
			sb.append("</secondaryIdentifier>");		
		}
		if (this.getPatientIdentifierParam() != null)
		{
			sb.append("<patientIdentifierParam>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getPatientIdentifierParam().toString()));
			sb.append("</patientIdentifierParam>");		
		}
		if (this.getIssuerOfIdentifierParam() != null)
		{
			sb.append("<issuerOfIdentifierParam>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getIssuerOfIdentifierParam().toString()));
			sb.append("</issuerOfIdentifierParam>");		
		}
		if (this.getSessionTimeParam() != null)
		{
			sb.append("<sessionTimeParam>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getSessionTimeParam().toString()));
			sb.append("</sessionTimeParam>");		
		}
		if (this.getPrimaryIdentifierCode() != null)
		{
			sb.append("<primaryIdentifierCode>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getPrimaryIdentifierCode().toString()));
			sb.append("</primaryIdentifierCode>");		
		}
		if (this.getSecondaryIdentifierCode() != null)
		{
			sb.append("<secondaryIdentifierCode>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getSecondaryIdentifierCode().toString()));
			sb.append("</secondaryIdentifierCode>");		
		}
		if (this.getAESKey() != null)
		{
			sb.append("<aESKey>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getAESKey().toString()));
			sb.append("</aESKey>");		
		}
		if (this.isUseEncryptedToken() != null)
		{
			sb.append("<useEncryptedToken>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isUseEncryptedToken().toString()));
			sb.append("</useEncryptedToken>");		
		}
		if (this.getEncryptedTokenParam() != null)
		{
			sb.append("<encryptedTokenParam>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getEncryptedTokenParam().toString()));
			sb.append("</encryptedTokenParam>");		
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
			PACSConfiguration domainObject = getPACSConfigurationfromXML(itemEl, factory, domMap);

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
			PACSConfiguration domainObject = getPACSConfigurationfromXML(itemEl, factory, domMap);

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
		
	public static PACSConfiguration getPACSConfigurationfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getPACSConfigurationfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static PACSConfiguration getPACSConfigurationfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!PACSConfiguration.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!PACSConfiguration.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the PACSConfiguration class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (PACSConfiguration)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(PACSConfiguration.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		PACSConfiguration ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (PACSConfiguration)factory.getImportedDomainObject(PACSConfiguration.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new PACSConfiguration();
		}
		String keyClassName = "PACSConfiguration";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (PACSConfiguration)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, PACSConfiguration obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("serverAddress");
		if(fldEl != null)
		{	
    		obj.setServerAddress(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("userNameParam");
		if(fldEl != null)
		{	
    		obj.setUserNameParam(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("username");
		if(fldEl != null)
		{	
    		obj.setUsername(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("passwordParam");
		if(fldEl != null)
		{	
    		obj.setPasswordParam(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("password");
		if(fldEl != null)
		{	
    		obj.setPassword(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("accessionParam");
		if(fldEl != null)
		{	
    		obj.setAccessionParam(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("accessionTestValue");
		if(fldEl != null)
		{	
    		obj.setAccessionTestValue(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("pACSClientType");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setPACSClientType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("useLoggedUserName");
		if(fldEl != null)
		{	
    		obj.setUseLoggedUserName(new Boolean(fldEl.getTextTrim()));	
		}
		fldEl = el.element("primaryIdentifier");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setPrimaryIdentifier(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("secondaryIdentifier");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setSecondaryIdentifier(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("patientIdentifierParam");
		if(fldEl != null)
		{	
    		obj.setPatientIdentifierParam(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("issuerOfIdentifierParam");
		if(fldEl != null)
		{	
    		obj.setIssuerOfIdentifierParam(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("sessionTimeParam");
		if(fldEl != null)
		{	
    		obj.setSessionTimeParam(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("primaryIdentifierCode");
		if(fldEl != null)
		{	
    		obj.setPrimaryIdentifierCode(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("secondaryIdentifierCode");
		if(fldEl != null)
		{	
    		obj.setSecondaryIdentifierCode(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("aESKey");
		if(fldEl != null)
		{	
    		obj.setAESKey(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("useEncryptedToken");
		if(fldEl != null)
		{	
    		obj.setUseEncryptedToken(new Boolean(fldEl.getTextTrim()));	
		}
		fldEl = el.element("encryptedTokenParam");
		if(fldEl != null)
		{	
    		obj.setEncryptedTokenParam(new String(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String ServerAddress = "serverAddress";
		public static final String UserNameParam = "userNameParam";
		public static final String Username = "username";
		public static final String PasswordParam = "passwordParam";
		public static final String Password = "password";
		public static final String AccessionParam = "accessionParam";
		public static final String AccessionTestValue = "accessionTestValue";
		public static final String PACSClientType = "pACSClientType";
		public static final String UseLoggedUserName = "useLoggedUserName";
		public static final String PrimaryIdentifier = "primaryIdentifier";
		public static final String SecondaryIdentifier = "secondaryIdentifier";
		public static final String PatientIdentifierParam = "patientIdentifierParam";
		public static final String IssuerOfIdentifierParam = "issuerOfIdentifierParam";
		public static final String SessionTimeParam = "sessionTimeParam";
		public static final String PrimaryIdentifierCode = "primaryIdentifierCode";
		public static final String SecondaryIdentifierCode = "secondaryIdentifierCode";
		public static final String AESKey = "aESKey";
		public static final String UseEncryptedToken = "useEncryptedToken";
		public static final String EncryptedTokenParam = "encryptedTokenParam";
	}
}

