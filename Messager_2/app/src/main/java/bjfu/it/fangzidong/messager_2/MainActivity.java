package bjfu.it.fangzidong.messager_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSend(View view){
        EditText input = (EditText) findViewById(R.id.input);
        String message = input.getText().toString();
        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}
