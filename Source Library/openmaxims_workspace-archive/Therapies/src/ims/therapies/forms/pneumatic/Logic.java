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
// This code was generated by Peter Martin using IMS Development Environment (version 1.42 build 2202.25904)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.pneumatic;

import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.spinalinjuries.vo.lookups.PneumaticCycleCollection;
import ims.spinalinjuries.vo.lookups.PneumaticStartingPosCollection;
import ims.therapies.forms.pneumatic.GenForm.grdPneumaticRow;
import ims.therapies.vo.ElectrotherapyPneumaticShortVo;
import ims.therapies.vo.ElectrotherapyPneumaticShortVoCollection;
import ims.therapies.vo.ElectrotherapyPneumaticTreatmentVo;
import ims.therapies.vo.ElectrotherapyPneumaticTreatmentVoCollection;
import ims.therapies.vo.ElectrotherapyPneumaticVo;
import ims.therapies.vo.TreatmentEquipmentConfigVo;
import ims.therapies.vo.TreatmentEquipmentConfigVoCollection;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.PersonName;
import ims.therapies.vo.lookups.TreatmentEquipmentTypeConfig;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws PresentationLogicException
	{
		initialize();
		open();
	}
	
	public void initialize() throws PresentationLogicException 
	{		
		form.ctnPneumatic().setCollapsed(true);
		form.ctnPneumatic().lyrPneumatic().tabEmpty().setHeaderVisible(false);
		checkLookups();
		loadMachineUsedCombo();	
	}
	
	private void checkLookups() throws PresentationLogicException
	{
		StringBuffer exceptions = new StringBuffer();	
		PneumaticCycleCollection pneumaticCycleColl = LookupHelper.getPneumaticCycle(domain.getLookupService());
		if(pneumaticCycleColl == null || pneumaticCycleColl.size() == 0)
		{
			exceptions.append("Please configure PneumaticCycle lookup");
			exceptions.append("\n");
		}
		
		PneumaticStartingPosCollection pneumaticStartingColl = LookupHelper.getPneumaticStartingPos(domain.getLookupService());
		if(pneumaticStartingColl == null || pneumaticStartingColl.size() == 0)
		{
			exceptions.append("Please configure PneumaticStartingPos lookup");
			exceptions.append("\n");
		}

		if(exceptions.length() > 0)
			throw new PresentationLogicException(exceptions.toString());
		
	}

	private void loadMachineUsedCombo()
	{
		TreatmentEquipmentConfigVoCollection voCollTreatmentEquipment = domain.listTreatmentEquipmentConfigs(TreatmentEquipmentTypeConfig.PNEUMATIC);
		if(voCollTreatmentEquipment!=null)
		{
			for (int i = 0; i < voCollTreatmentEquipment.size(); i++) 
			{
				form.ctnPneumatic().lyrPneumatic().tabDetails().cmbMachineUsed().newRow(voCollTreatmentEquipment.get(i), 
																voCollTreatmentEquipment.get(i).getDescription());			
			}
		}		
	}
	private void open() 
	{
		clear();
		resetContextVariables();		
							
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			populateParentNodes(domain.listElectrotheraphyPneumaticByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));			
		}
									
		form.setMode(FormMode.VIEW);
		reselectUpdatedNode();			
	}
	private void populateParentNodes(ElectrotherapyPneumaticShortVoCollection voElectroPneumaticColl)
	{
		if (voElectroPneumaticColl == null || voElectroPneumaticColl.size() <= 0 ) 
			return;
		
		for(int i=0; i<voElectroPneumaticColl.size(); i++)
		{
			populateParentNode(voElectroPneumaticColl.get(i));			
		}	
	}

	private void populateParentNode(ElectrotherapyPneumaticShortVo voElectroPneumaticShort)
	{
		GenForm.grdPneumaticRow parRow = form.grdPneumatic().getRows().newRow();
		parRow.setColMachineUsed(voElectroPneumaticShort.getAuthoringDateTime().toString());      //+ " - " + 
				// voElectroPneumaticShort.getAuthoringCP().toString());
		parRow.setValue(voElectroPneumaticShort);			
//		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && voElectroPneumaticShort.getClinicalContact().getID_ClinicalContact().equals
//				(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
//		{
			form.grdPneumatic().setValue(voElectroPneumaticShort);			
			expandParentNode(parRow);
//		}
		
	}

	private void expandParentNode(grdPneumaticRow selectedRow)
	{
		if (selectedRow.getValue() instanceof ElectrotherapyPneumaticShortVo == false ) return;
		
		form.getLocalContext().setSelectedParentInstance(getParentFromDomain((ElectrotherapyPneumaticShortVo) selectedRow.getValue()));		
		if (form.getLocalContext().getSelectedParentInstance() == null ) return; 				

		ElectrotherapyPneumaticVo voParentInstance = form.getLocalContext().getSelectedParentInstance();				
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
				&& (voParentInstance.getClinicalContact().getID_ClinicalContact().equals
									(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact())))
		{
			// If this is the Golden Node then we'll colour it golden (ok then beige).
			form.getLocalContext().setGoldenInstanceFound(new Boolean(true));
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
			selectedRow.setBackColor(Color.Beige);			
		}
		
		if (voParentInstance.getPneumaticTreatment() != null)  
		{
			selectedRow.setValue(voParentInstance);
			selectedRow.setExpanded(true);
			populateChildNodes(selectedRow, voParentInstance.getPneumaticTreatment());
		}
		populateParentInstanceControls(voParentInstance);		
	}

	private void populateChildNodes(grdPneumaticRow parRow, ElectrotherapyPneumaticTreatmentVoCollection voPneumaticTreatmentColl)
	{
		parRow.getRows().clear();
		
		if (voPneumaticTreatmentColl == null || voPneumaticTreatmentColl.size()<=0) 
			return;		
		
		voPneumaticTreatmentColl.sort();
		for(int i=0; i<voPneumaticTreatmentColl.size(); i++)
		{
			if (parRow != null)
			{
				GenForm.grdPneumaticRow childRow = parRow.getRows().newRow();
				populateChildNode(childRow, voPneumaticTreatmentColl.get(i));				
			}
		}
		//reselect parent
		parRow.setValue(form.getLocalContext().getSelectedParentInstance());
		form.grdPneumatic().setValue(parRow.getValue());
		parRow.setExpanded(true);
	}

	private void populateChildNode(grdPneumaticRow childRow, ElectrotherapyPneumaticTreatmentVo voPneumaticTreatment)
	{
		if (voPneumaticTreatment == null) return;		
		
		if(voPneumaticTreatment.getMachineUsed() != null
			&& voPneumaticTreatment.getMachineUsed().getDescriptionIsNotNull())
			childRow.setColMachineUsed(voPneumaticTreatment.getMachineUsed().getDescription().toString());
		if(voPneumaticTreatment.getStartingPosition() != null)
			childRow.setColStartingPosition(voPneumaticTreatment.getStartingPosition().toString());
		if(voPneumaticTreatment.getArea() != null)
			childRow.setColArea(voPneumaticTreatment.getArea().toString());
		if(voPneumaticTreatment.getCycle() != null)
			childRow.setColCycle(voPneumaticTreatment.getCycle().toString());
		childRow.setValue(voPneumaticTreatment);
	
		//if not saved then set the colour
		if(voPneumaticTreatment.getID_ElectrotherapyPneumaticTreatment() == null)
			childRow.setTextColor(Color.Red);
	}

	private ElectrotherapyPneumaticVo getParentFromDomain(ElectrotherapyPneumaticShortVo voElectrotherapyPneumaticShort)
	{
		//return domain.getElectrotheraphyPneumaticVoByClinicalContact(voElectrotherapyPneumaticShort.getClinicalContact());
		return domain.getElectrotheraphyPneumatic(voElectrotherapyPneumaticShort);//	WDEV-13588
	}

	private void resetContextVariables()
	{
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(false));
		form.getLocalContext().setGoldenInstanceFound(new Boolean(false));
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		form.getLocalContext().setSelectedParentInstance(null);
		form.getLocalContext().setSelectedChildInstance(null);
		
	}

	private void clear()
	{
		form.grdPneumatic().getRows().clear();
		clearChildInstanceControls();
	}

	private void reselectUpdatedNode()
	{
		if (form.getLocalContext().getUpdatedChildIsNotNull())
		{
			form.grdPneumatic().setValue(form.getLocalContext().getUpdatedChild());
			getSelectedInstance();
			form.getLocalContext().setUpdatedChild(null);
		}
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			open();
	}
	private boolean save()
	{
		if(checkForUnsavedChild())
			return false;
		
		ElectrotherapyPneumaticVo voElectrotherapyPneumatic = populateInstanceData(form.getLocalContext().getSelectedParentInstance());

		if (voElectrotherapyPneumatic.getClinicalContact() == null)
			voElectrotherapyPneumatic.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			
		String[] arrErrors =  voElectrotherapyPneumatic.validate();	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedParentInstance(domain.saveElectrotherapyPneumaticTreatmentVo(voElectrotherapyPneumatic));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A Electrotherapy Pneumatic Therapy record already exists for this SOAP clinical contact. " + e.getMessage());
			open();
			return false;
		}
		
		setUpdatedChild();
		return true;		
	}

	private void setUpdatedChild()
	{
		if (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo)		
		{
			form.getLocalContext().setUpdatedChild((ElectrotherapyPneumaticTreatmentVo) form.grdPneumatic().getValue());
		}
		else
		{
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE))
			{
				if(form.getLocalContext().getSelectedParentInstance().getPneumaticTreatment().size() > 0)//WDEV-439
				{
					form.getLocalContext().getSelectedParentInstance().getPneumaticTreatment().sort();
					form.getLocalContext().setUpdatedChild(
							form.getLocalContext().getSelectedParentInstance().getPneumaticTreatment().get(
									form.getLocalContext().getSelectedParentInstance().getPneumaticTreatment().size() - 1));
				}
			}
			
		}
	}

	private ElectrotherapyPneumaticVo populateInstanceData(ElectrotherapyPneumaticVo voElectrotherapyPneumatic)
	{
		if (voElectrotherapyPneumatic == null)
			voElectrotherapyPneumatic = new ElectrotherapyPneumaticVo();
		
		populateParentInstanceData(voElectrotherapyPneumatic);						

		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			populateChildCollectionFromGrid(voElectrotherapyPneumatic);			
		}
		else 		// Update child instance.
		{
			ElectrotherapyPneumaticTreatmentVo voPneumaticTreatment = form.getLocalContext().getSelectedChildInstance();
			populateChildInstanceData(voPneumaticTreatment);
			form.getLocalContext().setSelectedChildInstance(voPneumaticTreatment);
			
			for (int i=0; i < voElectrotherapyPneumatic.getPneumaticTreatment().size(); i++)
			{
				if (voElectrotherapyPneumatic.getPneumaticTreatment().get(i).getID_ElectrotherapyPneumaticTreatment() == 
					form.getLocalContext().getSelectedChildInstance().getID_ElectrotherapyPneumaticTreatment())
				{						
					voElectrotherapyPneumatic.getPneumaticTreatment().set(i, form.getLocalContext().getSelectedChildInstance());
				}
			}								
		}
		return voElectrotherapyPneumatic;
	}

	private void populateParentInstanceData(ElectrotherapyPneumaticVo voElectrotherapyPneumatic)
	{
		voElectrotherapyPneumatic.setAuthoringCP(form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().getValue());
		voElectrotherapyPneumatic.setAuthoringDateTime(form.ctnPneumatic().lyrPneumatic().tabPneumatic().dtimAuthoringDateTime().getValue());	
		voElectrotherapyPneumatic.setWarningGiven(form.ansWarning().getValue());
	}

	private void populateChildCollectionFromGrid(ElectrotherapyPneumaticVo voElectrotherapyPneumatic)
	{
		if (form.grdPneumatic().getValue() == null) 
			return;

		if (voElectrotherapyPneumatic.getPneumaticTreatment() == null)
			voElectrotherapyPneumatic.setPneumaticTreatment(new ElectrotherapyPneumaticTreatmentVoCollection());
		
		GenForm.grdPneumaticRow parentRow = form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticShortVo || form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticVo ? 
										    form.grdPneumatic().getSelectedRow() : form.grdPneumatic().getSelectedRow().getParentRow();		
		
        if (parentRow.getRows().size() > 0 )
        	voElectrotherapyPneumatic.getPneumaticTreatment().clear();
										    
		for (int i=0; i < parentRow.getRows().size(); i++)
        {
			voElectrotherapyPneumatic.getPneumaticTreatment().add((ElectrotherapyPneumaticTreatmentVo) parentRow.getRows().get(i).getValue());
        }
	}

	private boolean checkForUnsavedChild() 
	{	
		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			if(! addOrUpdateChild())
				return true;
		}
		return false;
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onCmbMachineValueChanged() throws PresentationLogicException 
	{
		if(form.ctnPneumatic().lyrPneumatic().tabDetails().cmbMachineUsed().getValue()!=null)
		{
			TreatmentEquipmentConfigVo 	voTreatmentEquipment = form.ctnPneumatic().lyrPneumatic().tabDetails().cmbMachineUsed().getValue();
			form.ctnPneumatic().lyrPneumatic().tabDetails().txtModel().setValue(voTreatmentEquipment.getModel());
			form.ctnPneumatic().lyrPneumatic().tabDetails().txtSerialNumber().setValue(voTreatmentEquipment.getSerialNumber());
		}
	}
	protected void onBtnOkClick() throws PresentationLogicException
	{
		addOrUpdateChild();
	}
	private boolean addOrUpdateChild()
	{
		if (Boolean.FALSE.equals(form.getLocalContext().getGoldenInstanceSelected()))//WDEV-14292			
			if(!newParentNode(form.getLocalContext().getSelectedParentInstance()))
				return false;				
				
		ElectrotherapyPneumaticTreatmentVo voPneumaticTreatment = form.getLocalContext().getSelectedChildInstance();
		
		if (voPneumaticTreatment == null)
			voPneumaticTreatment = new ElectrotherapyPneumaticTreatmentVo(); 

		populateChildInstanceData(voPneumaticTreatment);

		if (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo 
			&& form.getLocalContext().getSelectedChildInstanceIsNotNull())
		{
			promoteUpdatedChild(voPneumaticTreatment);
			newChildInstance();
			updateControlsState();
			return true;
		}
		else
		{
			if(newChildNode(voPneumaticTreatment))	
				return true;
		}
		return true;
		
	}

	private boolean newChildNode(ElectrotherapyPneumaticTreatmentVo voPneumaticTreatment)
	{
		if (form.getLocalContext().getSelectedChildInstance() != null) 
			return false;
		
		if (voPneumaticTreatment.countFieldsWithValue() >= 1)
		{
			String strErrors[] = voPneumaticTreatment.validate();
		
			if(strErrors != null && strErrors.length > 0)
			{
				engine.showErrors(strErrors);
				return false;
			}
	 				
			promoteChild(voPneumaticTreatment);			
			clearChildInstanceControls();
			return true;
		}
		return false;
	}

	private void promoteChild(ElectrotherapyPneumaticTreatmentVo voPneumaticTreatment)
	{
		if (voPneumaticTreatment == null) 
			return;
		
		GenForm.grdPneumaticRow childRow = null; 
		form.grdPneumatic().setValue(form.getLocalContext().getSelectedParentInstance());
		if(form.grdPneumatic().getValue() != null)
		{
			if(form.grdPneumatic().getSelectedRow().getValue() instanceof ElectrotherapyPneumaticTreatmentVo)
				childRow = form.grdPneumatic().getSelectedRow().getParentRow().getRows().newRow();
			else
				childRow = form.grdPneumatic().getSelectedRow().getRows().newRow();
			
			populateChildNode(childRow, voPneumaticTreatment);	
		}
		
	}

	private void promoteUpdatedChild(ElectrotherapyPneumaticTreatmentVo voPneumaticTreatment)
	{
		if (voPneumaticTreatment == null) 
			return;
		
		form.grdPneumatic().setValue(form.getLocalContext().getSelectedChildInstance());
		populateChildNode(form.grdPneumatic().getSelectedRow(),voPneumaticTreatment);
	}

	private void populateChildInstanceData(ElectrotherapyPneumaticTreatmentVo voPneumaticTreatment)
	{
		voPneumaticTreatment = populateDataFromScreen(voPneumaticTreatment);
	}

	private boolean newParentNode(ElectrotherapyPneumaticVo voNewParent)
	{
		if (voNewParent == null) 
			return true;
		
		if(form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().getValue()==null || form.ctnPneumatic().lyrPneumatic().tabPneumatic().dtimAuthoringDateTime().getValue() == null)
		{
			engine.showMessage("'Authoring HCP' and 'Authoring Date / Time' are a mandatory fields.");
			return false;
		}
		
		ElectrotherapyPneumaticShortVo voParentShort = new ElectrotherapyPneumaticShortVo();
		voParentShort.setAuthoringCP(form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().getValue());
		voParentShort.setAuthoringDateTime(form.ctnPneumatic().lyrPneumatic().tabPneumatic().dtimAuthoringDateTime().getValue());
		voParentShort.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		GenForm.grdPneumaticRow parentRow = form.grdPneumatic().getRows().newRow();			
		parentRow.setColMachineUsed(voParentShort.getAuthoringDateTime().toString()+ " - " + 
							   voParentShort.getAuthoringCP().toString());			
		parentRow.setValue(voParentShort);
		parentRow.setBackColor(Color.Beige);
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
		parentRow.setExpanded(true);
		form.grdPneumatic().setValue(voParentShort);	
		return true;
	}

	protected void onBtnCancelDetailsClick() throws PresentationLogicException 
	{
		clearChildInstanceControls();
	}
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		if (sender.equals(form.grdPneumatic()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add:
					newInstance();					
					break;				
				case GenForm.ContextMenus.GenericGrid.Update:
					updateInstance();
					break;
				case GenForm.ContextMenus.GenericGrid.Remove:
					removeRecord();
					break;
			}
		}		
		
	}
	private void updateInstance()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticShortVo));
		form.setMode(FormMode.EDIT);
		if (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo)			
		{
			ElectrotherapyPneumaticTreatmentVo voCachedChild =  (ElectrotherapyPneumaticTreatmentVo) form.grdPneumatic().getValue(); 
			if ( voCachedChild.getID_ElectrotherapyPneumaticTreatment() == null)
			{
				populateChildInstanceControls(voCachedChild);
			}			
		}
	}
	private void removeRecord()
	{
		form.grdPneumatic().removeSelectedRow();		
	}
	private void newInstance() 
	{
		if (form.grdPneumatic().getValue() == null || ((form.getLocalContext().getSelectedParentInstanceIsNotNull() 
				&& form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))))
		{
			newParentInstance();			
		}
		else
