package bjfu.it.fangzidong.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onPressSendMessage(View view){
        EditText input = findViewById(R.id.input);
        String inputString =  input.getText().toString();
        Intent intent = new Intent(StartActivity.this, ReceiveMessageActivity.class);
        intent.putExtra("message", inputString);
        startActivity(intent);
    }
}
