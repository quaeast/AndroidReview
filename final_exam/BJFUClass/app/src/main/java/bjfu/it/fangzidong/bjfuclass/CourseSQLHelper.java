package bjfu.it.fangzidong.bjfuclass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CourseSQLHelper extends SQLiteOpenHelper {

    private static final String name = "CourseDB.db";
    private static final int version = 1;

    public CourseSQLHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CLASS(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Cname TEXT," +
                "Cdesc TEXT," +
                "Cpic INTEGER);");
        db.execSQL("INSERT INTO CLASS(Cname, Cdesc, Cpic)" +
                "VALUES('Android','Android的App遵循MVC架构，对象分为模型、视图和控制器三类，控制Model如何显示在View\n" +
                "根据View的输入更新Model Android使用Activity定义App的行为，" +
                "显示控件及布局约束的组合 Android使用Layout定义App的外观，" +
                "Android使用Java数组、 SQLite数据库存储App的数据', " +
                R.drawable.android+
                ");");
        db.execSQL("INSERT INTO CLASS(Cname, Cdesc, Cpic)" +
                "VALUES('Database','1. 新建和管理数据库。2. 接入数据库。3. 读写数据库', " +
                R.drawable.screencut+
                ");");
        db.execSQL("INSERT INTO CLASS(Cname, Cdesc, Cpic)" +
                "VALUES('JAVA','Java 是安卓开的最初的编程语言，是纯面向对象的。" +
                "kotlin 是一中全新的多范式编程语言由jetbrains 开发，谷歌推广，是现在安卓开发的趋势。', " +
                R.drawable.java+
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
