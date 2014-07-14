package com.Example;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseDOM {
	public List<UserBean> parseByDOM(String str){
		List<UserBean> ulist=new ArrayList<UserBean>();
		try{
			DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder=domfac.newDocumentBuilder();
			InputStream is=new ByteArrayInputStream(str.getBytes());
			Document doc=dombuilder.parse(is);
			Element root=doc.getDocumentElement();
			NodeList users=root.getChildNodes();
			for(int i=0;i<users.getLength();i+=1){
				Node u=users.item(i);
				NodeList p=u.getChildNodes();
				if(p.getLength()>0){
					UserBean ub=new UserBean();
					for(int j=0;j<p.getLength();j+=1){
						Node atribue=p.item(j);
						
						
//						if(atribue.getNodeName().equals("name")){
							if(atribue.getNodeName().equals("title")){
								
								
							ub.setName(atribue.getFirstChild().getNodeValue());
						}
							
							
//						else if(atribue.getNodeName().equals("phone")){
							else if(atribue.getNodeName().equals("link")){
								
								
							ub.setPhone(atribue.getFirstChild().getNodeValue());
						}
					}
					ulist.add(ub);
				}	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ulist;
	}
}
