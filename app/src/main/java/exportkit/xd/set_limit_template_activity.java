
	 
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

public class set_limit_template_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_limit_template);

	}

	public void saveLimit(View view){
		Intent i = new Intent(set_limit_template_activity.this, finance_activity.class);
		startActivity(i);
	}
}
	
	