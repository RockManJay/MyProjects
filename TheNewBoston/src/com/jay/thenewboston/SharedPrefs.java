package com.jay.thenewboston;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener
{
	EditText sharedData;
	TextView dataResults;
	public static String fileName = "MySharedString";
	SharedPreferences someData;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVariables();
		someData = getSharedPreferences(fileName, 0);
	}
	
	private void setupVariables()
	{
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedPrefs);
		dataResults = (TextView) findViewById(R.id.tvLoad);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.bSave:
			String stringData = sharedData.getText().toString();
			SharedPreferences.Editor editor = someData.edit();
			editor.putString("sharedString", stringData);
			editor.commit();
			break;
		case R.id.bLoad:
			someData = getSharedPreferences(fileName, 0);
			String dataReturned = someData.getString("sharedString", "Could not load Data");
			dataResults.setText(dataReturned);
			break;
		}
	}

}
