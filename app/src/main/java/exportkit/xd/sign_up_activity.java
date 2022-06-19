
	 
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

	public class sign_up_activity extends Activity {

	private ImageView signUp;
	private EditText inUsername;
	private EditText inEmail;
	private EditText inPassword;
	private EditText inConfPass;
	private DatabaseHelper BantuDb;
	private	DatabaseReference reff;
	private User user;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);

		signUp = findViewById(R.id.signup_button);
		inUsername = findViewById(R.id.name);
		inEmail = findViewById(R.id.email);
		inPassword = findViewById(R.id.password);
		inConfPass = findViewById(R.id.confirm_password);
		BantuDb = new DatabaseHelper(this);
		user = new User();
		reff = FirebaseDatabase.getInstance().getReference().child("User");

		//custom code goes here
		signUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String name = inUsername.getText().toString();
				String email = inEmail.getText().toString();
				String password = inPassword.getText().toString();

				if(TextUtils.isEmpty(inEmail.getText().toString().trim())
						&& TextUtils.isEmpty(inPassword.getText().toString().trim())
						&& TextUtils.isEmpty(inUsername.getText().toString().trim())
						&& TextUtils.isEmpty(inConfPass.getText().toString().trim())){
					Toast.makeText(view.getContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
				} else{
					if(TextUtils.isEmpty(inUsername.getText().toString().trim())){
						Toast.makeText(view.getContext(), "Username Cannot be Empty", Toast.LENGTH_SHORT).show();
					}
					else if(TextUtils.isEmpty(inPassword.getText().toString().trim()) || TextUtils.isEmpty(inConfPass.getText().toString().trim())){
						Toast.makeText(view.getContext(), "Password or Confirm Password Cannot be Empty", Toast.LENGTH_SHORT).show();
					}
					else if(inPassword.length() != inConfPass.length()){
						Toast.makeText(view.getContext(), "Password dan Confirm Password tidak sesuai", Toast.LENGTH_SHORT).show();
					}
					else if(TextUtils.isEmpty(inEmail.getText().toString().trim())){
						Toast.makeText(view.getContext(), "Email Cannot be Empty", Toast.LENGTH_SHORT).show();
					}
					else if(!isValidEmail(inEmail.getText().toString().trim())){
						Toast.makeText(view.getContext(), "Invalid Email Input", Toast.LENGTH_LONG).show();
					}

					else{
						Boolean checkUser = BantuDb.checkEmai(email);
						if (checkUser == false){
							Boolean insert = BantuDb.insertData(name, email, password);
							if (insert == true){
								user.setEmail(inEmail.getText().toString().trim());
								user.setName(inUsername.getText().toString().trim());
								user.setPassword(inPassword.getText().toString().trim());
								reff.push().setValue(user);
								Toast.makeText(view.getContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
								Intent i = new Intent(sign_up_activity.this, signup_success_activity.class);
								startActivity(i);
							}
						} else {
							Toast.makeText(view.getContext(), "Registered Failed", Toast.LENGTH_SHORT).show();
						}
					}
				}
			}
		});
	}

		public void backLogin(View view){
			Intent i = new Intent(sign_up_activity.this, login_session_activity.class);
			startActivity(i);
		}

		public static boolean isValidEmail(CharSequence email){
			return(Patterns.EMAIL_ADDRESS.matcher(email).matches());
		}
}
	
	