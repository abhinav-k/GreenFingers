package com.example.greenfingers;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;

 
public class MainActivity extends Activity implements Runnable {
private Thread T;
private DatabaseHandler db1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar Bar1;
		Bar1=this.getActionBar();
		Bar1.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#005E20")));
		Bar1.hide();
//		noti n=new noti(100,"GreenFingers","Welcome to Green Fingers",this);
		T=new Thread(this,"Demo");
		T.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
		DatabaseHandler db1 = new DatabaseHandler(this);
//		  db.deldb();
		 System.out.println("Created DataBase"); 
		 System.out.println("In onStart"); 
		    
		int count=db1.getGardenNameCount();
		db1.close();
		Intent next;
		if(count==0)
		 next=new Intent(this,GettingStarted.class);
		else
		 next=new Intent(this,MainScreen.class);
			
		startActivity(next);
	}
	

}
