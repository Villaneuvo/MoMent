
	 
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

	public class add_pengeluaran_activity extends Activity {

	private EditText edt_nominal, edt_keterangan, edt_jenisPengeluaran, edt_namaBarang, edt_tanggalPengeluaran;
	private DataBaseHelperPengeluaran myDB;
	private Pengeluaran pengeluaran;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_pengeluaran);
		edt_nominal = findViewById(R.id.edt_nominalPengeluaran);
		edt_keterangan = findViewById(R.id.edt_keterangan);
		edt_jenisPengeluaran = findViewById(R.id.edt_jenisPengeluaran);
		edt_namaBarang = findViewById(R.id.edt_namaBarang);
		edt_tanggalPengeluaran = findViewById(R.id.edt_tglPengeluaran);
		myDB = new DataBaseHelperPengeluaran(this);
		pengeluaran = new Pengeluaran();
	}

		@Override
		public void onBackPressed() {
			Intent i = new Intent(add_pengeluaran_activity.this, FinanceActivity.class);
			startActivity(i);
			finish();
		}

		public void postSave(View view){
		String nominal = edt_nominal.getText().toString();
		String nama = edt_namaBarang.getText().toString();
		String keterangan = edt_keterangan.getText().toString();
		String jenis = edt_jenisPengeluaran.getText().toString();
		String tanggal = edt_tanggalPengeluaran.getText().toString();
		if(TextUtils.isEmpty(edt_nominal.getText().toString().trim())){
			Toast.makeText(this, "Nominal Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
		} else if (TextUtils.isEmpty(edt_namaBarang.getText().toString().trim())){
			Toast.makeText(this, "Nama Barang Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
		} else if (TextUtils.isEmpty(edt_jenisPengeluaran.getText().toString().trim())){
			Toast.makeText(this, "Jenis Pengeluran Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
		} else if (TextUtils.isEmpty(edt_tanggalPengeluaran.getText().toString().trim())) {
			Toast.makeText(this, "Tanggal Pengeluaran Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
		} else{
			Boolean insert = myDB.insertPengeluaran(nominal, nama, keterangan, jenis, tanggal);
			if (insert == true){
				Toast.makeText(view.getContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(add_pengeluaran_activity.this, FinanceActivity.class);
				startActivity(i);
			} else {
				Toast.makeText(view.getContext(), "Data Gagal Tersimpan", Toast.LENGTH_SHORT).show();
			}

		}
	}

	public void onBack(View view){
		Toast.makeText(this, "Kembali ke Finance", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(add_pengeluaran_activity.this, FinanceActivity.class);
		startActivity(i);
		finish();
	}
}
	
	