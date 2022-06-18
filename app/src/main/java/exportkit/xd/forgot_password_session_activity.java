
	 
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
import android.media.Image;
import android.os.Bundle;


import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

	public class forgot_password_session_activity extends Activity {

	private EditText InEmail;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot_password_session);

		InEmail = findViewById(R.id.email_forgotPassword);

	}

	public void checkEmail (View view){
		if (TextUtils.isEmpty(InEmail.getText().toString().trim())){
			Toast.makeText(view.getContext(), "Email Cannot Be Empty", Toast.LENGTH_SHORT).show();
		} else{
			if (!isValidEmail(InEmail.getText().toString().trim())){
				Toast.makeText(view.getContext(), "Invalid Email Input", Toast.LENGTH_SHORT).show();
			} else{
				Intent i = new Intent(forgot_password_session_activity.this, check_email_activity.class);
				startActivity(i);
			}
		}
	}

	public static boolean isValidEmail(CharSequence email){
		return(Patterns.EMAIL_ADDRESS.matcher(email).matches());
	}
}
	
	