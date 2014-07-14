package com.Example;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseSAX extends DefaultHandler{
	private List<UserBean> ulist;
	private UserBean currentUser;
	private String temp;

	public List<UserBean> getUsers() {
		return this.ulist;
	}

	public void startDocument() throws SAXException {
		ulist = new ArrayList<UserBean>();
	}

	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		
//		if (name.equalsIgnoreCase("user")) {
			if (name.equalsIgnoreCase("item")) {
				
				
			this.currentUser = new UserBean();
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		temp=new String(ch,start,length);
	}

	public void endElement(String uri, String localName, String name)
			throws SAXException {
		if (this.currentUser != null) {
			
			
//			if (name.equalsIgnoreCase("name")) {
				if (name.equalsIgnoreCase("title")) {
					
					
				currentUser.setName(temp);
				
//			} else if (name.equalsIgnoreCase("phone")) {
			} else if (name.equalsIgnoreCase("link")) {
				
				
				currentUser.setPhone(temp);
				
//			} else if (name.equalsIgnoreCase("user")) {
			} else if (name.equalsIgnoreCase("item")) {
				
				ulist.add(currentUser);
			}
		}
	}
}
