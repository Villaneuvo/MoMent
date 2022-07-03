
	 
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


import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class add_pemasukkan_activity extends Activity {

	private EditText edt_sumberPemasukan, edt_nominalPemasukkan, edt_keterangan;
	private DataBaseHelperPemasukkan myDB;
	private Pemasukkan pemasukkan;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_pemasukkan);

		edt_sumberPemasukan = findViewById(R.id.edt_sumberPemasukan);
		edt_nominalPemasukkan = findViewById(R.id.edt_nominalPemasukkan);
		edt_keterangan = findViewById(R.id.edtKeterangan);
		myDB = new DataBaseHelperPemasukkan(this);
		pemasukkan = new Pemasukkan();

	}

	@Override
	public void onBackPressed() {
		Intent i = new Intent(add_pemasukkan_activity.this, FinanceActivity.class);
		startActivity(i);
		finish();
	}

	public void postSave(View view){
		String nominal = edt_nominalPemasukkan.getText().toString();
		String sumber = edt_sumberPemasukan.getText().toString();
		String keterangan = edt_keterangan.getText().toString();
		if(TextUtils.isEmpty(edt_nominalPemasukkan.getText().toString().trim())){
			Toast.makeText(this, "Nominal Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
		} else if (TextUtils.isEmpty(edt_sumberPemasukan.getText().toString().trim())){
			Toast.makeText(this, "Sumber Pemasukan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
		} else{
			boolean insert = myDB.insertPemasukkan(nominal, sumber, keterangan);
			if (insert == true){
				Toast.makeText(this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(add_pemasukkan_activity.this, FinanceActivity.class);
				startActivity(i);
			} else{
				Toast.makeText(this, "Data Gagal Tersimpan", Toast.LENGTH_SHORT).show();
			}

		}
	}

	public void onBack(View view){
		Toast.makeText(this, "Kembali ke Finance", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(add_pemasukkan_activity.this, FinanceActivity.class);
		startActivity(i);
		finish();
	}
}
	
	