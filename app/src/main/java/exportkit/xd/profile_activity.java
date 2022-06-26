
	 
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


import android.os.Debug;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class profile_activity extends Activity {

	private boolean switchOn = false;

	LottieAnimationView notifSwitch, soundSwitch;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);

		notifSwitch = findViewById(R.id.switch_notif_icon);
		soundSwitch = findViewById(R.id.switch_sounds_icon);

		notifSwitch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(switchOn){
					notifSwitch.setMinAndMaxProgress(0.5f, 1.0f);
					notifSwitch.playAnimation();
					switchOn = false;
				} else{
					notifSwitch.setMinAndMaxProgress(0.0f, 0.5f);
					notifSwitch.playAnimation();
					switchOn = true;
				}
			}
		});

		soundSwitch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				soundSwitch.playAnimation();
			}
		});
	}

	@Override
	public void onBackPressed() {
		Intent i = new Intent(profile_activity.this, home_activity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void home(View view){
		Intent i = new Intent(profile_activity.this, home_activity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void toDo(View view){
		Intent i = new Intent(profile_activity.this, to_do_activity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void finance(View view){
		Intent i = new Intent(profile_activity.this, finance_activity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}
}
	
	