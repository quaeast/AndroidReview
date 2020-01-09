package bjfu.it.fangzidong.bjfuclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ClassTitleActivity extends AppCompatActivity {

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_title);
        ListView listView = findViewById(R.id.second_class_list);

        CourseSQLHelper courseSQLHelper = new CourseSQLHelper(this);
        try (SQLiteDatabase db = courseSQLHelper.getReadableDatabase()){
            cursor = db.rawQuery("SELECT _id, Cname FROM CLASS", null);
            SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"Cname"},
                    new int[]{android.R.id.text1},
                    0);
            listView.setAdapter(simpleCursorAdapter);
        }

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClassTitleActivity.this, ClassActivity.class);
                intent.putExtra("message", (int)id);
                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(onItemClickListener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
    }
}
