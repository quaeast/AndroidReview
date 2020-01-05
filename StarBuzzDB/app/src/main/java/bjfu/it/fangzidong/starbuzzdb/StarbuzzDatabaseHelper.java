package bjfu.it.fangzidong.starbuzzdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Locale;

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz.db";
    private static final int DB_VERSION = 1;

    public StarbuzzDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "DESCRIPTION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER);");

        Drink[] drinks = Drink.drinks;
        for (Drink drink : drinks) {
            db.execSQL(String.format(Locale.ENGLISH, "INSERT INTO DRINK (NAME, DESCRIPTION, IMAGE_RESOURCE_ID) VALUES ('%s','%s',%d);",
                    drink.getName(), drink.getDescription(), drink.getImageID()));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
