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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.patientmergemanager;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbDestIdTypeLookup();
	abstract protected void defaultcmbDestIdTypeLookupValue();
	abstract protected void bindcmbSourceIdTypeLookup();
	abstract protected void defaultcmbSourceIdTypeLookupValue();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRefreshClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRestartClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnStopClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnStartClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdMergeSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbFindClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDestIdTypeValueSet(Object value);
	abstract protected void oncmbSourceIdTypeValueSet(Object value);

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.lyrPatMerge().tabServlet().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatMergetabServletActivated();
			}
		});
		this.form.lyrPatMerge().tabRequests().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatMergetabRequestsActivated();
			}
		});
		this.form.lyrPatMerge().tabServlet().btnRefresh().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRefreshClick();
			}
		});
		this.form.lyrPatMerge().tabServlet().btnRestart().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRestartClick();
			}
		});
		this.form.lyrPatMerge().tabServlet().btnStop().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnStopClick();
			}
		});
		this.form.lyrPatMerge().tabServlet().btnStart().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnStartClick();
			}
		});
		this.form.lyrPatMerge().tabRequests().grdMerge().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdMergeSelectionChanged();
			}
		});
		this.form.lyrPatMerge().tabRequests().imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.lyrPatMerge().tabRequests().imbFind().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbFindClick();
			}
		});
		this.form.lyrPatMerge().tabRequests().cmbDestIdType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDestIdTypeValueSet(value);
			}
		});
		this.form.lyrPatMerge().tabRequests().cmbSourceIdType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSourceIdTypeValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbDestIdTypeLookup();
		bindcmbSourceIdTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbDestIdTypeLookup();
		bindcmbSourceIdTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbDestIdTypeLookupValue();
		defaultcmbSourceIdTypeLookupValue();
	}
	private void onlyrPatMergetabServletActivated()
	{
		this.form.lyrPatMerge().showtabServlet();
	}
	private void onlyrPatMergetabRequestsActivated()
	{
		this.form.lyrPatMerge().showtabRequests();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
