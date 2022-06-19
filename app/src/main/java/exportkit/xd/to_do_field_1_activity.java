
	 
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


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class to_do_field_1_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.to_do_field_1);

	}

	public void backToDo(View view){
		Intent i = new Intent(to_do_field_1_activity.this, to_do_activity.class);
		startActivity(i);
	}

	public void setPriority(View view){
		Intent i = new Intent(to_do_field_1_activity.this, set_priority_template_activity.class);
		startActivity(i);
	}


}
	
	