//		if (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo)
//		{
			newChildInstance();
//		}
		form.setMode(FormMode.EDIT);
	}
	private void newChildInstance()
	{
		clearChildInstanceControls();
		form.getLocalContext().setSelectedChildInstance(null);
		if (form.grdPneumatic().getSelectedRow().getParentRow() != null)
			form.grdPneumatic().setValue(form.grdPneumatic().getSelectedRow().getParentRow().getValue());
	}

	private void clearChildInstanceControls()
	{
		form.ctnPneumatic().lyrPneumatic().tabDetails().txtModel().setValue(null);
		form.ctnPneumatic().lyrPneumatic().tabDetails().txtSerialNumber().setValue(null);
		
		clearScreen();
	}

	private void newParentInstance()
	{
		ElectrotherapyPneumaticVo voNewParent = new ElectrotherapyPneumaticVo(); 
		Hcp voHcp = (Hcp) domain.getHcpUser();
		if(voHcp != null)
			voNewParent.setAuthoringCP(voHcp);

		voNewParent.setAuthoringDateTime(new DateTime());
		voNewParent.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voNewParent.setPneumaticTreatment(new ElectrotherapyPneumaticTreatmentVoCollection());
		populateParentInstanceControls(voNewParent);		
		clearChildInstanceControls();
		form.getLocalContext().setSelectedParentInstance(voNewParent);	
		form.getLocalContext().setSelectedChildInstance(null);
	}

	private void populateParentInstanceControls(ElectrotherapyPneumaticVo voElectrotherapyPneumatic)
	{
		if(voElectrotherapyPneumatic != null)
		{
			form.ctnPneumatic().lyrPneumatic().tabPneumatic().dtimAuthoringDateTime().setValue(voElectrotherapyPneumatic.getAuthoringDateTime());
			if(voElectrotherapyPneumatic.getAuthoringCPIsNotNull())
				form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().newRow(voElectrotherapyPneumatic.getAuthoringCP(), voElectrotherapyPneumatic.getAuthoringCP().toString());
			form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().setValue(voElectrotherapyPneumatic.getAuthoringCP());
			form.ansWarning().setValue(voElectrotherapyPneumatic.getWarningGiven());
		}
	}
	protected void onQmbAuthoringCPTextSubmited(String value) throws PresentationLogicException 
	{
		form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().clear();
		Hcp filter = new Hcp();
		PersonName name = new PersonName();
		name.setSurname(form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().getEditedText());
		filter.setQueryName(name);
	
		HcpCollection voHCPColl = domain.listHcps(filter);
		
		if(voHCPColl != null)
		{
			for (int i = 0; i < voHCPColl.size(); i++)
			{
				form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().newRow(voHCPColl.get(i), voHCPColl.get(i).getName().toString());
			}
			if (voHCPColl.size() == 1)
			{
				form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().setValue(voHCPColl.get(0));
			}
			else if (voHCPColl.size() > 1)
			{
				form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().showOpened();		
			}
		}
		
	}
	protected void onBtnNewClick() throws PresentationLogicException 
	{
		newInstance();
	}
	protected void onFormModeChanged() 
	{
		updateControlsState();
	}
	private void updateControlsState()
	{
		form.btnNew().setVisible(form.getMode().equals(FormMode.VIEW) 
				&& form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
				&& Boolean.FALSE.equals(form.getLocalContext().getGoldenInstanceFound())); //WDEV-14292

		form.ctnPneumatic().setCollapsed(form.getLocalContext().getSelectedParentInstance() == null);						

		if (form.grdPneumatic().getValue() == null)
			form.ctnPneumatic().lyrPneumatic().showtabEmpty();

		setParentTabVisability();						

		setDetailsTabVisibility();		

		showHeaderOrDetailsTab();																				

		updateContextMenusState();
	}

	private void setParentTabVisability()
	{
		form.ctnPneumatic().lyrPneumatic().tabPneumatic().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull());
	}

	private void setDetailsTabVisibility()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{	  
			form.ctnPneumatic().lyrPneumatic().tabDetails().setHeaderVisible(form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo);									
		}
		else
		{		
			form.ctnPneumatic().lyrPneumatic().tabDetails().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull() && 
					Boolean.FALSE.equals(form.getLocalContext().getUpdatingParent())); //WDEV-14292
			
			setAddApplyCaption();			
		}			

		enableDetailsButtons();	
	}

	private void enableDetailsButtons()
	{
		boolean boolVisible = (form.getMode().equals(FormMode.EDIT) &&
				  form.ctnPneumatic().lyrPneumatic().tabDetails().isHeaderVisible());// &&
				  //form.getLocalContext().getSelectedChildInstance() == null);

		form.ctnPneumatic().lyrPneumatic().tabDetails().btnOK().setVisible(boolVisible);
		form.ctnPneumatic().lyrPneumatic().tabDetails().btnCancelDetails().setVisible(boolVisible);
	}

	private void setAddApplyCaption()
	{
		form.ctnPneumatic().lyrPneumatic().tabDetails().btnOK().setText("Add");
		
		if (form.getLocalContext().getSelectedChildInstance() == null &&
			 (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo))
				form.ctnPneumatic().lyrPneumatic().tabDetails().btnOK().setText("Apply");
	}

	private void showHeaderOrDetailsTab()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			if (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticShortVo)		
				form.ctnPneumatic().lyrPneumatic().showtabPneumatic();
			else if(form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticVo)
				form.ctnPneumatic().lyrPneumatic().showtabPneumatic();
			else if (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo)
				form.ctnPneumatic().lyrPneumatic().showtabDetails();
			
		}
		else
		{
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
				form.ctnPneumatic().lyrPneumatic().showtabPneumatic();
			else
				form.ctnPneumatic().lyrPneumatic().showtabDetails();
			
			if (form.getLocalContext().getSelectedParentInstanceIsNotNull() && 
					(form.getLocalContext().getSelectedParentInstance().getID_ElectrotherapyPneumaticIsNotNull()))
				enableParentControls(false);		
			else
				enableParentControls(true);			
		}
	}

	private void enableParentControls(boolean enable)
	{
		form.ctnPneumatic().lyrPneumatic().tabPneumatic().dtimAuthoringDateTime().setEnabled(enable);
		form.ctnPneumatic().lyrPneumatic().tabPneumatic().qmbAuthoringCP().setEnabled(enable);
	}

	private void updateContextMenusState()
	{
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
		{
			if(form.getLocalContext().getGoldenInstanceSelectedIsNotNull()
				&& form.getLocalContext().getGoldenInstanceSelected().booleanValue())
			{
				if (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticShortVo)
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);						
				else if (form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo)
					form.getContextMenus().getGenericGridUpdateItem().setText("Edit Pneumatic Detail");
				
				form.getContextMenus().getGenericGridAddItem().setText("Add Pneumatic Detail");			
	
				form.getContextMenus().getGenericGridUpdateItem().setVisible((form.getMode().equals(FormMode.VIEW)&& 
																			 form.grdPneumatic().getSelectedRowIndex()>=0 && 
																			 form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo) ||
																			 (form.getMode().equals(FormMode.EDIT) &&
																			 form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo &&
																			 ((ElectrotherapyPneumaticTreatmentVo)form.grdPneumatic().getValue()).getID_ElectrotherapyPneumaticTreatment() == null));																								
			}
			else
			{ 
				if (Boolean.TRUE.equals(form.getLocalContext().getGoldenInstanceFound())) //WDEV-14292
				{
					form.getContextMenus().hideAllGenericGridMenuItems();
					return;
				}
				else
				{
					form.getContextMenus().getGenericGridAddItem().setText("New Pneumatic Therapy");
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);				
				}
			}
			
			form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.VIEW));
			form.getContextMenus().getGenericGridRemoveItem().setVisible(form.getMode().equals(FormMode.EDIT) &&
					 form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo &&
					 ((ElectrotherapyPneumaticTreatmentVo)form.grdPneumatic().getValue()).getID_ElectrotherapyPneumaticTreatment() == null);
		}
		else
		{
			form.getContextMenus().hideAllGenericGridMenuItems();
		}
		
	}
	protected void onGrdPneumaticSelectionChanged() throws PresentationLogicException 
	{
		getSelectedInstance();
	}

	private void getSelectedInstance()
	{
		if (form.getMode().equals(FormMode.EDIT)) 
		{
			updateContextMenusState();
			return;
		}		

		if(form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticVo)
		{
			populateParentInstanceControls((ElectrotherapyPneumaticVo) form.grdPneumatic().getValue());
		}
		else if(form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticShortVo)
		{									 
			form.getLocalContext().setSelectedParentInstance(getParentFromDomain((ElectrotherapyPneumaticShortVo) form.grdPneumatic().getValue()));
			if (form.getLocalContext().getSelectedParentInstanceIsNotNull())
			{
				populateParentInstanceControls(form.getLocalContext().getSelectedParentInstance());
				populateChildNodes(form.grdPneumatic().getSelectedRow(),form.getLocalContext().getSelectedParentInstance().getPneumaticTreatment());
			}
			form.getLocalContext().setSelectedChildInstance(null);
			clearChildInstanceControls();
		}		
		else if(form.grdPneumatic().getValue() instanceof ElectrotherapyPneumaticTreatmentVo)
		{
			GenForm.grdPneumaticRow parentRow = form.grdPneumatic().getSelectedRow().getParentRow();
			populateParentInstanceControls((ElectrotherapyPneumaticVo) parentRow.getValue());
			form.getLocalContext().setSelectedParentInstance((ElectrotherapyPneumaticVo) parentRow.getValue());
			
			form.getLocalContext().setSelectedChildInstance((ElectrotherapyPneumaticTreatmentVo) form.grdPneumatic().getValue());
			populateChildInstanceControls(form.getLocalContext().getSelectedChildInstance());			
		}
 
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			form.getLocalContext().setGoldenInstanceSelected(form.getLocalContext().getSelectedParentInstanceIsNotNull() ? new Boolean(form.getLocalContext().getSelectedParentInstance().getClinicalContact().getID_ClinicalContact().equals(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact())): false);
		
		updateControlsState();		
	}

	private void populateChildInstanceControls(ElectrotherapyPneumaticTreatmentVo voChildInstance)
	{
		if(voChildInstance == null) 
			return;
		
		populateScreenFromData(voChildInstance);
		if(voChildInstance.getMachineUsedIsNotNull())
		{
			form.ctnPneumatic().lyrPneumatic().tabDetails().txtModel().setValue(voChildInstance.getMachineUsed().getModel());
			form.ctnPneumatic().lyrPneumatic().tabDetails().txtSerialNumber().setValue(voChildInstance.getMachineUsed().getSerialNumber());
		}
		form.getLocalContext().setSelectedChildInstance(voChildInstance);
	}	
}