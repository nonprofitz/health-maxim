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
// This code was generated by Peter Martin using IMS Development Environment (version 1.30 build 2012.21169)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.specimencontainerlist;

import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.forms.specimencontainerlist.GenForm.grdSpecContainersRow;
import ims.ocrr.vo.PathSpecimenContainerVo;
import ims.ocrr.vo.PathSpecimenContainerVoCollection;

import java.util.Vector;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.getContextMenus().getOCRRSpecimenContainerADDItem().setVisible(true);
		form.getLocalContext().setHasOrderBeenChanged(false);
		doSearch(false);
	}
	/**
	 * 
	 */
	private void populateSpecContainerGrid(PathSpecimenContainerVoCollection voCollPathSpecimenContainer)
	{
		form.grdSpecContainers().getRows().clear();
		if (voCollPathSpecimenContainer == null)
			return;
		GenForm.grdSpecContainersRow row;
		for(int i=0; i<voCollPathSpecimenContainer.size(); i++){
			row = form.grdSpecContainers().getRows().newRow();
			
			if(voCollPathSpecimenContainer.get(i).getNameIsNotNull())
				row.setcolName(voCollPathSpecimenContainer.get(i).getName());	
			if(voCollPathSpecimenContainer.get(i).getIsActiveIsNotNull())
				row.setcolStatus(voCollPathSpecimenContainer.get(i).getIsActive().booleanValue());
			
				
			
			String volUnits = "";
			if(voCollPathSpecimenContainer.get(i).getVolumeIsNotNull())
				volUnits = voCollPathSpecimenContainer.get(i).getVolume().toString();
			
			if(voCollPathSpecimenContainer.get(i).getVolumeUnitsIsNotNull())
				volUnits += " " + voCollPathSpecimenContainer.get(i).getVolumeUnits().toString();
			
			row.setColVolume(volUnits);
			
			if(voCollPathSpecimenContainer.get(i).getColourIsNotNull())
				row.setcolColour(voCollPathSpecimenContainer.get(i).getColour().getText());
			
			row.setValue(voCollPathSpecimenContainer.get(i));
			form.btnSave().setEnabled(false);
		}
		
	}
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if(formName.equals(form.getForms().OCRR.SpecimenContainerAddEdit))
		{
			populateSearchCriteria();
			doSearch(false);
			//compareOrder(); WDEV-14031 
			setControlState();
		}
	}
	private void populateSearchCriteria() 
	{
		clearScreen();
		if (form.getLocalContext().getFilterIsNotNull())
		{
			form.cmbManufacturer().setValue(form.getLocalContext().getFilter().getManufacturer());
			form.txtName().setValue(form.getLocalContext().getFilter().getName());
		}
		
	}
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		int index = form.grdSpecContainers().getSelectedRowIndex();
		
		switch (menuItemID)
		{
			case ims.ocrr.forms.specimencontainerlist.GenForm.ContextMenus.OCRRSpecimenContainer.ADD:
				
				form.getGlobalContext().OCRR.setPathSpecimenContainerVo(null);
				engine.open(form.getForms().OCRR.SpecimenContainerAddEdit);	
								
			break;
			
			case ims.ocrr.forms.specimencontainerlist.GenForm.ContextMenus.OCRRSpecimenContainer.UPDATE:
				
				grdSpecContainersRow row = form.grdSpecContainers().getRows().get(index);
				PathSpecimenContainerVo voPathSpecimenContainer = row.getValue();
				form.getGlobalContext().OCRR.setPathSpecimenContainerVo(voPathSpecimenContainer);
				form.getGlobalContext().OCRR.setUpdatePathSpecimenContainer(Boolean.TRUE);
				engine.open(form.getForms().OCRR.SpecimenContainerAddEdit);	
								
			break;
			
			case ims.ocrr.forms.specimencontainerlist.GenForm.ContextMenus.OCRRSpecimenContainer.VIEW:
				
				grdSpecContainersRow rowView = form.grdSpecContainers().getRows().get(index);
				PathSpecimenContainerVo voPathSpecimenContainerView = rowView.getValue();
				form.getGlobalContext().OCRR.setPathSpecimenContainerVo(voPathSpecimenContainerView);
				form.getGlobalContext().OCRR.setUpdatePathSpecimenContainer(Boolean.FALSE);
				engine.open(form.getForms().OCRR.SpecimenContainerAddEdit);	
								
			break;
			
			case ims.ocrr.forms.specimencontainerlist.GenForm.ContextMenus.OCRRSpecimenContainer.MOVEUP:
				
				form.grdSpecContainers().moveUp();
				form.btnSave().setEnabled(true);
				form.getLocalContext().setHasOrderBeenChanged(true);
				setControlState();
				compareOrder();
				
			break;
				
			case ims.ocrr.forms.specimencontainerlist.GenForm.ContextMenus.OCRRSpecimenContainer.MOVEDOWN:
				
				form.grdSpecContainers().moveDown();
				form.btnSave().setEnabled(true);
				form.getLocalContext().setHasOrderBeenChanged(true);
				setControlState();
				compareOrder();
		}
		
	}

	private void compareOrder() 
	{	
		Vector<PathSpecimenContainerVo> v=new Vector<PathSpecimenContainerVo>();
		Vector<PathSpecimenContainerVo> ve=new Vector<PathSpecimenContainerVo>();
		
		for (int i=0;i<form.grdSpecContainers().getRows().size();i++)
		{
			PathSpecimenContainerVo specimen= form.grdSpecContainers().getRows().get(i).getValue();
			specimen.setPathSpecimenOrder(i);
			v.add(specimen);
		}
		if (form.getLocalContext().getinitialOrderIsNotNull())
			for (int j=0;j<form.getLocalContext().getinitialOrder().size();j++)
			{
				ve.add(form.getLocalContext().getinitialOrder().get(j));
			}
		if (v.equals(ve))
		{
			form.btnSave().setEnabled(false);
			form.getLocalContext().setHasOrderBeenChanged(false);
		}
		else
		{
			form.btnSave().setEnabled(true);
			form.getLocalContext().setHasOrderBeenChanged(true);
		}
		
	}

	protected void onGrdSpecContainersSelectionChanged() throws PresentationLogicException 
	{
		setControlState();		
	}

	private void setControlState() 
	{
		form.getContextMenus().getOCRRSpecimenContainerUPDATEItem().setVisible(form.grdSpecContainers().getValue() != null);
		form.getContextMenus().getOCRRSpecimenContainerVIEWItem().setVisible(form.grdSpecContainers().getValue() != null);
		form.getContextMenus().getOCRRSpecimenContainerMOVEUPItem().setVisible(form.grdSpecContainers().getSelectedRow()!=null&&form.grdSpecContainers().getSelectedRowIndex()!=0&&form.getLocalContext().getMovingRowsAllowed() ? true : false);
		form.getContextMenus().getOCRRSpecimenContainerMOVEDOWNItem().setVisible(form.grdSpecContainers().getSelectedRow()!=null&&form.grdSpecContainers().getSelectedRowIndex()!=form.grdSpecContainers().getRows().size()-1 &&form.getLocalContext().getMovingRowsAllowed() ? true : false);	
		form.btnSave().setEnabled(form.cmbManufacturer().getValue()==null&&form.getLocalContext().getMovingRowsAllowedIsNotNull()&&form.getLocalContext().getMovingRowsAllowed()&&form.getLocalContext().getHasOrderBeenChangedIsNotNull()&&form.getLocalContext().getHasOrderBeenChanged() ? true : false);
	}
	@Override
	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		PathSpecimenContainerVoCollection specimens=new PathSpecimenContainerVoCollection();
		for (int i=0;i<form.grdSpecContainers().getRows().size();i++)
		{
			PathSpecimenContainerVo specimen= form.grdSpecContainers().getRows().get(i).getValue();
			specimen.setPathSpecimenOrder(i);
			specimens.add(specimen);
		}
			
		if (specimens!=null)
			try 
			{
				domain.savePathSpecimenContainers(specimens);
				form.getLocalContext().setinitialOrder(specimens);
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			}
					
		form.grdSpecContainers().setValue(null);
		form.getLocalContext().setHasOrderBeenChanged(false);
		setControlState();
		form.btnSave().setEnabled(false);
		populateSearchCriteria();
		doSearch(true);
	}
	
	private void clearScreen()
	{
		form.txtName().setValue(null);
		form.cmbManufacturer().setValue(null);
		form.grdSpecContainers().getRows().clear();
	}
	
	private void doSearch(boolean showErrors)
	{
		form.getLocalContext().setHasOrderBeenChanged(false); //WDEV-14031
		form.grdSpecContainers().getRows().clear();
		String[] error = getCriteriaValidationErrors();
		if (error != null && error.length > 0)
		{
			if (showErrors)
				engine.showErrors(error);
			setControlState();
			return;
		}
		
		if (form.cmbManufacturer().getValue()!=null)
			form.getLocalContext().setMovingRowsAllowed(false);
		else
			form.getLocalContext().setMovingRowsAllowed(true);
		
		PathSpecimenContainerVo filter = new PathSpecimenContainerVo();
		filter.setManufacturer(form.cmbManufacturer().getValue());
		filter.setName(form.txtName().getValue());
		form.getLocalContext().setFilter(filter);
		form.getLocalContext().setinitialOrder(domain.listPathSpecimenContainers(filter));
		populateSpecContainerGrid(form.getLocalContext().getinitialOrder());
		if (!form.getLocalContext().getinitialOrderIsNotNull() || form.getLocalContext().getinitialOrder().size()==0)
		{
			engine.showMessage("No records found.");
		}
		setControlState();
	}
	
	private String[] getCriteriaValidationErrors() {
		if (form.cmbManufacturer().getValue() == null && form.txtName().getValue() == null)
			return new String[]{"You must specify at least one search criteria"};
		return null;
	}
	@Override
	protected void onImbClearClick() throws PresentationLogicException 
	{
		clearScreen();
		//wdev-16419
		form.getLocalContext().setMovingRowsAllowed(false);
		setControlState();
		//--------------
		form.getLocalContext().setFilter(null);
		
	}
	@Override
	protected void onImbSearchClick() throws PresentationLogicException 
	{
		doSearch(true);
		
	}
	
	
}
