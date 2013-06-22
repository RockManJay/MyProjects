package com.jay.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{
	
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle JayLovesBacon) {
		super.onCreate(JayLovesBacon);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.kliqsplashsound);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		
		if (music == true)
			ourSong.start();
		
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{
					sleep(5000);
				} //end try
				catch (InterruptedException e)
				{
					e.printStackTrace();
				} //end catch
				finally
				{
					Intent openStartingPoint = new Intent("com.jay.thenewboston.MENU");
					startActivity(openStartingPoint);
				} //end finally
			} //end run
		}; //End timer
		timer.start();
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		ourSong.release();
		finish();
	}//end onPause
	
	

}
