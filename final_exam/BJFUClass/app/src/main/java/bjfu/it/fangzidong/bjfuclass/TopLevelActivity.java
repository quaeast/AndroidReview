package bjfu.it.fangzidong.bjfuclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TopLevelActivity extends AppCompatActivity {

    Cursor cursor;
    private static String nameNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        ListView schoolList = findViewById(R.id.top_school_list);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(TopLevelActivity.this, ClassTitleActivity.class);
                    startActivity(intent);
                }
            }
        };
        schoolList.setOnItemClickListener(onItemClickListener);

        EditText editText = findViewById(R.id.top_name_input);
        editText.setText(nameNo);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        EditText editText = findViewById(R.id.top_name_input);
        nameNo= editText.getText().toString();
        Log.v("1top", nameNo);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<String> res = getName();
        Log.v("1res", res.size()+"");
        ArrayAdapter<String> favoriteArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                res);
        ListView favoriteList = findViewById(R.id.top_favorite_list);
        favoriteList.setAdapter(favoriteArrayAdapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView textView = (TextView) view;
//                Log.v("1top", ((TextView) view).getText().toString());
//                Intent intent = new Intent(TopLevelActivity.this, ClassActivity.)
            }
        };
    }

    private List<String> getName(){
        CourseSQLHelper courseSQLHelper = new CourseSQLHelper(this);
        List<String> res = new ArrayList<>();
        try (SQLiteDatabase db = courseSQLHelper.getReadableDatabase()){
            cursor = db.rawQuery("SELECT Cname FROM CLASS ORDER BY _id", null);
            cursor.moveToFirst();
            int i=1;
            while (!cursor.isAfterLast()){
                if (Favourite.content[i]){
                    res.add(cursor.getString(0));
                }
                i++;
                cursor.moveToNext();
            }
        }
        return res;
    }

    public void onPressPlayMusic(View view){
        Intent intent = new Intent(TopLevelActivity.this, PlayMusicIntentService.class);
        startService(intent);
    }
}
