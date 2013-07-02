package com.jay.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
//import android.view.WindowManager;

public class GFX extends Activity{
	
	MyBringBack ourView;
	WakeLock wL;
	PowerManager pM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Wake-Lock
		pM = (PowerManager)getSystemService(Context.POWER_SERVICE);
		wL = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		
		super.onCreate(savedInstanceState);
		
		//No Title Bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		ourView = new MyBringBack(this);
		setContentView(ourView);
	}

	@Override
	protected void onPause() {
		super.onPause();
		wL.release();
	}

	@Override
	protected void onResume() {		
		super.onResume();
		wL.acquire();
	}
	
}
