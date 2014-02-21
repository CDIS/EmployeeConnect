package com.employeeconnect.services;

import com.employeeconnect.receivers.AlarmReceiver;
import com.employeeconnect.systemhelpers.DBOpenHelper;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ReminderSettingService extends IntentService {
	private static final int REQUEST_CODE = 192837;

	public ReminderSettingService() {
		super("ReminderSettingService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		// get a Calendar object with current time
		// Calendar cal = Calendar.getInstance();
		// add 5 minutes to the calendar object
		// cal.add(Calendar.SECOND, 10);

		// Intent intent1 = new Intent(this, AlarmReceiver.class);
		// intent.putExtra("alarm_message", "paida ho gaye hazraat!!");
		// In reality, you would want to have a static variable for the request
		// code instead of 192837
		// PendingIntent sender = PendingIntent.getBroadcast(this, 192837,
		// intent1, PendingIntent.FLAG_UPDATE_CURRENT);

		// Get the AlarmManager service
		/*
		 * AlarmManager alarmManager = (AlarmManager)
		 * getSystemService(Context.ALARM_SERVICE); alarmManager
		 * .set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);
		 */

		DBOpenHelper dictionaryOpenHelper = new DBOpenHelper(
				this);
		SQLiteDatabase db = dictionaryOpenHelper.getReadableDatabase();
		String selectQuery = "select * from EmployeeEvent";

		Cursor c = db.rawQuery(selectQuery, null);
		Intent eventIntent = null;
		PendingIntent sender = null;
		if (c != null) {
			AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
			while (c.moveToNext()) {
				Log.i(ReminderSettingService.class.getName(),
						"Event read" + c.getLong(1) + c.getString(2)
								+ c.getLong(3));
				eventIntent = new Intent(this, AlarmReceiver.class);
				eventIntent.putExtra("empId", c.getLong(1));
				eventIntent.putExtra("occassion", c.getString(2));
				sender = PendingIntent.getBroadcast(this, REQUEST_CODE, eventIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
				alarmManager.set(AlarmManager.RTC_WAKEUP, c.getLong(3), sender);
			}
		}
	}
}
