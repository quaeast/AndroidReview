package bjfu.it.fangzidong.starbuzzdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageView caffeView = findViewById(R.id.caffe_logo);
        TextView caffeName = findViewById(R.id.caffe_name);
        TextView caffeDex = findViewById(R.id.caffe_description);
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        Log.v("hahaha", id+"");
        StarbuzzDatabaseHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try (SQLiteDatabase sqLiteDatabase = starbuzzDatabaseHelper.getReadableDatabase()){
            cursor = sqLiteDatabase.rawQuery("SELECT * FROM DRINK WHERE _id="+id, null);
            cursor.moveToFirst();
            Log.v("3_id", cursor.getColumnCount()+"");
            Log.v("hahaha", cursor.getString(1));
            caffeView.setImageResource(cursor.getInt(3));
            caffeName.setText(cursor.getString(1));
            caffeDex.setText(cursor.getString(2));
        }
    }
}
