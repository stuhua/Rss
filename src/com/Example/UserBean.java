package com.Example;

public class UserBean {
	private String name;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserBean copy(){
		UserBean copy = new UserBean();
		copy.name = name;
		copy.phone = phone;
		return copy;
	}
}
