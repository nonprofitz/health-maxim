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

package ims.RefMan.domain;

// Generated from form domain impl
public interface PatientSpecialtyAssessments extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.RefMan.vo.ConsultationAssessmentsLiteVo getConsultationAssessments(ims.RefMan.vo.CatsReferralRefVo refVoCatsReferral);

	// Generated from form domain interface definition
	public ims.assessment.vo.PatientAssessmentVo getPatientAssessment(ims.assessment.instantiation.vo.PatientAssessmentRefVo patAssesRef);

	// Generated from form domain interface definition
	public ims.assessment.vo.PatientAssessmentVo save(ims.assessment.vo.PatientAssessmentVo patientAssessment, ims.RefMan.vo.ConsultationAssessmentsLiteVo consultationAssessment) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.assessment.vo.PatientAssessmentVo save(ims.assessment.vo.PatientAssessmentVo patientAssessment) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.EpisodeofCareShortVo getEpisodeOfCareBuId(Integer eocId);

	// Generated from form domain interface definition
	/**
	* listAssessments
	*/
	public ims.assessment.vo.UserAssessmentLiteVoCollection listAssessments(ims.vo.LookupInstVo specialty);

	// Generated from form domain interface definition
	public ims.assessment.vo.UserAssessmentVo getUserAssessmentVo(Integer userAssessId);

	// Generated from form domain interface definition
	/**
	* getActiveGraphicAssessment
	*/
	public ims.assessment.vo.GraphicAssessmentVo getActiveGraphicAssessment(ims.assessment.configuration.vo.GraphicAssessmentRefVo voRef);

	// Generated from form domain interface definition
	/**
	* listAssessments
	*/
	public ims.assessment.vo.GraphicAssessmentLiteVoCollection listGraphicAssessments(ims.vo.LookupInstVo specialty);

	// Generated from form domain interface definition
	/**
	* getActiveGraphicAssessment
	*/
	public ims.assessment.vo.GraphicAssessmentVo getActiveGraphicAssessment(ims.core.vo.lookups.UserDefinedAssessmentType type);

	// Generated from form domain interface definition
	public Boolean savePatientDocument(ims.core.vo.PatientDocumentVo patientDocument, ims.assessment.vo.PatientAssessmentVo patientAssessment) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public Boolean isSaved(ims.assessment.instantiation.vo.PatientAssessmentRefVo patientAssessment);

	// Generated from form domain interface definition
	public ims.core.vo.TemplateBoLiteVo getTemplate(ims.core.admin.vo.TemplateBoRefVo template);

	// Generated from form domain interface definition
	public String[] getReportAndTemplate(ims.core.admin.vo.TemplateBoRefVo template);

	// Generated from form domain interface definition
	public ims.assessment.vo.UserAssessmentWithServiceCollVo getUserAssessment(ims.assessment.configuration.vo.UserAssessmentRefVo assessRef);

	// Generated from form domain interface definition
	public ims.assessment.vo.PatientAssessmentVo getLatestVersionAssessment(ims.assessment.instantiation.vo.PatientAssessmentRefVo assessment, ims.RefMan.vo.CatsReferralRefVo referral);
}
