
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		add_title_template
	 *	@date 		1655626416665
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


import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.Adapter.AddTitleAdapter;
import exportkit.xd.Adapter.ToDoActivityAdapter;

	public class AddTitleActivity extends Activity {

	private EditText InTitle;
	private ToDo todo;
	public static String Title = "";

	private RecyclerView mRecyclerView;
	private DataBaseHelperToDo myDB;
	private AddTitleAdapter addTitleAdapter;

	private List<ToDo> toDoFieldList = new ArrayList<>();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_title_template);

		InTitle = findViewById(R.id.fill_text_title);
		todo = new ToDo();

		mRecyclerView = findViewById(R.id.recycler_view_add_title);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		addTitleAdapter = new AddTitleAdapter(this, myDB);
		mRecyclerView.setAdapter(addTitleAdapter);
		myDB = new DataBaseHelperToDo(this);

		toDoFieldList = myDB.getAllTask();

		addTitleAdapter.setTask(toDoFieldList);
	}

	public void saveTitle(View view){
		if (TextUtils.isEmpty(InTitle.getText().toString().trim())){
			Toast.makeText(this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
		}
		else{
			// Making a session variable to store title into db
			String titleku = InTitle.getText().toString();
			Title = titleku;

			Intent i = new Intent(AddTitleActivity.this, set_task_activity.class);
			startActivity(i);
		}
	}
}
	
	