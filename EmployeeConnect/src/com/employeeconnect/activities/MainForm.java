package com.employeeconnect.activities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.employeeconnect.R;
import com.employeeconnect.services.ReminderSettingService;

public class MainForm extends Activity {
	
	
	
	//private Uri fileUri;

	public static final String EXTRA_MESSAGE1 = "com.example.demoform.MESSAGE1";
	public static final String EXTRA_MESSAGE2 = "com.example.demoform.MESSAGE2";
	public static final String EXTRA_MESSAGE3 = "com.example.demoform.MESSAGE3";
	public static final String EXTRA_MESSAGE4 = "com.example.demoform.MESSAGE4";
	
	EditText editText;
	TextView textView;
	ImageView image;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_form);
		Intent intent1 = new Intent(this, ReminderSettingService.class);
		startService(intent1);
		InputStream is = getResources().openRawResource(R.raw.employee);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr,8192);
		String test = null;
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> value = new ArrayList<String>();
		Map<String,String> map = new LinkedHashMap<String, String>();
		textView = new TextView(this);
		
		try {
			while((test = br.readLine()) != null){
				String[] test1 = test.split(":");
				name.add(test1[0]);
				value.add(test1[1]);
				map.put(test1[0], test1[1]);
			}
		} catch(Exception e){
			Log.i("error" , e.getMessage());
			e.printStackTrace();
		}
		showData(map);
		
	}
	
//	public void showData(ArrayList<String> name, ArrayList<String> value) {
//		
//		LinearLayout layout = new LinearLayout(this);
//		for(int i = 0; i <name.size(); i++){
//			TextView textView = new TextView(this);
//			textView.setId(i);
//			textView.setText(name.get(i).toString() +":");
//			layout.addView(textView);
//		}
//		for(int i = 0; i <value.size(); i++){
//			EditText editView = new EditText(this);
//			
//			editView.setId(i);
//			editView.setText(value.get(i).toString());
//			layout.addView(editView);
//		}
//		layout.setOrientation(LinearLayout.VERTICAL);
//		layout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//		setContentView(layout);
//		
//	}
	
	public void showData(Map<String,String> map){		
		
		image = (ImageView) findViewById(R.id.imageView1);
		image.setImageResource(R.drawable.default_user);
		
		Set<Entry<String, String>> testMaps = map.entrySet();
		for (Entry<String, String> entry : testMaps) {
			if(entry.getKey().equalsIgnoreCase("First_Name")){
				textView = (TextView)findViewById(R.id.editFname);
				textView.setText(entry.getValue());
				
			}else if(entry.getKey().equalsIgnoreCase("Middle_Name")){
				textView = (TextView)findViewById(R.id.editMname);
				textView.setText(entry.getValue());
				
			}else if(entry.getKey().equalsIgnoreCase("Last_Name")){
				textView = (TextView)findViewById(R.id.editLname);
				textView.setText(entry.getValue());
				
			}else if(entry.getKey().equalsIgnoreCase("Emp_Code")){
				textView = (TextView)findViewById(R.id.editEmpCode);
				textView.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Phone")){
				textView = (TextView)findViewById(R.id.editPhone);
				textView.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Email")){
				textView = (TextView)findViewById(R.id.editEmail);
				textView.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("DOB")){
				textView = (TextView)findViewById(R.id.editDOB);
				textView.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Blood_Group")){
				textView = (TextView)findViewById(R.id.editBloodGroup);
				textView.setText(entry.getValue());
			}
			textView.setEnabled(false);
		}
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_form, menu);
		return true;
	}

}
