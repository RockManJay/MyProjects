package com.jay.thenewboston;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener, OnCheckedChangeListener, OnDrawerOpenListener
{
	SlidingDrawer sd;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		Button button1 = (Button) findViewById(R.id.Button1);
		Button button2 = (Button) findViewById(R.id.Button2);
		Button button3 = (Button) findViewById(R.id.Button3);
		Button button4 = (Button) findViewById(R.id.Button4);
		CheckBox checkbox = (CheckBox) findViewById(R.id.cbSlidable);
		checkbox.setOnCheckedChangeListener(this);
		sd = (SlidingDrawer) findViewById(R.id.slidingD);
		sd.setOnDrawerOpenListener(this);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0)
	{
		switch (arg0.getId())
		{
		case R.id.Button1:
			sd.open();
			break;
		case R.id.Button2:
			
			break;
		case R.id.Button3:
			sd.toggle();
			break;
		case R.id.Button4:
			sd.close();
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1)
	{
		if(arg0.isChecked())
		{
			sd.lock();
		}
		else
		{
			sd.unlock();
		}
	}

	@Override
	public void onDrawerOpened()
	{
		MediaPlayer mp = MediaPlayer.create(this, R.raw.death);
		mp.start();
	}

}
