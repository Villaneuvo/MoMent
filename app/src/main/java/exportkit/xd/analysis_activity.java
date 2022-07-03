
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		transaction_template
	 *	@date 		1655647990568
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

public class analysis_activity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.analysis);
	}

	public void home(View view){
		Intent i = new Intent(analysis_activity.this, HomeActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void toDo(View view){
		Intent i = new Intent(analysis_activity.this, ToDoActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void profile(View view){
		Intent i = new Intent(analysis_activity.this, profile_activity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}
}
	
	