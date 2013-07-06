package com.jay.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class SimpleBrowser extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		
		WebView ourBrowser = (WebView) findViewById(R.id.wvBrowser);
		ourBrowser.loadUrl("http://www.mybringback.com");
	}

}
