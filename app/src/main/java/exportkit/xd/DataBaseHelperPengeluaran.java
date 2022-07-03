package exportkit.xd;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelperPengeluaran extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static final String DATABASE_NAME = "db_pengeluaran";
    private static final String TABLE_NAME = "table_pengeluaran";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "nominal";
    private static final String COL_3 = "nama_barang";
    private static final String COL_4 = "keterangan";
    private static final String COL_5 = "jenis";
    private static final String COL_6 = "tanggal";

    public DataBaseHelperPengeluaran(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, nominal TEXT, nama_barang TEXT, keterangan TEXT, jenis TEXT, tanggal TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void openDatabase(){
        db = this.getWritableDatabase();
    }

    public boolean insertPengeluaran(String nominal, String nama_barang, String keterangan, String jenis, String tanggal){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, nominal);
        values.put(COL_3, nama_barang);
        values.put(COL_4, keterangan);
        values.put(COL_5, jenis);
        values.put(COL_6, tanggal);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    @SuppressLint("Range")
    public List<Pengeluaran> getAllPengeluaran(){

        db = this.getWritableDatabase();
        Cursor cursor = null;
        List<Pengeluaran> modelList = new ArrayList<>();

        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
            if(cursor != null){
                if (cursor.moveToFirst()){
                    do{
                        Pengeluaran task = new Pengeluaran();
                        task.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
                        task.setNominal(cursor.getString(cursor.getColumnIndex(COL_2)));
                        task.setNama_barang(cursor.getString(cursor.getColumnIndex(COL_3)));
                        task.setKeterangan(cursor.getString(cursor.getColumnIndex(COL_4)));
                        task.setJenis(cursor.getString(cursor.getColumnIndex(COL_5)));
                        task.setTanggal(cursor.getString(cursor.getColumnIndex(COL_6)));
                        modelList.add(task);
                    } while(cursor.moveToNext());
                }
            }
        } finally {
            db.endTransaction();
            cursor.close();
        }
        return modelList;
    }


}
