
	 
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


import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class create_password_activity extends Activity {

	private EditText inputNewPass;
	private EditText inputConfirmPass;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_password);

		inputNewPass = findViewById(R.id.password_ek1);
		inputConfirmPass = findViewById(R.id.confirm_password_ek1);
	
	}

	public void successChangePassword(View view){
		if (TextUtils.isEmpty(inputNewPass.getText().toString().trim())
				&&
				TextUtils.isEmpty(inputConfirmPass.getText().toString().trim())){
			Toast.makeText(view.getContext(), "Both Confirm & New Password Cannot Be Empty", Toast.LENGTH_SHORT).show();
		}
		else if(TextUtils.isEmpty(inputNewPass.getText().toString().trim())){
			Toast.makeText(view.getContext(), "New Password Cannot Be Empty", Toast.LENGTH_SHORT).show();
		}
		else if(TextUtils.isEmpty(inputConfirmPass.getText().toString().trim())){
			Toast.makeText(view.getContext(), "Confirm Password Cannot Be Empty", Toast.LENGTH_SHORT).show();
		}
		else if(inputNewPass.length() != inputConfirmPass.length()){
			Toast.makeText(view.getContext(), "New Password & Confirm Password didn't Match", Toast.LENGTH_SHORT).show();
		}
		else{
			Intent i = new Intent(create_password_activity.this, success_change_activity.class);
			startActivity(i);
		}

	}
}
	
	