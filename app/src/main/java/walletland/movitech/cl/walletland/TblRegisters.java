package walletland.movitech.cl.walletland;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TblRegisters extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = TblRegistersDefinition.Entry.TABLE_NAME+".db";

    public TblRegisters(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TblRegistersDefinition.Entry.TABLE_NAME;
        query += " ("+ TblRegistersDefinition.Entry.ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,";
        query += TblRegistersDefinition.Entry.NAME+" TEXT NULL,";
        query += TblRegistersDefinition.Entry.QUANTITY+" INTEGER NOT NULL,";
        query += TblRegistersDefinition.Entry.OPTION+" TEXT NOT NULL,";
        query += TblRegistersDefinition.Entry.DATETIME+" TEXT NULL,";
        query += TblRegistersDefinition.Entry.PLACE+" TEXT NULL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int insert(ContentValues values){
        SQLiteDatabase db = getReadableDatabase();
        db.insert(TblRegistersDefinition.Entry.TABLE_NAME, null, values);
        Cursor cursor = getAll();
        cursor.moveToLast();
        return cursor.getInt(cursor.getColumnIndexOrThrow(TblRegistersDefinition.Entry.ID));
    }

    public Cursor getAll(){
        SQLiteDatabase db = getReadableDatabase();
        String[] select = {
                TblRegistersDefinition.Entry.ID,
                TblRegistersDefinition.Entry.NAME,
                TblRegistersDefinition.Entry.QUANTITY,
                TblRegistersDefinition.Entry.OPTION,
                TblRegistersDefinition.Entry.DATETIME,
                TblRegistersDefinition.Entry.PLACE
        };
        Cursor cursor = db.query(TblRegistersDefinition.Entry.TABLE_NAME, select, null, null, null, null, null);
        return cursor;
    }

    public Cursor getAll(String option){
        SQLiteDatabase db = getReadableDatabase();
        String[] select = {
                TblRegistersDefinition.Entry.ID,
                TblRegistersDefinition.Entry.NAME,
                TblRegistersDefinition.Entry.QUANTITY,
                TblRegistersDefinition.Entry.OPTION,
                TblRegistersDefinition.Entry.DATETIME,
                TblRegistersDefinition.Entry.PLACE
        };
        String where = TblRegistersDefinition.Entry.OPTION + " = ?";
        Cursor cursor = db.query(TblRegistersDefinition.Entry.TABLE_NAME, select, where, new String[]{option}, null, null, null);
        return cursor;
    }

    public Integer getSum(String option){
        SQLiteDatabase db = getReadableDatabase();
        String q = "SELECT SUM("+TblRegistersDefinition.Entry.QUANTITY+") AS NUMBER FROM "+TblRegistersDefinition.Entry.TABLE_NAME;
        q += " WHERE "+TblRegistersDefinition.Entry.OPTION+" = '"+ option +"'";
        Cursor cursor = db.rawQuery(q, null);
        Integer out = 0;
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            out = cursor.getInt(cursor.getColumnIndexOrThrow("NUMBER"));
        }
        cursor.close();
        return out;
    }

}
