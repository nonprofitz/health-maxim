// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.onexaminationcomponent;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTLTOnwardReferralLookup();
	abstract protected void defaultcmbTLTOnwardReferralLookupValue();
	abstract protected void bindcmbOtherLookup();
	abstract protected void defaultcmbOtherLookupValue();
	abstract protected void bindcmbTLTDischTypeLookup();
	abstract protected void defaultcmbTLTDischTypeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyr1TabChanged(ims.framework.LayerBridge tab);
	abstract protected void onCcDocumentsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcClinicalNoteValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcPrescriptionValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcOutcomeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrTLTTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onCcTLTValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroup1ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelTLTOutcomeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveTLTOutcomeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditTLTOutcomeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTLTOnwardReferralValueSet(Object value);
	abstract protected void oncmbOtherValueSet(Object value);
	abstract protected void oncmbTLTDischTypeValueSet(Object value);
	abstract protected void onCmbTLTDischTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
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
		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
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
		this.form.lyr1().tabPatientDocuments().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabPatientDocumentsActivated();
			}
		});
		this.form.lyr1().tabClinicalNote().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabClinicalNoteActivated();
			}
		});
		this.form.lyr1().tabPrescription().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabPrescriptionActivated();
			}
		});
		this.form.lyr1().tabOutcome().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabOutcomeActivated();
			}
		});
		this.form.lyr1().tabTLT().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabTLTActivated();
			}
		});
		this.form.lyr1().tabFinalReport().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabFinalReportActivated();
			}
		});
		this.form.lyr1().tabPatientDocuments().setccDocumentsValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcDocumentsValueChanged();
			}
		});
		this.form.lyr1().tabClinicalNote().setccClinicalNoteValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcClinicalNoteValueChanged();
			}
		});
		this.form.lyr1().tabPrescription().setccPrescriptionValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcPrescriptionValueChanged();
			}
		});
		this.form.lyr1().tabOutcome().setccOutcomeValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcOutcomeValueChanged();
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTNotes().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTLTtabPageTLTNotesActivated();
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTLTtabPageTLTOutcomeActivated();
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTNotes().setccTLTValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcTLTValueChanged();
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().Group1().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroup1ValueChanged();
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().btnCancelTLTOutcome().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelTLTOutcomeClick();
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().btnSaveTLTOutcome().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveTLTOutcomeClick();
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().btnEditTLTOutcome().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditTLTOutcomeClick();
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().cmbTLTOnwardReferral().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTLTOnwardReferralValueSet(value);
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().cmbOther().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbOtherValueSet(value);
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().cmbTLTDischType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTLTDischTypeValueSet(value);
			}
		});
		this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome().cmbTLTDischType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbTLTDischTypeValueChanged();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTLTOnwardReferralLookup();
		bindcmbOtherLookup();
		bindcmbTLTDischTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTLTOnwardReferralLookup();
		bindcmbOtherLookup();
		bindcmbTLTDischTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTLTOnwardReferralLookupValue();
		defaultcmbOtherLookupValue();
		defaultcmbTLTDischTypeLookupValue();
	}
	private void onlyr1tabPatientDocumentsActivated()
	{
		this.form.lyr1().showtabPatientDocuments();
		onlyr1TabChanged(this.form.lyr1().tabPatientDocuments());
	}
	private void onlyr1tabClinicalNoteActivated()
	{
		this.form.lyr1().showtabClinicalNote();
		onlyr1TabChanged(this.form.lyr1().tabClinicalNote());
	}
	private void onlyr1tabPrescriptionActivated()
	{
		this.form.lyr1().showtabPrescription();
		onlyr1TabChanged(this.form.lyr1().tabPrescription());
	}
	private void onlyr1tabOutcomeActivated()
	{
		this.form.lyr1().showtabOutcome();
		onlyr1TabChanged(this.form.lyr1().tabOutcome());
	}
	private void onlyr1tabTLTActivated()
	{
		this.form.lyr1().showtabTLT();
		onlyr1TabChanged(this.form.lyr1().tabTLT());
	}
	private void onlyr1tabFinalReportActivated()
	{
		this.form.lyr1().showtabFinalReport();
		onlyr1TabChanged(this.form.lyr1().tabFinalReport());
	}
	private void onlyrTLTtabPageTLTNotesActivated()
	{
		this.form.lyr1().tabTLT().lyrTLT().showtabPageTLTNotes();
		onlyrTLTTabChanged(this.form.lyr1().tabTLT().lyrTLT().tabPageTLTNotes());
	}
	private void onlyrTLTtabPageTLTOutcomeActivated()
	{
		this.form.lyr1().tabTLT().lyrTLT().showtabPageTLTOutcome();
		onlyrTLTTabChanged(this.form.lyr1().tabTLT().lyrTLT().tabPageTLTOutcome());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}