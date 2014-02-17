package com.example.employeeconnect;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainForm extends Activity {
	
	
	
	//private Uri fileUri;

	public static final String EXTRA_MESSAGE1 = "com.example.demoform.MESSAGE1";
	public static final String EXTRA_MESSAGE2 = "com.example.demoform.MESSAGE2";
	public static final String EXTRA_MESSAGE3 = "com.example.demoform.MESSAGE3";
	public static final String EXTRA_MESSAGE4 = "com.example.demoform.MESSAGE4";
	
	EditText editText;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_form);
		
		InputStream is = getResources().openRawResource(R.raw.employee);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr,8192);
		String test = null;
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> value = new ArrayList<String>();
		Map<String,String> map = new LinkedHashMap<String, String>();
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
	
	public void showData(ArrayList<String> name, ArrayList<String> value) {
		
		LinearLayout layout = new LinearLayout(this);
		for(int i = 0; i <name.size(); i++){
			TextView textView = new TextView(this);
			textView.setId(i);
			textView.setText(name.get(i).toString() +":");
			layout.addView(textView);
		}
		for(int i = 0; i <value.size(); i++){
			EditText editView = new EditText(this);
			editView.setId(i);
			editView.setText(value.get(i).toString());
			layout.addView(editView);
		}
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		setContentView(layout);
		
	}
	
	public void showData(Map<String,String> map){
		
		
		Set<Entry<String, String>> testMaps = map.entrySet();
		for (Entry<String, String> entry : testMaps) {
			if(entry.getKey().equalsIgnoreCase("First_Name")){
				editText = (EditText)findViewById(R.id.editFname);
				editText.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Middle_Name")){
				editText = (EditText)findViewById(R.id.editMname);
				editText.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Last_Name")){
				editText = (EditText)findViewById(R.id.editLname);
				editText.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Emp_Code")){
				editText = (EditText)findViewById(R.id.editEmpCode);
				editText.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Phone")){
				editText = (EditText)findViewById(R.id.editPhone);
				editText.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Email")){
				editText = (EditText)findViewById(R.id.editEmail);
				editText.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("DOB")){
				editText = (EditText)findViewById(R.id.editDOB);
				editText.setText(entry.getValue());
			}else if(entry.getKey().equalsIgnoreCase("Blood_Group")){
				editText = (EditText)findViewById(R.id.editBloodGroup);
				editText.setText(entry.getValue());
			}
		}
		/*for(int i = 0; i<map.size(); i++){
			if(map.containsKey("First Name")){
				editText = (EditText)findViewById(R.id.editFname);
				Log.i("Test ", map.get("First Name"));
				editText.setText(map.get("First Name"));
			}else if(map.containsKey("Middle Name")){
				editText = (EditText)findViewById(R.id.editMname);
				editText.setText(map.get("Middle Name"));
			}else if(map.containsKey("Last Name")){
				editText = (EditText)findViewById(R.id.editLname);
				editText.setText(map.get("Last Name"));
			}else if(map.containsKey("Emp Code")){
				editText = (EditText)findViewById(R.id.editEmpCode);
				editText.setText(map.get("Emp Code"));
			}else if(map.containsKey("Phone")){
				editText = (EditText)findViewById(R.id.editPhone);
				editText.setText(map.get("Phone"));
			}else if(map.containsKey("Email")){
				editText = (EditText)findViewById(R.id.editEmail);
				editText.setText(map.get("Email"));
			}else if(map.containsKey("DOB")){
				editText = (EditText)findViewById(R.id.editDOB);
				editText.setText(map.get("DOB"));
			}else if(map.containsKey("Blood Group")){
				editText = (EditText)findViewById(R.id.editBloodGroup);
				editText.setText(map.get("Blood Group"));
			}
		}
		*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_form, menu);
		return true;
	}

}
