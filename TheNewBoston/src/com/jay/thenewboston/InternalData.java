package com.jay.thenewboston;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener
{
	
	EditText sharedData;
	TextView dataResults;
	FileOutputStream fos;
	String FILENAME = "InternalString";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVariables();
	}

	private void setupVariables()
	{
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedPrefs);
		dataResults = (TextView) findViewById(R.id.tvLoad);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		try
		{
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.bSave:
			String data = sharedData.getText().toString();
			//Save data via File
			/*File f = new File(FILENAME);
			try
			{
				fos = new FileOutputStream(f);
				fos.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}*/
			try
			{
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			break;
		case R.id.bLoad:
			new loadSomeStuff().execute(FILENAME);
			break;
		}
	}
	public class loadSomeStuff extends AsyncTask<String, Integer, String>
	{
		
		protected void onPreExecute(String f)
		{
			//example of setting up something
			f = "whatever";
		}

		@Override
		protected String doInBackground(String... arg0)
		{
			String collected = null;
			FileInputStream fis = null;
			try
			{
				fis = openFileInput(FILENAME);
				byte[] dataArray = new byte[fis.available()];
				while (fis.read(dataArray) != -1)
				{
					collected = new String(dataArray);
				}
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					fis.close();
					return collected;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return null;
		}
		
		protected void onProgressUpdated(Integer...progress)
		{
			
		}
		
		protected void onPostExecute(String result)
		{
			dataResults.setText(result);
		}
		
	}
}
