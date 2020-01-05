package bjfu.it.fangzidong.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        int pos =  intent.getIntExtra("message", 0);
        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);
        ImageView image = findViewById(R.id.coffe_image);
        Drink drink = new Drink();
        name.setText(drink.drinks[pos].getName());
        description.setText(drink.drinks[pos].getDescription());
        image.setImageResource(drink.drinks[pos].getImageResourceId());
    }
}
