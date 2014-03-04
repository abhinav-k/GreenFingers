package com.example.greenfingers;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Notifications extends Activity implements CompoundButton.OnCheckedChangeListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifications);
		ActionBar acti=getActionBar();
		acti.setTitle("Notification Manager");

	    Switch s = (Switch) findViewById(R.id.switch1);
	    if (s != null) {
	        s.setOnCheckedChangeListener(this);
	    }
	}


	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//	 if(this.get=="switch1"){
//		 Toast.makeText(this, "Bluetooth is " + (isChecked ? "on" : "off"),
//		           Toast.LENGTH_SHORT).show();
		 if(isChecked)
		 {
			 String s= getIntent().getStringExtra("plant");
			 if(s!=null)
			 {
				 noti water=new noti(1000,"GreenFingers:Remainder","Its time to water "+s+" plant",this);
			 }
				
		 }
//	 }
//	           Toast.LENGTH_SHORT).show();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	
		getMenuInflater().inflate(R.menu.notifications, menu);
		return true;
	}

}
