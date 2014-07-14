package com.Example;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;

public class AndroidPull {
	
	public List<UserBean> parse(String str) {
		final List<UserBean> ulist = new ArrayList<UserBean>();
		XmlPullParser parser = Xml.newPullParser();
		try{
			parser.setInput(new ByteArrayInputStream(str.getBytes()), "utf-8");
			int eventType = parser.getEventType();
			UserBean user=null;
			while (eventType != XmlPullParser.END_DOCUMENT ){
				String temp = null;
				switch (eventType){
				case XmlPullParser.START_TAG:
					temp=parser.getName();
					if(temp.equalsIgnoreCase("user")){
						user=new UserBean();
					}
					else if(temp.equalsIgnoreCase("name")){
						user.setName(parser.nextText());
					}
					else if(temp.equalsIgnoreCase("phone")){
						user.setPhone(parser.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					temp=parser.getName();
					if(temp.equalsIgnoreCase("user")){
						ulist.add(user);
					}
					break;
				}
				eventType = parser.next();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		return ulist;
	}
}
