package com.jay.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
		ourBrowser.setWebViewClient(new ourViewClient());
		ourBrowser.loadUrl("http://www.mybringback.com");
		
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
