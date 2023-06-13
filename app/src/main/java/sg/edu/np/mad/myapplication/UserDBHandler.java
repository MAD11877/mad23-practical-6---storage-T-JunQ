package sg.edu.np.mad.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;


public class UserDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "UserDB.db";
    public static final String TABLE_USER = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_FOLLOWED = "isfollowed";

    public UserDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_USER +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_DESC + " TEXT,"
                + COLUMN_FOLLOWED + " INT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public void adduser(User user)
    {
        ContentValues values =  new ContentValues();
        values.put(COLUMN_USERNAME, user.name);
        values.put(COLUMN_DESC, user.description);
        values.put(COLUMN_FOLLOWED, user.followed);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USER, null,values);
        db.close();
    }

    public ArrayList<User> getUsers()
    {
        String query = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<User> userList = new ArrayList<>();
        if (cursor.moveToFirst())
        {
            do
            {
                userList.add(new User(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(0),
                        Boolean.parseBoolean(String.valueOf(cursor.getInt(3)))
                ));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }

    public void updateUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FOLLOWED, u.followed);
        db.update(TABLE_USER, values, "_id=?",new String[]{String.valueOf(u.id)});
        db.close();
    }

    public boolean deleteUser(String name)
    {
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + "= \"" + name + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User user = new User();

        if (cursor.moveToFirst())
        {
            user.id = (Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_USER, COLUMN_ID + " = ?", new String[] {String.valueOf(user.id)});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}



