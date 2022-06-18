
	 
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
import android.widget.ImageView;
import android.widget.TextView;

public class profile_activity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
	}

	public void home(View view){
		Intent i = new Intent(profile_activity.this, home_activity.class);
		startActivity(i);
	}

	public void toDo(View view){
		Intent i = new Intent(profile_activity.this, to_do_activity.class);
		startActivity(i);
	}

	public void finance(View view){
		Intent i = new Intent(profile_activity.this, finance_activity.class);
		startActivity(i);
	}
}
	
	