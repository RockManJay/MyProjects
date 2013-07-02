package com.jay.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity
{
	String	classes[] = {"StartingPoint", "TextPlay", "Email", "Camera", "Data", "GFX", "GFXSurface", "SoundStuff"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		//Fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}//end onCreate

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		String cheese = classes[position];
		super.onListItemClick(l, v, position, id);
		try
		{
			Class ourClass = Class.forName("com.jay.thenewboston." + cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		}//end try
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}//end catch
	}//end onListItemClick

	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId())
		{
		case R.id.aboutUs:
			Intent i = new Intent("com.jay.thenewboston.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent p = new Intent("com.jay.thenewboston.PREFS");
			startActivity(p);
			break;
		case R.id.exit:
			finish();
			break;
		}//end switch-case
		return false;
	}
	
	
}
