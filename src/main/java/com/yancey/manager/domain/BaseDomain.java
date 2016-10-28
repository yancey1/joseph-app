package com.yancey.manager.domain;


import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author wenqiang.xu
 * 
 */
public class BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4263642933589585350L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
