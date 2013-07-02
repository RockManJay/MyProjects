package com.jay.thenewboston;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener
{
	SoundPool sp;
	int explosion = 0;
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//Tip from user "James Beam", which allows volume to be set via hardware controls. Thanks Jimmy!
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		View v = new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		setContentView(v);
		setSount();
		mp = MediaPlayer.create(this, R.raw.backgroundmusic);
	}

	@Override
	public void onClick(View v)
	{
		if(explosion != 0)
			sp.play(explosion, 1, 1, 0, 0, 1);
	}

	//Memory management tip from user ErichLancaster, which frees resources after leaving the activity, which reduces the memory the app uses while running.
	@Override
	protected void onResume()
	{
		super.onResume();
		setSount();
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		sp.release();
		if(mp.isPlaying())
			mp.pause();
	}

	private void setSount()
	{
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		explosion = sp.load(this, R.raw.explosion, 1);
	}

	@Override
	public boolean onLongClick(View arg0)
	{
		//This mod is from "Matthew Duff". It allows for graceful pause/stop action.
		if(mp.isPlaying())
		{
			mp.pause();
			}
		else
		{
			mp.seekTo(0); mp.start();  //Take "mp.seekTo(0)" out and it will continue where it stopped.
		}
		return false;
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		mp.stop();
	}
	

}
