package exportkit.xd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Variable for database
    public static final String DBNAME = "data_user.db";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, "data_user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE table_user(name TEXT, email PRIMARY KEY, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS table_user");
    }

    public Boolean insertData(String name, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = db.insert("table_user", null, contentValues);
        if (result == - 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkEmai(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM table_user where email = ?", new String[] {email});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkEmailPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM table_user where email = ? AND password = ?", new String[]{email, password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
