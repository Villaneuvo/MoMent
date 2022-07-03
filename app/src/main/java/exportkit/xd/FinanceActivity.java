
	 
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

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.Adapter.FinancePengeluaranAdapter;

public class FinanceActivity extends Activity {

	private RecyclerView mRececylerView;
	private FinancePengeluaranAdapter financeAdapter;
	private DataBaseHelperPengeluaran myDB;
	private DataBaseHelperPemasukkan myDBPemasukkan;

	private List<Pengeluaran> financeFieldList = new ArrayList<>();
	private List<Pemasukkan> financePemasukkanFieldList = new ArrayList<>();
	public static boolean isFillPemasukkan = false;


		@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.finance);

		mRececylerView = findViewById(R.id.recycler_view_finance_section_field);
		mRececylerView.setLayoutManager(new LinearLayoutManager(this));
		financeAdapter = new FinancePengeluaranAdapter(this, myDB);
		mRececylerView.setAdapter(financeAdapter);
		myDB = new DataBaseHelperPengeluaran(this);
		myDBPemasukkan = new DataBaseHelperPemasukkan(this);

		financePemasukkanFieldList = myDBPemasukkan.getAllPemasukkan();
		financeFieldList = myDB.getAllPengeluaran();

		financeAdapter.setTask(financeFieldList);
		if (isFillPemasukkan == true){
			financeAdapter.setTaskPemasukkan(financePemasukkanFieldList);
		}

	}

	@Override
	public void onBackPressed() {
		Intent i = new Intent(FinanceActivity.this, HomeActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void home(View view){
		Intent i = new Intent(FinanceActivity.this, HomeActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void toDo(View view){
		Intent i = new Intent(FinanceActivity.this, ToDoActivity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void profile(View view){
		Intent i = new Intent(FinanceActivity.this, profile_activity.class);
		startActivity(i);
		overridePendingTransition(0,0);
	}

	public void postTransaction(View view){
		Intent i = new Intent(FinanceActivity.this, transaction_template_activity.class);
		startActivity(i);
	}

	public void postLimit(View view){
		Intent i = new Intent(FinanceActivity.this, set_limit_template_activity.class);
		startActivity(i);
	}

	public void postAnalysis(View view){
		Intent i = new Intent(FinanceActivity.this, analysis_activity.class);
		startActivity(i);
	}
}
	
	