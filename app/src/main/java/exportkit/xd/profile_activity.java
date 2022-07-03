
	 
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
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;

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
		Intent i = new Intent(profile_activity.this, HomeActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void home(View view){
		Intent i = new Intent(profile_activity.this, HomeActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void toDo(View view){
		Intent i = new Intent(profile_activity.this, ToDoActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void finance(View view){
		Intent i = new Intent(profile_activity.this, FinanceActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void postLogout(View view){
		Intent i = new Intent(profile_activity.this, logout_session.class);
		startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
	}

	public void postChangePassword(View view){
		Intent i = new Intent(profile_activity.this, change_password.class);
		startActivity(i);
	}

	public void postHelp(View view){
		Intent i = new Intent(profile_activity.this, help_activity.class);
		startActivity(i);
	}

	public void postAbout(View view){
		Intent i = new Intent(profile_activity.this, about_activity.class);
		startActivity(i);
	}
}
	
	