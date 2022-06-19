
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		success_change
	 *	@date 		1655623930391
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


import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class signup_success_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_success);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(signup_success_activity.this, login_session_activity.class);
				startActivity(i);
				finish();
			}
		}, 3000);
	}

	public void backLogin(View view){
		Intent i = new Intent(signup_success_activity.this, login_session_activity.class);
		startActivity(i);
	}
}
	
	