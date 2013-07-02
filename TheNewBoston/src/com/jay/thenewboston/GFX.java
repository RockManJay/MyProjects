package com.jay.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
//import android.view.WindowManager;

public class GFX extends Activity{
	
	MyBringBack ourView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//No Title Bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		ourView = new MyBringBack(this);
		setContentView(ourView);
	}
	
}
