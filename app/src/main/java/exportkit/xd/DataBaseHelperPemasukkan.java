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

public class DataBaseHelperPemasukkan extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static final String DATABASE_NAME = "db_pemasukkan";
    private static final String TABLE_NAME = "table_pemasukkan";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "nominal";
    private static final String COL_3 = "sumber";
    private static final String COL_4 = "keterangan";

    public DataBaseHelperPemasukkan(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, nominal TEXT, sumber TEXT, keterangan TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void openDatabase(){
        db = this.getWritableDatabase();
    }

    public boolean insertPemasukkan(String nominal, String sumber, String keterangan){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, nominal);
        values.put(COL_3, sumber);
        values.put(COL_4, keterangan);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    @SuppressLint("Range")
    public List<Pemasukkan> getAllPemasukkan(){

        db = this.getWritableDatabase();
        Cursor cursor = null;
        List<Pemasukkan> modelList = new ArrayList<>();

        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
            if(cursor != null){
                if (cursor.moveToFirst()){
                    do{
                        Pemasukkan task = new Pemasukkan();
                        task.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
                        task.setNominal(cursor.getString(cursor.getColumnIndex(COL_2)));
                        task.setSumber(cursor.getString(cursor.getColumnIndex(COL_3)));
                        task.setKeterangan(cursor.getString(cursor.getColumnIndex(COL_4)));
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
