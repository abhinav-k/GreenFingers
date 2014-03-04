package com.example.greenfingers;

import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends Activity {
	private DatabaseHandler db;
	private MainScreen temp;
	
//	private View Temp;
	private String Names[];
	private String gardenType[]={"Fruits & Veg","Ornamental","flowers","water"};
	private String FV[]={"Potato","Tomato","Musk Melon","Papaya"};
	private String Ornamental[]={"Croton","Roses","Tulips","Aloevera"};
	private String flowers[]={"Roses","Tulip","Marigold","Jasmine"};
	private String water[]={"Red Lily","Lotus","White Lily"};
//	private String ids[];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		ActionBar act=getActionBar();
		act.setTitle("Choose your Garden");
		act.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#005E20")));
		temp=this;
		db = new DatabaseHandler(this);
//		  db.deldb();
		 System.out.println("Created DataBase"); 
		 System.out.println("In onStart"); 
		    
		int count=db.getGardenNameCount();
		System.out.println("cont"+count);
		if(count==0)
		{
			ImageButton b=(ImageButton) findViewById(R.id.ImageButton2);
			b.setVisibility(View.VISIBLE);
			ImageButton c=(ImageButton) findViewById(R.id.ImageButton1);
			c.setVisibility(View.GONE);
			ListView l=(ListView)findViewById(R.id.listView1);
			l.setVisibility(View.GONE);
			ImageButton d=(ImageButton) findViewById(R.id.ImageButton3);
			d.setVisibility(View.GONE);
			ImageButton e=(ImageButton) findViewById(R.id.ImageButton4);
			e.setVisibility(View.GONE);
			TextView f=(TextView)this.findViewById(R.id.textView1);
			f.setVisibility(View.GONE);
			EditText g=(EditText)this.findViewById(R.id.editText1);
			g.setVisibility(View.GONE);
			TextView h=(TextView)this.findViewById(R.id.textView2);
			TextView i=(TextView)this.findViewById(R.id.textView3);
			Spinner j=(Spinner)this.findViewById(R.id.spinner1);
			Spinner k=(Spinner)this.findViewById(R.id.spinner2);
			h.setVisibility(View.GONE);
			i.setVisibility(View.GONE);
			j.setVisibility(View.GONE);
			k.setVisibility(View.GONE);
			this.addGarden12345();
	
		}
		else
		{
			ImageButton b=(ImageButton) findViewById(R.id.ImageButton2);
			b.setVisibility(View.GONE);
			
			ImageButton c=(ImageButton) findViewById(R.id.ImageButton1);
			c.setVisibility(View.VISIBLE);
			ImageButton d=(ImageButton) findViewById(R.id.ImageButton3);
			d.setVisibility(View.GONE);
			ImageButton e=(ImageButton) findViewById(R.id.ImageButton4);
			e.setVisibility(View.GONE);
			TextView f=(TextView)this.findViewById(R.id.textView1);
			f.setVisibility(View.GONE);
			EditText g=(EditText)this.findViewById(R.id.editText1);
			g.setVisibility(View.GONE);
			TextView h=(TextView)this.findViewById(R.id.textView2);
			TextView i=(TextView)this.findViewById(R.id.textView3);
			Spinner j=(Spinner)this.findViewById(R.id.spinner1);
			Spinner k=(Spinner)this.findViewById(R.id.spinner2);
			h.setVisibility(View.GONE);
			i.setVisibility(View.GONE);
			j.setVisibility(View.GONE);
			k.setVisibility(View.GONE);
			
			
			List<GardenName> garden_Names=db.getAllGardenNames();
			 Names=new String[garden_Names.size()];
			int ii=0;
			for (GardenName cn : garden_Names) {
	            Names[ii]=cn.getName();
//	            this.ids[i]=cn.getID()+"";
	            		ii++;
	    }
			ArrayAdapter<String> content=new ArrayAdapter <String> (this, R.layout.garden_list, Names);
			ListView l=(ListView)findViewById(R.id.listView1);
			l.setAdapter(content);
			l.setVisibility(View.VISIBLE);
			l.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Intent next1=new Intent(temp,PlantDetails.class);
					next1.putExtra("name", Names[arg2]);
					startActivity(next1);
					// TODO Auto-generated method stub
//					Toast.makeText(getBaseContext(), ""+Names[arg2], Toast.LENGTH_SHORT).show();
				}
				
			});			 
		}
	}
	public void addGarden1234(View v)
	{
//		System.out.println("Done");
		System.out.println(v.getId());
		ImageButton b=(ImageButton) findViewById(R.id.ImageButton2);
		b.setVisibility(View.GONE);
		ImageButton c=(ImageButton) findViewById(R.id.ImageButton1);
		c.setVisibility(View.GONE);
		ListView l=(ListView)findViewById(R.id.listView1);
		l.setVisibility(View.GONE);
		ImageButton d=(ImageButton) findViewById(R.id.ImageButton3);
		d.setVisibility(View.VISIBLE);
		ImageButton e=(ImageButton) findViewById(R.id.ImageButton4);
		e.setVisibility(View.VISIBLE);
		TextView f=(TextView)this.findViewById(R.id.textView1);
		f.setVisibility(View.VISIBLE);
		EditText g=(EditText)this.findViewById(R.id.editText1);
		g.setVisibility(View.VISIBLE);
		TextView h=(TextView)this.findViewById(R.id.textView2);
		TextView i=(TextView)this.findViewById(R.id.textView3);
		Spinner j=(Spinner)this.findViewById(R.id.spinner1);
		Spinner k=(Spinner)this.findViewById(R.id.spinner2);
		h.setVisibility(View.VISIBLE);
		
		i.setVisibility(View.VISIBLE);
		
		j.setVisibility(View.VISIBLE);
		
		k.setVisibility(View.VISIBLE);
			temp=this;	
		ArrayAdapter <String>dataAdapter=new ArrayAdapter <String>(this,R.layout.simple_spinner_dropdown_item,gardenType);
		j.setAdapter(dataAdapter);
		
	j.setOnItemSelectedListener(new OnItemSelectedListener(){
		public void onItemSelected(AdapterView<?> arg0,View arg1,int arg2,long arg3)
		{
			int index=arg2;
			ArrayAdapter <String>dataAdapter0;
			switch (index)
			{
			case 0:
				dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,FV);
				break;

			case 1:
				dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,Ornamental);
				break;

			case 2:
				dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,flowers);
				break;

			case 3:
				dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,water);
				break;
				default:
					dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,FV);
						
			}
			
			Spinner k=(Spinner)temp.findViewById(R.id.spinner2);
			
			k.setAdapter(dataAdapter0);
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	});
	}
	
	
	public void addGarden12345()
	{
//		System.out.println("Done");
		ImageButton b=(ImageButton) findViewById(R.id.ImageButton2);
		b.setVisibility(View.GONE);
		ImageButton c=(ImageButton) findViewById(R.id.ImageButton1);
		c.setVisibility(View.GONE);
		ListView l=(ListView)findViewById(R.id.listView1);
		l.setVisibility(View.GONE);
		ImageButton d=(ImageButton) findViewById(R.id.ImageButton3);
		d.setVisibility(View.VISIBLE);
		ImageButton e=(ImageButton) findViewById(R.id.ImageButton4);
		e.setVisibility(View.VISIBLE);
		TextView f=(TextView)this.findViewById(R.id.textView1);
		f.setVisibility(View.VISIBLE);
		EditText g=(EditText)this.findViewById(R.id.editText1);
		g.setVisibility(View.VISIBLE);
		TextView h=(TextView)this.findViewById(R.id.textView2);
		TextView i=(TextView)this.findViewById(R.id.textView3);
		Spinner j=(Spinner)this.findViewById(R.id.spinner1);
		Spinner k=(Spinner)this.findViewById(R.id.spinner2);
		h.setVisibility(View.VISIBLE);
		
		i.setVisibility(View.VISIBLE);
		
		j.setVisibility(View.VISIBLE);
		
		k.setVisibility(View.VISIBLE);
			temp=this;	
		ArrayAdapter <String>dataAdapter=new ArrayAdapter <String>(this,R.layout.simple_spinner_dropdown_item,gardenType);
		j.setAdapter(dataAdapter);
		
	j.setOnItemSelectedListener(new OnItemSelectedListener(){
		public void onItemSelected(AdapterView<?> arg0,View arg1,int arg2,long arg3)
		{
			int index=arg2;
			ArrayAdapter <String>dataAdapter0;
			switch (index)
			{
			case 0:
				dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,FV);
				break;

			case 1:
				dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,Ornamental);
				break;

			case 2:
				dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,flowers);
				break;

			case 3:
				dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,water);
				break;
				default:
					dataAdapter0=new ArrayAdapter <String>(temp,R.layout.spinner2,FV);
						
			}
			
			Spinner k=(Spinner)temp.findViewById(R.id.spinner2);
			
			k.setAdapter(dataAdapter0);
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	});
	}
	
	
	public void confirmGarden(View v)
	{
		EditText g=(EditText)this.findViewById(R.id.editText1);
		String text=g.getText().toString();
		Spinner sp=(Spinner)this.findViewById(R.id.spinner1);
//		GardenName temp=new GardenName(text);
		String  pTpe=sp.getSelectedItem().toString();
		Spinner sp1=(Spinner)this.findViewById(R.id.spinner2);
		String  pTpe1=sp1.getSelectedItem().toString();
		GardenName temp=new GardenName(text,pTpe,pTpe1);
		
		db.addGarden(temp);
		finish();
		Intent i=new Intent(this,MainScreen.class);
		this.startActivity(i);
	}
	public void cancelBack(View v)
	{
//		System.out.println("Done");
		System.out.println(v.getId());
		ImageButton b=(ImageButton) findViewById(R.id.ImageButton2);
		b.setVisibility(View.GONE);
		ImageButton c=(ImageButton) findViewById(R.id.ImageButton1);
		c.setVisibility(View.GONE);
		ListView l=(ListView)findViewById(R.id.listView1);
		l.setVisibility(View.GONE);
		ImageButton d=(ImageButton) findViewById(R.id.ImageButton3);
		d.setVisibility(View.GONE);
		ImageButton e=(ImageButton) findViewById(R.id.ImageButton4);
		e.setVisibility(View.GONE);
		TextView f=(TextView)this.findViewById(R.id.textView1);
		f.setVisibility(View.GONE);
		EditText g=(EditText)this.findViewById(R.id.editText1);
		g.setVisibility(View.GONE);
		g.setText("");
		int count=db.getGardenNameCount();
		System.out.println("cont"+count);
		if(count==0)
		{
//			ImageButton b=(ImageButton) findViewById(R.id.ImageButton2);
			b.setVisibility(View.VISIBLE);
//			ImageButton c=(ImageButton) findViewById(R.id.ImageButton1);
			c.setVisibility(View.GONE);
			 l=(ListView)findViewById(R.id.listView1);
			l.setVisibility(View.GONE);
//			ImageButton d=(ImageButton) findViewById(R.id.ImageButton3);
			d.setVisibility(View.GONE);
//			ImageButton e=(ImageButton) findViewById(R.id.ImageButton4);
			e.setVisibility(View.GONE);
//			TextView f=(TextView)this.findViewById(R.id.textView1);
			f.setVisibility(View.GONE);
//			EditText g=(EditText)this.findViewById(R.id.editText1);
			g.setVisibility(View.GONE);
			TextView h=(TextView)this.findViewById(R.id.textView2);
			TextView i=(TextView)this.findViewById(R.id.textView3);
			Spinner j=(Spinner)this.findViewById(R.id.spinner1);
			Spinner k=(Spinner)this.findViewById(R.id.spinner2);
			h.setVisibility(View.GONE);
			i.setVisibility(View.GONE);
			j.setVisibility(View.GONE);
			k.setVisibility(View.GONE);
			Intent next;
			next=new Intent(this,GettingStarted.class);
			finish();
			startActivity(next);
		}
		else
		{
//			ImageButton b=(ImageButton) findViewById(R.id.ImageButton2);
			b.setVisibility(View.GONE);
			
//			ImageButton c=(ImageButton) findViewById(R.id.ImageButton1);
			c.setVisibility(View.VISIBLE);
//			ImageButton d=(ImageButton) findViewById(R.id.ImageButton3);
			d.setVisibility(View.GONE);
//			ImageButton e=(ImageButton) findViewById(R.id.ImageButton4);
			e.setVisibility(View.GONE);
//			TextView f=(TextView)this.findViewById(R.id.textView1);
			f.setVisibility(View.GONE);
//			EditText g=(EditText)this.findViewById(R.id.editText1);
			g.setVisibility(View.GONE);
			TextView h=(TextView)this.findViewById(R.id.textView2);
			TextView i=(TextView)this.findViewById(R.id.textView3);
			Spinner j=(Spinner)this.findViewById(R.id.spinner1);
			Spinner k=(Spinner)this.findViewById(R.id.spinner2);
			h.setVisibility(View.GONE);
			i.setVisibility(View.GONE);
			j.setVisibility(View.GONE);
			k.setVisibility(View.GONE);
			
			
			List<GardenName> garden_Names=db.getAllGardenNames();
			 Names=new String[garden_Names.size()];
			int ii=0;
			for (GardenName cn : garden_Names) {
	            Names[ii]=cn.getName();
//	            this.ids[i]=cn.getID()+"";
	            		ii++;
	    }
			ArrayAdapter<String> content=new ArrayAdapter <String> (this, R.layout.garden_list, Names);
			 l=(ListView)findViewById(R.id.listView1);
			l.setAdapter(content);
			l.setVisibility(View.VISIBLE);
			l.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Intent next1=new Intent(temp,PlantDetails.class);
					next1.putExtra("name", Names[arg2]);
					startActivity(next1);
					// TODO Auto-generated method stub
//					Toast.makeText(getBaseContext(), ""+Names[arg2], Toast.LENGTH_SHORT).show();
				}
				
			});			 
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_screen, menu);
		return true;
	}

}
