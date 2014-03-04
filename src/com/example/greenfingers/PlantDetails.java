package com.example.greenfingers;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PlantDetails extends Activity {
	private DatabaseHandler db;
	private String Names[],Names2[];
	
	private PlantDetails that1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plant_details);
		db = new DatabaseHandler(this);
		that1= this;
		String s= getIntent().getStringExtra("name");
		List<GardenName> garden_Names=db.getAllGardenNamesByName(s);
		  Names=new String[garden_Names.size()];
			int ii=0;
			int cancel=0;
			for (GardenName cn : garden_Names) {
				String temp=cn.getPlant();
				if(temp!=null)
				{
	            Names[ii]=temp;
				}
				else
					cancel++;
//	            this.ids[i]=cn.getID()+"";
	            		ii++;
	    }
			Names2=new String[garden_Names.size()-cancel];
			int iii=0;
			for( ii=0;ii<garden_Names.size();ii++)
			{
				if(Names[ii]!=null)
				{
					Names2[iii]=Names[ii];
							iii++;
				}
				
			}
			
			ArrayAdapter<String> content=new ArrayAdapter <String> (this, R.layout.garden_list, Names2);
			ListView l=(ListView)findViewById(R.id.listView2);
			l.setAdapter(content);
			l.setVisibility(View.VISIBLE);
			l.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
//					 TODO Auto-generated method stub
					//Toast.makeText(getBaseContext(), ""+Names[arg2], Toast.LENGTH_SHORT).show();
				
				Intent nextpage= new Intent(that1,Notifications.class);
				nextpage.putExtra("plant", Names2[arg2]);
				startActivity(nextpage);
				}
				
			});			 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plant_details, menu);
		return true;
		
		
	}

}
