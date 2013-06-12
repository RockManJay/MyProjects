package com.jay.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{
	
	TextView tvQ, tTest;
	Button returnData;
	RadioGroup selectionList;
	String gotBread, setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		//Bundle gotBasket = getIntent().getExtras();
		//gotBread = gotBasket.getString("Key");
		//tvQ.setText(gotBread);
	}


	private void initialize() {
		tvQ = (TextView) findViewById (R.id.tvQuestion);
		returnData = (Button) findViewById (R.id.bReturn);
		tTest = (TextView) findViewById (R.id.tvTest);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		selectionList.setOnCheckedChangeListener(this);
	}


	@Override
	public void onClick(View v) {
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		setResult(RESULT_OK, person);
		finish();
	}


	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch(arg1)
		{
		case R.id.rCrazy:
			setData = "Yeah, probably.";
			break;
		case R.id.rHappy:
			setData = "Excellent!";
			break;
		case R.id.rSad:
			setData = "Aww, why so sad?";
			break;
		}
		tTest.setText(setData);
	}

}
