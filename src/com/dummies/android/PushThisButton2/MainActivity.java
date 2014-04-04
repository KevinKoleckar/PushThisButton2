package com.dummies.android.PushThisButton2;

import java.util.ArrayList;
import java.util.Random;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
//	GLOBAL VARIABLES
	int score;
	TextView scoreBoard; 
	int currencyHandler;
	int currency;
	TextView Wallet;
	int buttonAsset;
    static final String STATE_SCORE = "score";
    static final String STATE_currency = "currency";
    static final String STATE_HANDLER = "currencyHandler";
    static final String STATE_ASSET = "buttonAsset";
    public static final String PREFS_NAME = "MyPrefsFile";
    public final static String EXTRA_MONEY = "com.example.myapp.MONEY";
    private static final int POOR_DIALOG = 1;
    private static final int REALLY_DIALOG = 2;
    private static final int HELP_DIALOG = 3;
//    String MY_AD_UNIT_ID = "a14ffef57799a1c";
//  private AdView adView;
    public ArrayList<String> allTheThings = new ArrayList<String>();

    
    
        


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        scoreBoard = (TextView)findViewById(R.id.ScoreTextView);
        //button = (Button)findViewById(R.id.button1);
        Wallet = (TextView)findViewById(R.id.CurrencyTextView);}

        

        
    @Override
    protected void onStart() {
        super.onStart();  // Always call the superclass method first

        // The activity is either being restarted or started for the first time
     // Get from the SharedPreferences
    	Resources r = getResources();
//    	String def = "button_00_default";
//    	int resid=r.getIdentifier(def, "drawable", "com.dummies.android.PushThisButton2");
//        
//        score = 0;
//        currency = 0;
//        currencyHandler =10;
//        buttonAsset = resid;
        
        
        
        SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        score = settings.getInt("score", 0);
        currency = settings.getInt("currency", 0);
        currencyHandler = settings.getInt("currencyHandler", 10);
        buttonAsset = settings.getInt("buttonAsset", 0);
        String newText = "You have earned "+ String.valueOf(score) + (score==1?" point":" points");
        String wallettext = "$"+String.valueOf(currency);
        scoreBoard.setText(newText);
        Wallet.setText(wallettext);
//        Drawable d = getResources().getDrawable(
//                R.drawable.level);
//        d.setLevel(picId);
    	Button button = (Button)findViewById(R.id.button1);
//    	ArrayList<String> allTheThings = new ArrayList<String>();
    	allTheThings.add("button_00_default");
    	allTheThings.add("button_01_android");
    	allTheThings.add("button_02_eye");
    	allTheThings.add("button_02_eye1");
    	allTheThings.add("button_03_anvil");
    	allTheThings.add("button_04_bomb");
    	allTheThings.add("button_05_bubble");
    	allTheThings.add("button_06_fish");
    	allTheThings.add("button_07_flower");
    	allTheThings.add("button_08_knife");
    	allTheThings.add("button_09_knifehappy");
    	allTheThings.add("button_10_moon");
    	allTheThings.add("button_11_thunderbolt");
//
    	String thatNewThing = allTheThings.get(buttonAsset);
//    	Resources r = getResources();
    	int picId=r.getIdentifier(thatNewThing, "drawable", "com.dummies.android.PushThisButton2");
    	
    	

    	button.setBackgroundResource(picId);

    }
    
    
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
       
        // Restore state members from saved instance
        score = savedInstanceState.getInt(STATE_SCORE);
        currency = savedInstanceState.getInt(STATE_currency);
        currencyHandler = savedInstanceState.getInt(STATE_HANDLER);
//        String asset = savedInstanceState.getString(STATE_ASSET);
        buttonAsset = savedInstanceState.getInt(STATE_ASSET);
        String newText = "You have earned "+ String.valueOf(score) + (score==1?" point":" points");
        String wallettext = "$"+String.valueOf(currency);
        scoreBoard.setText(newText);
        Wallet.setText(wallettext);
//        Drawable d = getResources().getDrawable(
//                R.drawable.level);
//        d.setLevel(picId);
    	Button button = (Button)findViewById(R.id.button1);
