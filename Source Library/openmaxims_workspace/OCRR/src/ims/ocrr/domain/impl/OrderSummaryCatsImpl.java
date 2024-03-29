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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.71 build 3917.16721)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.ocrr.domain.impl;

import ims.RefMan.domain.objects.OrderInvAppt;
import ims.core.vo.PatientShort;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection;
import ims.ocrr.vo.lookups.InvestigationStatusChangeReason;
import ims.scheduling.domain.OCSExternalEvents;
import ims.scheduling.domain.impl.OCSExternalEventsImpl;
import ims.scheduling.vo.Booking_AppointmentRefVo;

import java.util.Iterator;
import java.util.List;


public class OrderSummaryCatsImpl extends OrderSummaryImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* cancelOrderInvestigations and generateOrderCanceEvent where applicable
	*/
	@Override
	public void cancelOrderInvestigations(PatientShort patient, OrderInvestigationRefVoCollection collOrderInvestigation, InvestigationStatusChangeReason cancelReason, String cancelReasonComment) throws StaleObjectException, ForeignKeyViolationException
	{
		super.cancelOrderInvestigations(patient, collOrderInvestigation, cancelReason, cancelReasonComment);
		
		//send the message where relevant
		String hql = "select ordInvAppt from OrderInvAppt as ordInvAppt where ordInvAppt.orderInvestigation.id in (" + getIdString(collOrderInvestigation) + ")";
		List<?> doOrdInvAppts = getDomainFactory().find(hql);

		if(doOrdInvAppts != null && doOrdInvAppts.size() > 0)
		{
			Iterator<?> it = doOrdInvAppts.iterator();
			while(it.hasNext())
			{
				OrderInvAppt doOrderInvAppt = (OrderInvAppt) it.next();

				OCSExternalEvents impl = (OCSExternalEvents) getDomainImpl(OCSExternalEventsImpl.class);
				impl.generateOrderCancelEvent(new Booking_AppointmentRefVo(doOrderInvAppt.getAppointment().getId(), doOrderInvAppt.getAppointment().getVersion()), new OrderInvestigationRefVo(doOrderInvAppt.getOrderInvestigation().getId(), doOrderInvAppt.getOrderInvestigation().getVersion()));	
			}
		}
	}	
}
