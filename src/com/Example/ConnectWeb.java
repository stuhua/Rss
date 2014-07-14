package com.Example;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ConnectWeb {

	public List<UserBean> getUserList(){
		List<UserBean> ulist=new ArrayList<UserBean>();
		try{
//			String url="http://192.168.1.8:8080/AndroidWeb/XMLServlet";
			String url="http://www.csdn.net/article/rss_lastnews";	
			HttpPost request = new HttpPost(url); 
			HttpResponse response = new DefaultHttpClient().execute(request); 
			if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				String str = EntityUtils.toString(response.getEntity());
				
				
//				ulist=new ParseDOM().parseByDOM(str);
				ulist=sax(str);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ulist;
	}
	
	public List<UserBean> sax(String str){
		List<UserBean> ulist=new ArrayList<UserBean>();
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			ParseSAX handler = new ParseSAX();
			parser.parse(new ByteArrayInputStream(str.getBytes()), handler);
			ulist=handler.getUsers();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ulist;
	}
}
