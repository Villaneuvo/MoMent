
	 
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

public class finance_activity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.finance);

	
	}

	public void home(View view){
		Intent i = new Intent(finance_activity.this, home_activity.class);
		startActivity(i);
	}

	public void toDo(View view){
		Intent i = new Intent(finance_activity.this, to_do_activity.class);
		startActivity(i);
	}

	public void profile(View view){
		Intent i = new Intent(finance_activity.this, profile_activity.class);
		startActivity(i);
	}

	public void postTransaction(View view){
		Intent i = new Intent(finance_activity.this, transaction_template_activity.class);
		startActivity(i);
	}

	public void postLimit(View view){
		Intent i = new Intent(finance_activity.this, set_limit_template_activity.class);
		startActivity(i);
	}

	public void postAnalysis(View view){
		Intent i = new Intent(finance_activity.this, analysis_activity.class);
		startActivity(i);
	}
}
	
	