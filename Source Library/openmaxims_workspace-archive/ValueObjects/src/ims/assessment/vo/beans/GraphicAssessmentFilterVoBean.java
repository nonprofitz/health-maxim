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

package ims.assessment.vo.beans;

public class GraphicAssessmentFilterVoBean extends ims.vo.ValueObjectBean
{
	public GraphicAssessmentFilterVoBean()
	{
	}
	public GraphicAssessmentFilterVoBean(ims.assessment.vo.GraphicAssessmentFilterVo vo)
	{
		this.name = vo.getName();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.beginswith = vo.getBeginsWith();
		this.contains = vo.getContains();
		this.exacttext = vo.getExactText();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.GraphicAssessmentFilterVo vo)
	{
		this.name = vo.getName();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.beginswith = vo.getBeginsWith();
		this.contains = vo.getContains();
		this.exacttext = vo.getExactText();
	}

	public ims.assessment.vo.GraphicAssessmentFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.GraphicAssessmentFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.GraphicAssessmentFilterVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.GraphicAssessmentFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.GraphicAssessmentFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public Boolean getBeginsWith()
	{
		return this.beginswith;
	}
	public void setBeginsWith(Boolean value)
	{
		this.beginswith = value;
	}
	public Boolean getContains()
	{
		return this.contains;
	}
	public void setContains(Boolean value)
	{
		this.contains = value;
	}
	public Boolean getExactText()
	{
		return this.exacttext;
	}
	public void setExactText(Boolean value)
	{
		this.exacttext = value;
	}

	private String name;
	private ims.vo.LookupInstanceBean status;
	private ims.vo.LookupInstanceBean type;
	private Boolean beginswith;
	private Boolean contains;
	private Boolean exacttext;
}
