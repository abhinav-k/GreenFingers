package com.example.greenfingers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class GettingStarted extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_getting_started);
		
	}
	public void getStarted(View v)
	{
		Intent some;
		some=new Intent(this,MainScreen.class);
//		finish();
		startActivity(some);
	}
	public void howIt(View v)
	{
		Intent some;
		some=new Intent(this,Description.class);
//		finish();
		startActivity(some);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.getting_started, menu);
		return true;
	}

}
