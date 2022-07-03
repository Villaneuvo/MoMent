
	 
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
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.Adapter.HomeAdapter;

	public class HomeActivity extends Activity {

	// Variable final for clickTime
	private static final long DOUBLE_CLICK_TIME_DELTA = 300;

	// Variable for calculate lastClickTime
	long lastClickTime = 0;

	private RecyclerView mRecyclerView;
	private DataBaseHelperToDo myDB;
	private HomeAdapter homeAdapter;
	private int mt = 802, ml = 15;

	private	RelativeLayout navbar;

	private List<ToDo> toDoFieldList = new ArrayList<>();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		navbar = findViewById(R.id.navbar);
		mRecyclerView = findViewById(R.id.recycler_view_home_field);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		homeAdapter = new HomeAdapter(this, myDB);
		mRecyclerView.setAdapter(homeAdapter);
		myDB = new DataBaseHelperToDo(this);

		toDoFieldList = myDB.getAllTask();

		homeAdapter.setTask(toDoFieldList);

		if(toDoFieldList.isEmpty()){

			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			lp.setMargins(50, (mt*3) - 150, 0, 0);
			navbar.setLayoutParams(lp);
		}
		else{
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			lp.setMargins(50, (mt*3) - 200, 0, 0);
			navbar.setLayoutParams(lp);
		}


	}

	@Override
	public void onBackPressed(){
		// Calculate how long back button pressed
		long clickTime = System.currentTimeMillis();
		if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA){
			// prevent back to the previous layout and close the application
			Intent a = new Intent(Intent.ACTION_MAIN);
			a.addCategory(Intent.CATEGORY_HOME);
			a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			lastClickTime = 0;
			startActivity(a);
		} else{
			Toast.makeText(this, "Double Tap To Exit", Toast.LENGTH_SHORT).show();
		}
		lastClickTime = clickTime;
	}

	public void toDo(View view){
		Intent i = new Intent(HomeActivity.this, ToDoActivity.class);
		startActivity(i);
		overridePendingTransition(0, 0);
	}

	public void finance(View view){
		Intent i = new Intent(HomeActivity.this, FinanceActivity.class);
		startActivity(i);
		overridePendingTransition(0, 0);
	}

	public void profile(View view){
		Intent i = new Intent(HomeActivity.this, profile_activity.class);
		startActivity(i);
		overridePendingTransition(0, 0);
	}

	public void setDefault(View view){
		int mt = 802;
		int ml = 15;
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(mt, ml);
		navbar.setLayoutParams(lp);
	}
}
	
	