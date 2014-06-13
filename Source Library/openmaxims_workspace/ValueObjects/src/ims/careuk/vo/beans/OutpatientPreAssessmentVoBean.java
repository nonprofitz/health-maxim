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

package ims.careuk.vo.beans;

public class OutpatientPreAssessmentVoBean extends ims.vo.ValueObjectBean
{
	public OutpatientPreAssessmentVoBean()
	{
	}
	public OutpatientPreAssessmentVoBean(ims.careuk.vo.OutpatientPreAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.suitableforsurgeryassessment = vo.getSuitableForSurgeryAssessment() == null ? null : new ims.vo.RefVoBean(vo.getSuitableForSurgeryAssessment().getBoId(), vo.getSuitableForSurgeryAssessment().getBoVersion());
		this.fitforsurgeryassesment = vo.getFitForSurgeryAssesment() == null ? null : new ims.vo.RefVoBean(vo.getFitForSurgeryAssesment().getBoId(), vo.getFitForSurgeryAssesment().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.OutpatientPreAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.suitableforsurgeryassessment = vo.getSuitableForSurgeryAssessment() == null ? null : new ims.vo.RefVoBean(vo.getSuitableForSurgeryAssessment().getBoId(), vo.getSuitableForSurgeryAssessment().getBoVersion());
		this.fitforsurgeryassesment = vo.getFitForSurgeryAssesment() == null ? null : new ims.vo.RefVoBean(vo.getFitForSurgeryAssesment().getBoId(), vo.getFitForSurgeryAssesment().getBoVersion());
	}

	public ims.careuk.vo.OutpatientPreAssessmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.OutpatientPreAssessmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.OutpatientPreAssessmentVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.OutpatientPreAssessmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.OutpatientPreAssessmentVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getSuitableForSurgeryAssessment()
	{
		return this.suitableforsurgeryassessment;
	}
	public void setSuitableForSurgeryAssessment(ims.vo.RefVoBean value)
	{
		this.suitableforsurgeryassessment = value;
	}
	public ims.vo.RefVoBean getFitForSurgeryAssesment()
	{
		return this.fitforsurgeryassesment;
	}
	public void setFitForSurgeryAssesment(ims.vo.RefVoBean value)
	{
		this.fitforsurgeryassesment = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean suitableforsurgeryassessment;
	private ims.vo.RefVoBean fitforsurgeryassesment;
}