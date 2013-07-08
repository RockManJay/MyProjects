package com.jay.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener 
{
	EditText url;
	WebView ourBrowser;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		
		ourBrowser = (WebView) findViewById(R.id.wvBrowser);
		
		ourBrowser.getSettings().setJavaScriptEnabled(true);
		ourBrowser.getSettings().setLoadWithOverviewMode(true);
		ourBrowser.getSettings().setUseWideViewPort(true);
		
		ourBrowser.setWebViewClient(new ourViewClient());
		try
		{
			ourBrowser.loadUrl("http://www.mybringback.com");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Button go = (Button) findViewById(R.id.bGo);
		Button back = (Button) findViewById(R.id.bBack);
		Button refresh = (Button) findViewById(R.id.bRefresh);
		Button forward = (Button) findViewById(R.id.bForward);
		Button clearHistory = (Button) findViewById(R.id.bClearHist);
		url = (EditText) findViewById(R.id.etURL);
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		refresh.setOnClickListener(this);
		forward.setOnClickListener(this);
		clearHistory.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.bGo:
			String theSite = url.getText().toString();
			ourBrowser.loadUrl(theSite);
			//Hiding the keyboard after using EditText
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bBack:
			if(ourBrowser.canGoBack())
				ourBrowser.goBack();
			break;
		case R.id.bForward:
			if(ourBrowser.canGoForward())
				ourBrowser.goForward();
			break;
		case R.id.bRefresh:
			ourBrowser.reload();
			break;
		case R.id.bClearHist:
			ourBrowser.clearHistory();
			break;
		}
	}

}
