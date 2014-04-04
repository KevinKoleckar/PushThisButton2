package com.dummies.android.PushThisButton2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MarketPlace extends Activity {
	int currency;
	TextView walletTextView;
    public final static String EXTRA_MONEY = "com.dummies.android.PushThisButton2.MONEY";
//    public final static String EXTRA_BUTTON = "com.dummies.android.PushThisButton2.BUTTON";

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent intent = getIntent();
        currency = intent.getIntExtra(MainActivity.EXTRA_MONEY, 0);
        
        setContentView(R.layout.marketlayout);
        walletTextView = (TextView)findViewById(R.id.textView1);
        String walletText = "You have $"+ String.valueOf(currency) + ". Select a new button for $1";
        walletTextView.setText(walletText);
        
        
    }
	public void eyeSelected(View view){
//		Intent intent2 = new Intent(this, MainActivity.class);
//		intent2.putExtra(EXTRA_MONEY, currency);
//		intent2.putExtra(EXTRA_BUTTON, 1);
//		startActivity(intent2);
		currency--;
		
		
	}
	
	public void androidSelected(View view){
		currency--;
	}
	
}

