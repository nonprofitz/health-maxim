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

package ims.oncology.forms.surgerydetails;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbSpecialtyFuncLookup();
	abstract protected void defaultcmbSpecialtyFuncLookupValue();
	abstract protected void bindcmbConsultantPresenceLookup();
	abstract protected void defaultcmbConsultantPresenceLookupValue();
	abstract protected void bindcmbProcedureIntentLookup();
	abstract protected void defaultcmbProcedureIntentLookupValue();
	abstract protected void bindcmbASAGradeLookup();
	abstract protected void defaultcmbASAGradeLookupValue();
	abstract protected void bindcmbDischargeDestinationLookup();
	abstract protected void defaultcmbDischargeDestinationLookupValue();
	abstract protected void bindcmbProcedureTypeLookup();
	abstract protected void defaultcmbProcedureTypeLookupValue();
	abstract protected void bindgrdAssistantColGradeLookup();
	abstract protected void bindcmbSurgeonGradeLookup();
	abstract protected void defaultcmbSurgeonGradeLookupValue();
	abstract protected void bindcmbAnaesthetistGradeLookup();
	abstract protected void defaultcmbAnaesthetistGradeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecbrPreviousSurgeriesValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrSurgeryDetailsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onRadioButtonGroup1ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSpecialtyFuncValueSet(Object value);
	abstract protected void onGrdSubProceduresSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCustomControlProcedureValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbConsultantPresenceValueSet(Object value);
	abstract protected void oncmbProcedureIntentValueSet(Object value);
	abstract protected void onQmbHospitalTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbASAGradeValueSet(Object value);
	abstract protected void oncmbDischargeDestinationValueSet(Object value);
	abstract protected void oncmbProcedureTypeValueSet(Object value);
	abstract protected void onGrdAssistantSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAssistantGridQueryComboBoxTextSubmited(int column, GenForm.lyrSurgeryDetailsLayer.tabProcContainer.grdAssistantRow row, String text) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSurgeonGradeValueSet(Object value);
	abstract protected void oncmbAnaesthetistGradeValueSet(Object value);
	abstract protected void onBtnGraphicFavouritesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnProcedureFavouritesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.recbrPreviousSurgeries().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecbrPreviousSurgeriesValueChanged();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSurgeryDetailstabGenDetActivated();
			}
		});
		this.form.lyrSurgeryDetails().tabProc().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSurgeryDetailstabProcActivated();
			}
		});
		this.form.lyrSurgeryDetails().tabPreOpPossum().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSurgeryDetailstabPreOpPossumActivated();
			}
		});
		this.form.lyrSurgeryDetails().tabStructFind().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSurgeryDetailstabStructFindActivated();
			}
		});
		this.form.lyrSurgeryDetails().tabProcDet().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSurgeryDetailstabProcDetActivated();
			}
		});
		this.form.lyrSurgeryDetails().tabOperativePossum().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSurgeryDetailstabOperativePossumActivated();
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().Group1().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroup1ValueChanged();
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().cmbSpecialtyFunc().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSpecialtyFuncValueSet(value);
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().grdSubProcedures().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSubProceduresSelectionChanged();
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().setcustomControlProcedureValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCustomControlProcedureValueChanged();
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().cmbConsultantPresence().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbConsultantPresenceValueSet(value);
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().cmbProcedureIntent().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbProcedureIntentValueSet(value);
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().qmbHospital().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbHospitalTextSubmited(value);
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().cmbASAGrade().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbASAGradeValueSet(value);
			}
		});
		this.form.lyrSurgeryDetails().tabGenDet().cmbDischargeDestination().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDischargeDestinationValueSet(value);
			}
		});
		this.form.lyrSurgeryDetails().tabProc().cmbProcedureType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbProcedureTypeValueSet(value);
			}
		});
		this.form.lyrSurgeryDetails().tabProc().grdAssistant().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAssistantSelectionChanged();
			}
		});
		this.form.lyrSurgeryDetails().tabProc().grdAssistant().setGridQueryComboBoxTextSubmitedEvent(new GridQueryComboBoxTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, String text) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAssistantGridQueryComboBoxTextSubmited(column, new GenForm.lyrSurgeryDetailsLayer.tabProcContainer.grdAssistantRow(row), text);
			}
		});
		this.form.lyrSurgeryDetails().tabProc().cmbSurgeonGrade().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSurgeonGradeValueSet(value);
			}
		});
		this.form.lyrSurgeryDetails().tabProc().cmbAnaesthetistGrade().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAnaesthetistGradeValueSet(value);
			}
		});
		this.form.lyrSurgeryDetails().tabStructFind().btnGraphicFavourites().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnGraphicFavouritesClick();
			}
		});
		this.form.lyrSurgeryDetails().tabProcDet().btnProcedureFavourites().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnProcedureFavouritesClick();
			}
		});
		this.form.getContextMenus().getGenericGridAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Add, sender);
			}
		});
		this.form.getContextMenus().getGenericGridUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Update, sender);
			}
		});
		this.form.getContextMenus().getGenericGridRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Remove, sender);
			}
		});
		this.form.getContextMenus().getGenericGridViewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.View, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveUpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveUp, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveDownItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveDown, sender);
			}
		});
		this.form.getContextMenus().getGenericGridReplaceItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Replace, sender);
			}
		});
		this.form.getContextMenus().getGenericGridConfirmItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Confirm, sender);
			}
		});
		this.form.getContextMenus().getGenericGridEDIT_VIEW_ICP_ACTIONSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.EDIT_VIEW_ICP_ACTIONS, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbSpecialtyFuncLookup();
		bindcmbConsultantPresenceLookup();
		bindcmbProcedureIntentLookup();
		bindcmbASAGradeLookup();
		bindcmbDischargeDestinationLookup();
		bindcmbProcedureTypeLookup();
		bindgrdAssistantColGradeLookup();
		bindcmbSurgeonGradeLookup();
		bindcmbAnaesthetistGradeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbSpecialtyFuncLookup();
		bindcmbConsultantPresenceLookup();
		bindcmbProcedureIntentLookup();
		bindcmbASAGradeLookup();
		bindcmbDischargeDestinationLookup();
		bindcmbProcedureTypeLookup();
		bindgrdAssistantColGradeLookup();
		bindcmbSurgeonGradeLookup();
		bindcmbAnaesthetistGradeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbSpecialtyFuncLookupValue();
		defaultcmbConsultantPresenceLookupValue();
		defaultcmbProcedureIntentLookupValue();
		defaultcmbASAGradeLookupValue();
		defaultcmbDischargeDestinationLookupValue();
		defaultcmbProcedureTypeLookupValue();
		defaultcmbSurgeonGradeLookupValue();
		defaultcmbAnaesthetistGradeLookupValue();
	}
	private void onlyrSurgeryDetailstabGenDetActivated()
	{
		this.form.lyrSurgeryDetails().showtabGenDet();
		onlyrSurgeryDetailsTabChanged(this.form.lyrSurgeryDetails().tabGenDet());
	}
	private void onlyrSurgeryDetailstabProcActivated()
	{
		this.form.lyrSurgeryDetails().showtabProc();
		onlyrSurgeryDetailsTabChanged(this.form.lyrSurgeryDetails().tabProc());
	}
	private void onlyrSurgeryDetailstabPreOpPossumActivated()
	{
		this.form.lyrSurgeryDetails().showtabPreOpPossum();
		onlyrSurgeryDetailsTabChanged(this.form.lyrSurgeryDetails().tabPreOpPossum());
	}
	private void onlyrSurgeryDetailstabStructFindActivated()
	{
		this.form.lyrSurgeryDetails().showtabStructFind();
		onlyrSurgeryDetailsTabChanged(this.form.lyrSurgeryDetails().tabStructFind());
	}
	private void onlyrSurgeryDetailstabProcDetActivated()
	{
		this.form.lyrSurgeryDetails().showtabProcDet();
		onlyrSurgeryDetailsTabChanged(this.form.lyrSurgeryDetails().tabProcDet());
	}
	private void onlyrSurgeryDetailstabOperativePossumActivated()
	{
		this.form.lyrSurgeryDetails().showtabOperativePossum();
		onlyrSurgeryDetailsTabChanged(this.form.lyrSurgeryDetails().tabOperativePossum());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}