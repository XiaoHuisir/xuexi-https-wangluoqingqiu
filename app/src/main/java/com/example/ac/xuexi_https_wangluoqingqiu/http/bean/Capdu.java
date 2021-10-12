package com.example.ac.xuexi_https_wangluoqingqiu.http.bean;
/**
 * Created by zhangfuxiao on 2017/9/5.
 */
public class Capdu {
	/**
	 * 指令索引号
	 */
	private int index;
	/**
	 * 指令数据
	 */
	private String capdu;
	/**
	 * 期望状态字数组
	 */
	private String sw;

	public Capdu(String capdu) {
		this.capdu = capdu;
	}

	public Capdu(int index, String capdu, String expSw) {
		this.index = index;
		this.capdu = capdu;
		this.sw =expSw;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getCpadu() {
		return capdu;
	}

	public void setCpadu(String cpadu) {
		this.capdu = cpadu;
	}

	public String getSw() {
		return sw;
	}

	public void setSw(String sw) {
		this.sw = sw;
	}

	@Override
	public String toString() {
		return "Capdu{" +
				"index=" + index +
				", capdu='" + capdu + '\'' +
				", sw='" + sw + '\'' +
				'}';
	}
}
