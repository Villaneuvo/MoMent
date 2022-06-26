
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		splash_screen
	 *	@date 		1655561316054
	 *	@title 		Converting Desain
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package exportkit.xd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class home_activity extends Activity {

	// Variable final for clickTime
	private static final long DOUBLE_CLICK_TIME_DELTA = 300;

	// Variable for calculate lastClickTime
	long lastClickTime = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

	}

	@Override
	public void onBackPressed(){
		// Calculate how long back button pressed
		long clickTime = System.currentTimeMillis();
		if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA){
			// prevent back to the previous layout and close the application
			Intent a = new Intent(Intent.ACTION_MAIN);
			a.addCategory(Intent.CATEGORY_HOME);
			a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			lastClickTime = 0;
			startActivity(a);
		} else{
			Toast.makeText(this, "Double Tap To Exit", Toast.LENGTH_SHORT).show();
		}
		lastClickTime = clickTime;
	}

	public void toDo(View view){
		Intent i = new Intent(home_activity.this, to_do_activity.class);
		startActivity(i);
		overridePendingTransition(0, 0);
	}

	public void finance(View view){
		Intent i = new Intent(home_activity.this, finance_activity.class);
		startActivity(i);
		overridePendingTransition(0, 0);
	}

	public void profile(View view){
		Intent i = new Intent(home_activity.this, profile_activity.class);
		startActivity(i);
		overridePendingTransition(0, 0);
	}
}
	
	