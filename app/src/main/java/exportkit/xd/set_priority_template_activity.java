
	 
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

    public class set_priority_template_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_priority_template);
	
	}
	public void simpanPriority(View view){
		Intent i = new Intent(set_priority_template_activity.this, TaskMain.class);
		startActivity(i);
	}

	public void addTask(View view){
		Intent i = new Intent(set_priority_template_activity.this, set_task_activity.class);
		startActivity(i);
	}
}
	
	