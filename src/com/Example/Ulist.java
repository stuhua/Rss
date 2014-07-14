package com.Example;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;


public class Ulist extends ListActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		getUlist();
	}
	
	private void getUlist(){
		List<UserBean> ulist=new ConnectWeb().getUserList();
		List<String> titles = new ArrayList<String>(ulist.size());
		for(int i=0;i<ulist.size();i+=1){
			titles.add(ulist.get(i).getName()+"  "+ulist.get(i).getPhone());
		}
		ArrayAdapter<String> adapter = 
				
//    		new ArrayAdapter<String>(this, R.layout.row,titles);
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,titles);
		
    	this.setListAdapter(adapter);

	}
}
