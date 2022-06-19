
	 
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

	public class login_session_activity extends Activity {

	private EditText InPassword;
	private EditText InEmail;
	private ImageView logIn;
	private DatabaseHelper BantuDb;
	private DatabaseReference reff;
	private User user;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_session);

		InPassword = findViewById(R.id.password);
		InEmail = findViewById(R.id.email);
		logIn = findViewById(R.id.log_in_button);
		BantuDb = new DatabaseHelper(this);
		user = new User();
		reff = FirebaseDatabase.getInstance().getReference("User");

		logIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String email = InEmail.getText().toString();
				String password = InPassword.getText().toString();

				if (TextUtils.isEmpty(InEmail.getText().toString().trim())
						&& TextUtils.isEmpty(InPassword.getText().toString().trim())){
					Toast.makeText(view.getContext(), "Email & Password Cannot Be Empty", Toast.LENGTH_SHORT).show();
				}
				else{
					if (TextUtils.isEmpty(InEmail.getText().toString().trim())){
						Toast.makeText(view.getContext(), "Email Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
					}
					else if (TextUtils.isEmpty(InPassword.getText().toString().trim())){
						Toast.makeText(view.getContext(), "Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
					}
					else if (!isValidEmail(InEmail.getText().toString().trim())){
						Toast.makeText(view.getContext(), "Invalid Email Input", Toast.LENGTH_SHORT).show();
					}
					else{
						Boolean checkEmailPass =BantuDb.checkEmailPassword(email, password);
						if (checkEmailPass){
							Toast.makeText(view.getContext(), "Login successfull", Toast.LENGTH_SHORT).show();
							Intent i = new Intent(login_session_activity.this, home_activity.class);
							startActivity(i);
						}
						else{
							Intent i = new Intent(login_session_activity.this, login_error_session_activity.class);
							startActivity(i);
						}
					}
				}
			}
		});
	}

	public void signUpButton(View view){
		Intent i = new Intent(login_session_activity.this, sign_up_activity.class);
		startActivity(i);
	}

	public void forgotPassword(View view){
		Intent i = new Intent(login_session_activity.this, forgot_password_session_activity.class);
		startActivity(i);
	}

	public static boolean isValidEmail(CharSequence email){
		return(Patterns.EMAIL_ADDRESS.matcher(email).matches());
	}
}
	
	