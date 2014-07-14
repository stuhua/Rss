package com.Example;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

public class ParseAndroid {

	public List<UserBean> parse(String str) {
		final List<UserBean> ulist = new ArrayList<UserBean>();
		final UserBean currentUser = new UserBean();
		
		
		RootElement root = new RootElement("channel");
		Element item = root.getChild("item");
		
		item.getChild("title").setEndTextElementListener(
				new EndTextElementListener() {
					public void end(String body) {
						currentUser.setName(body);
					}
				});
		item.getChild("link").setEndTextElementListener(
				new EndTextElementListener() {
					public void end(String body) {
						currentUser.setPhone(body);
					}
				});
		item.setEndElementListener(new EndElementListener() {
			public void end() {
				ulist.add(currentUser.copy());
			}
		});
		try {
			Xml.parse(new ByteArrayInputStream(str.getBytes()),
					Xml.Encoding.UTF_8, root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return ulist;
	}
}
