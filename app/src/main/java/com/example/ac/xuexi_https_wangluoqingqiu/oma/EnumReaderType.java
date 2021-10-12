package com.example.ac.xuexi_https_wangluoqingqiu.oma;

public enum EnumReaderType {
	/**
	 * SE形式：SIM卡、eSE、SD
	 */
	READER_TYPE_SIM("SIM"), READER_TYPE_ESE("eSE"), READER_TYPE_SD("SD");

	private String value;

	EnumReaderType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
