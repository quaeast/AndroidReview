package bjfu.it.fangzidong.languageexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LanguageExpert languageExpert = new LanguageExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnFindLanguage(View view){
        Button button = (Button) view;
        Spinner spinner = findViewById(R.id.features);
        TextView textView = findViewById(R.id.result);
        String feature = spinner.getSelectedItem().toString();
        String language = languageExpert.getLanguage(feature);
        textView.setText(language);
    }
}