//    	ArrayList<String> allTheThings = new ArrayList<String>();
//    	allTheThings.add("button_00_default");
//    	allTheThings.add("button_01_android");
//    	allTheThings.add("button_02_eye");
//    	allTheThings.add("button_02_eye1");
//    	allTheThings.add("button_03_anvil");
//    	allTheThings.add("button_04_bomb");
//    	allTheThings.add("button_05_bubble");
//    	allTheThings.add("button_06_fish");
//    	allTheThings.add("button_07_flower");
//    	allTheThings.add("button_08_knife");
//    	allTheThings.add("button_09_knifehappy");
//    	allTheThings.add("button_10_moon");
//    	allTheThings.add("button_11_thunderbolt");

    	String thatNewThing = String.valueOf(allTheThings.get(buttonAsset));
    	Resources r = getResources();
    	int picId=r.getIdentifier(thatNewThing, "drawable", "com.dummies.android.PushThisButton2");
    	button.setBackgroundResource(picId);

    }
    
    
    
     public void onButtonPressed(View view){
    	 score++;
    	 currencyHandler--;
    	 if (currencyHandler < 1)
    			{currency++;
    			currencyHandler=10;}
String newText = "You have earned "+ String.valueOf(score) + (score==1?" point":" points");
String wallettext = "$"+String.valueOf(currency);
scoreBoard.setText(newText);
Wallet.setText(wallettext);
     }     
     
     @Override
     public void onSaveInstanceState(Bundle savedInstanceState) {
//         Drawable d = getResources().getDrawable(
//                 R.drawable.level);
//         
//     	int picId = d.getLevel();
         // Save the user's current game state
         savedInstanceState.putInt(STATE_SCORE, score);
         savedInstanceState.putInt(STATE_currency, currency);
         savedInstanceState.putInt(STATE_HANDLER, currencyHandler);
         savedInstanceState.putInt(STATE_ASSET, buttonAsset);
         // Always call the superclass so it can save the view hierarchy state
         super.onSaveInstanceState(savedInstanceState);
     }
 
     @Override
     protected void onStop(){
        super.onStop();
//        Drawable d = getResources().getDrawable(
//                R.drawable.level);
//        int picId = d.getLevel();
       // We need an Editor object to make preference changes.
       // All objects are from android.context.Context
       SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
       SharedPreferences.Editor editor = settings.edit();
       editor.putInt("score", score);
       editor.putInt("currency", currency);
       editor.putInt("currencyHandler", currencyHandler);
       editor.putInt("buttonAsset", buttonAsset);
//       editor.putInt("buttonAsset", picId);
       // Commit the edits!
       editor.commit();
     }
     
     
//	public void onMarketClick(View view){
//		Intent intent = new Intent(this, MarketPlace.class);
//		intent.putExtra(EXTRA_MONEY, currency);
//		startActivity(intent);
//	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.game_menu, menu);
	    return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.item1:
	        	showDialog(2);
	            return true;

	        case R.id.item2:
	        	if (currency-10 < 0)
	        	{showDialog(1);}
	        	else {
	        		currency=currency-10;
	        	Button button = (Button)findViewById(R.id.button1);

//	        	ArrayList<String> allTheThings = new ArrayList<String>();
//	        	allTheThings.add("button_00_default");
//	        	allTheThings.add("button_01_android");
//	        	allTheThings.add("button_02_eye");
//	        	allTheThings.add("button_02_eye1");
//	        	allTheThings.add("button_03_anvil");
//	        	allTheThings.add("button_04_bomb");
//	        	allTheThings.add("button_05_bubble");
//	        	allTheThings.add("button_06_fish");
//	        	allTheThings.add("button_07_flower");
//	        	allTheThings.add("button_08_knife");
//	        	allTheThings.add("button_09_knifehappy");
//	        	allTheThings.add("button_10_moon");
//	        	allTheThings.add("button_11_thunderbolt");
	        	int N= allTheThings.size();
//	        	Random random = new Random();
	        	int thisOne = new Random().nextInt(N);
	        	buttonAsset= thisOne;
	        	String thatNewThing = String.valueOf(allTheThings.get(buttonAsset));
	        	Resources r = getResources();
	        	int picId=r.getIdentifier(thatNewThing, "drawable", "com.dummies.android.PushThisButton2");
	        	button.setBackgroundResource(picId);
	            String wallettext = "$"+String.valueOf(currency);
	            Wallet.setText(wallettext);}
	        	return true;
	        	
	        case R.id.item3:
	        	showDialog(3);
	        	return true;
	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
//  CREATE DIALOG CLASS
  @Override
  protected Dialog onCreateDialog(int id) {
      Dialog dialog;
      AlertDialog.Builder builder;
      switch(id) {
      case POOR_DIALOG:
          builder = new AlertDialog.Builder(this);
          builder.setMessage("You don't have enough money!")
          .setCancelable(false)
          .setPositiveButton("OK", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                  //Do something here
              	dialog.cancel();
              }
          });
          dialog = builder.create();
          break;
      case REALLY_DIALOG:
          builder = new AlertDialog.Builder(this);
          builder.setMessage("Are you sure you want to reset your score?")
          .setCancelable(false)
          .setPositiveButton("I'm crazy", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                  //Do something here
  	            score=0;
  	            currency=0;
      			currencyHandler=10;
  String newText = "You have earned "+ String.valueOf(score) + (score==1?" point":" points");
  String wallettext = "$"+String.valueOf(currency);
  scoreBoard.setText(newText);
  Wallet.setText(wallettext);
  dialog.dismiss();
              }
          })
          .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                  //Do something here
              	dialog.cancel();
              }
          });

          dialog = builder.create();
          break;   
      case HELP_DIALOG:
          builder = new AlertDialog.Builder(this);
          builder.setMessage("Press the button to earn points and money. Once you have enough money select 'New Button' from the menu for a new button chosen at random.")
          .setCancelable(false)
          .setPositiveButton("OK", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                  //Do something here
              	dialog.cancel();
              }
          });
          dialog = builder.create();
          break;
      default:
          dialog = null;
      }
      return dialog;
  }
}


//
//SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
//SharedPreferences.Editor editor = settings.edit();
//editor.putBoolean("homeScore", YOUR_HOME_SCORE);
//
//// Commit the edits!
//editor.commit();
//
//// Get from the SharedPreferences
//SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
//int homeScore = settings.getBoolean("homeScore", false);