package bjfu.it.fangzidong.bjfuclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassActivity extends AppCompatActivity {

    Cursor cursor;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        CourseSQLHelper courseSQLHelper = new CourseSQLHelper(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("message", 0);
        Log.v("3_id", id+"");
        try (SQLiteDatabase db = courseSQLHelper.getReadableDatabase()){
            cursor = db.rawQuery("SELECT Cname, Cdesc,Cpic FROM CLASS WHERE _id="+id, null);
            TextView nameOutput = findViewById(R.id.third_course_name);
            TextView descOutput = findViewById(R.id.third_course_desc);
            ImageView imageView = findViewById(R.id.third_pic);
            cursor.moveToFirst();
            nameOutput.setText(cursor.getString(0));
            descOutput.setText(cursor.getString(1));
            imageView.setImageResource(cursor.getInt(2));
        }

        CheckBox isFavorite = findViewById(R.id.is_favorite);
        isFavorite.setChecked(Favourite.content[id]);

    }

    public void onIsFavoriteOnChecked(View view){
        CheckBox isFavorite = (CheckBox) view;
        TextView name = findViewById(R.id.third_course_name);
        if (isFavorite.isChecked()){
            Favourite.content[id]=true;
        }else {
            Favourite.content[id]=false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
    }
}
