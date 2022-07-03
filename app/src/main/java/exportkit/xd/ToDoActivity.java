
	 
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
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.Adapter.ToDoActivityAdapter;

	public class ToDoActivity extends Activity {

	private RecyclerView mRecyclerView;
	private DataBaseHelperToDo myDB;
	private ToDoActivityAdapter toDoActivityAdapter;

	private List<ToDo> toDoFieldList = new ArrayList<>();
	private int mt = 802, ml = 807;

	RelativeLayout addBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.to_do);

		mRecyclerView = findViewById(R.id.recycler_view_toDo_field);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		toDoActivityAdapter = new ToDoActivityAdapter(this, myDB);
		mRecyclerView.setAdapter(toDoActivityAdapter);
		myDB = new DataBaseHelperToDo(this);
		addBtn = findViewById(R.id.group_29);

		toDoFieldList = myDB.getAllTask();

		toDoActivityAdapter.setTask(toDoFieldList);

		if(toDoFieldList.isEmpty()){
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			lp.setMargins(ml, (mt*2), 0, 0);
			addBtn.setLayoutParams(lp);
		} else{
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			lp.setMargins(ml, (mt*3) - 150, 0, 0);
			addBtn.setLayoutParams(lp);
		}

	}

	@Override
	public void onBackPressed() {
		Intent i = new Intent(ToDoActivity.this, HomeActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void home(View view){
		Intent i = new Intent(ToDoActivity.this, HomeActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void finance(View view){
		Intent i = new Intent(ToDoActivity.this, FinanceActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void profile(View view){
		Intent i = new Intent(ToDoActivity.this, profile_activity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void addTitle(View view){
		Intent i = new Intent(ToDoActivity.this, AddTitleActivity.class);
		startActivity(i);
	}
}
	
	