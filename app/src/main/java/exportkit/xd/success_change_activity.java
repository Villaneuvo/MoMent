
	 
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
import android.os.Bundle;


import android.os.Handler;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class success_change_activity extends Activity {

	
	private View __bg__success_change_ek2;
	private View background_splash_ek1;
	private ImageView change_success_image;
	private TextView your_password_have_changed_successfuly__it_will_automatically_back_to_login_session;
	private TextView moment;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.success_change);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(success_change_activity.this, login_session_activity.class);
				startActivity(i);
				finish();
			}
		}, 3000);
	}
}
	
	