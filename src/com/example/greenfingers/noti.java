package com.example.greenfingers;

import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class noti  {
	private static int mId;
	private String MainNoti;
	private String ContentNoti; 
	public  noti that;
	public long delay;
	public Activity act;
	//public static int mId;
		public noti(long delay,String Title,String Message,Activity act) {
			this.act=act;
			this.MainNoti=Title;
			this.ContentNoti=Message;
			this.delay=delay;
			that=this;
			timedNotification(delay,this.MainNoti,this.ContentNoti);
			
//			createNotification();
			}
		public void timedNotification(long Time,String MainNoti,String ContentNoti)
		{
			that=this;
			this.MainNoti=MainNoti;
	    	this.ContentNoti=ContentNoti;
	        
			Timer timer = new Timer(true);
			timer.schedule(new TimerTask() {
			    @Override
			    public void run() {
			    	// Notification Title and Message
			    	createNotification( that.MainNoti, that.ContentNoti);
			    }
			}, Time);
		}
		public void  createNotification(String MainNoti,String ContentNoti)
		{
			NotificationCompat.Builder mBuilder =
			        new NotificationCompat.Builder(act)
			        .setSmallIcon(R.drawable.ic_launcher)
			        .setContentTitle(MainNoti)
			        .setContentText(ContentNoti);
			Intent resultIntent = new Intent(act, MainActivity.class);
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(act);
			// Adds the back stack for the Intent (but not the Intent itself)
			stackBuilder.addParentStack( MainActivity.class);
			// Adds the Intent that starts the Activity to the top of the stack
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent =
			        stackBuilder.getPendingIntent(
			            0,
			            PendingIntent.FLAG_UPDATE_CURRENT
			        );
			mBuilder.setContentIntent(resultPendingIntent);
			NotificationManager mNotificationManager =
			    (NotificationManager) act.getSystemService(Context.NOTIFICATION_SERVICE);
			// mId allows you to update the notification later on.
			mNotificationManager.notify(mId, mBuilder.build());

		}

}
