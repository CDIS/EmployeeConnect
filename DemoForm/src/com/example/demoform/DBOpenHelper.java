package com.example.demoform;

import java.util.Calendar;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "EMP_CONNECT_DB";

	// Table Names
	private static final String TABLE_EE = "EmployeeEvent";

	// Common column names
	private static final String KEY_ID = "UIDPK";
	private static final String COL_EMP_ID = "EMPLOYEE_ID";
	private static final String COL_OCCASSION = "EVENT_OCCASSION";
	private static final String COL_DATE = "EVENT_DATE";

	// Table Create Statements

	private static final String CREATE_TABLE_TODO = "CREATE TABLE " + TABLE_EE
			+ "(" + KEY_ID + " INTEGER PRIMARY KEY," + COL_EMP_ID
			+ " INTEGER ," + COL_OCCASSION + " TEXT," + COL_DATE + " DATETIME"
			+ ")";

	public DBOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// creating required tables
		Calendar calendar = Calendar.getInstance();
		db.execSQL(CREATE_TABLE_TODO);
		ContentValues values = new ContentValues();
		values.put(COL_EMP_ID, 1111);
		values.put(COL_OCCASSION, "bday");
		 calendar.add(Calendar.SECOND, 40);
		values.put(COL_DATE,calendar.getTimeInMillis());
		// insert row
		long id = db.insert(TABLE_EE, null, values);

		values.put(COL_EMP_ID, 1112);
		values.put(COL_OCCASSION, "aniversary");
		calendar.add(Calendar.SECOND, 10);
		values.put(COL_DATE, new Date().getTime());
		// insert row
		id = db.insert(TABLE_EE, null, values);

		values.put(COL_EMP_ID, 1113);
		values.put(COL_OCCASSION, "festival");
		calendar.add(Calendar.SECOND, 10);
		values.put(COL_DATE, new Date().getTime());
		// insert row
		id = db.insert(TABLE_EE, null, values);
		System.out.println(id);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EE);

		// create new tables
		onCreate(db);
	}
}