
	 
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
import android.widget.EditText;
import android.widget.Toast;

    public class set_task_activity extends Activity {

	EditText edtTask, edtDate, edtDescription;
	DataBaseHelperToDo MyDB;
	ToDo toDo;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_task);

		edtTask = findViewById(R.id.edtTask);
		edtDate = findViewById(R.id.edtDate);
		edtDescription = findViewById(R.id.edtDescription);
		MyDB = new DataBaseHelperToDo(this);
		toDo = new ToDo();
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
		String title = AddTitleActivity.Title;
		toDo.setDescription(edtDescription.getText().toString());
		boolean isInserted = MyDB.insertTask(edtTask.getText().toString(), edtDate.getText().toString(), edtDescription.getText().toString(), title);
		if (isInserted == true) {
			Toast.makeText(set_task_activity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
			Intent i = new Intent(set_task_activity.this, TaskMain.class);
			startActivity(i);
		}
		else
			Toast.makeText(set_task_activity.this, "Data Tidak Tersimpan", Toast.LENGTH_SHORT).show();


	}

	public void backToDo(View view){
		Intent i = new Intent(set_task_activity.this, ToDoActivity.class);
		startActivity(i);
	}
}
	
	