package packs.firstpack.pr;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class DBConnect extends SQLiteOpenHelper {

    private static String DBName ="findUser";
    private static int DBVersion =1;
    private static String dbtable="user";

   // private static String id="id";
    private static String emailAddress="email";
    private static String password="password";
    private static String name ="name";
    private static String birth ="Birth";

    SQLiteDatabase db =this.getWritableDatabase();

    public DBConnect(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query ="create table "+dbtable+
                " ( "//integer primary key autoincrement, "
                +name +" text, "
                +emailAddress+" text, "
                + password+" text, "
        +birth+ " text )" ;
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+dbtable);
        onCreate(sqLiteDatabase);
    }

    public void addUser(User user) {

        ContentValues values = new ContentValues();
        values.put(name,user.getName());
        values.put(emailAddress,user.getEmailAddress());
        values.put(password,user.getPassword());
        values.put(birth,user.getBirthDay());
        db.insert(dbtable,null,values);
        db.close();
    }
}
