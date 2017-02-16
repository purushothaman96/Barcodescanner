package puru.com.barcodescanner;

import android.content.ContentValues;
import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by ADMIN PC on 1/8/2017.
 */
public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SEM";
    public static final String COL_4 = "MARKS";

    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY ,NAME TEXT,SEM TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
     db.execSQL("DROP TABLE IF EXITS"+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String id,String name,String sem,String marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,sem);
        contentValues.put(COL_4,marks);
       long result = db.insert(TABLE_NAME, null, contentValues);
        if(result== -1)
            return false;
        else return true;
    }
}























