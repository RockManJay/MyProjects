package com.jay.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity
{
	String	classes[] = {"StartingPoint", "TextPlay", "example2", "example3", "example4", "example5", "example6"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
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
}
