package bjfu.it.fangzidong.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        TextView textView = findViewById(R.id.second_output);
        Intent intent = getIntent();
        String message =(String) intent.getExtras().get("message");
        Log.v("message", message);
        textView.setText(message);
    }
}
