
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		set_task
	 *	@date 		1655633900480
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

public class set_task_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_task);
	
	}

	public void setTime(View view){
		Intent i = new Intent(set_task_activity.this, set_time_activity.class);
		startActivity(i);
	}

	public void setRepeat(View view){
		Intent i = new Intent(set_task_activity.this, set_reminder_activity.class);
		startActivity(i);
	}

	public void saveTask(View view){
		Intent i = new Intent(set_task_activity.this, to_do_field_non_setting_list.class);
		startActivity(i);
	}

	public void backToDo(View view){
		Intent i = new Intent(set_task_activity.this, to_do_activity.class);
		startActivity(i);
	}
}
	
	