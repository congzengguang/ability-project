package com.ability.cong.plugin;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.ability.cong.util.AESUtil;

/**
 *
 * @author congzengguang
 *
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] propertyNames = {
			"master.jdbc.username","master.jdbc.password"
	};

	/**
	 *	解密指定的字段
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				return AESUtil.AESDecode(propertyValue);
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
