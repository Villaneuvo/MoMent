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

public class DataBaseHelperToDo extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static final String DATABASE_NAME = "db_todo";
    private static final String TABLE_NAME = "table_todo";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "Title";
    private static final String COL_3 = "Task";
    private static final String COL_4 = "Date";
    private static final String COL_5 = "Description";
    private static final String COL_6 = "Status";

    public DataBaseHelperToDo(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT, Task TEXT, Date TEXT, Description TEXT, Status INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void openDatabase(){
        db = this.getWritableDatabase();
    }

    public boolean insertTask(String task, String date, String desc, String title){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, title);
        values.put(COL_3, task);
        values.put(COL_4, date);
        values.put(COL_5, desc);
        values.put(COL_6, 0);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean updateTask(int id, String task, String date, String desc){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_3, task);
        values.put(COL_4, date);
        values.put(COL_5, desc);
        db.update(TABLE_NAME, null, "ID=?", new String[]{String.valueOf(id)});
        return true;
    }

    public Cursor getId(){
        db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT ID FROM table_todo", null);
        return res;

    }

    public void updateStatus(int id, int status){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_6, status);
        db.update(TABLE_NAME, values, "ID=?", new String[]{String.valueOf(id)});
    }

    public void deleteTask(int id){
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID=?", new String[]{String.valueOf(id)});
    }

    @SuppressLint("Range")
    public List<ToDo> getAllTask(){

        db = this.getWritableDatabase();
        Cursor cursor = null;
        List<ToDo> modelList = new ArrayList<>();

        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
            if(cursor != null){
                if (cursor.moveToFirst()){
                    do{
                        ToDo task = new ToDo();
                        task.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
                        task.setTitle(cursor.getString(cursor.getColumnIndex(COL_2)));
                        task.setTask(cursor.getString(cursor.getColumnIndex(COL_3)));
                        task.setDate(cursor.getString(cursor.getColumnIndex(COL_4)));
                        task.setDescription(cursor.getString(cursor.getColumnIndex(COL_5)));
                        task.setStatus(cursor.getInt(cursor.getColumnIndex(COL_6)));
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
