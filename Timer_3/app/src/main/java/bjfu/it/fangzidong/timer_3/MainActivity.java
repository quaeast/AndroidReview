package bjfu.it.fangzidong.timer_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    int second = 0;
    boolean isRunning = false;
    boolean wasRunning = false;

    private void TimeIncrease(){
        final Handler handler = new Handler();
        final TextView time = findViewById(R.id.time_show);
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning){
                    second++;
                }
                int hour = second/3600;
                int min = (second%3600)/60;
                int sec = (second%3600)%60;
                String timeToShow = String.format("%d:%02d:%02d", hour, min, sec);
                time.setText(timeToShow);
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("second", second);
        outState.putBoolean("isRunning", isRunning);
        outState.putBoolean("wasRunning", wasRunning);
        Log.v("hahaha", "save   ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            second = savedInstanceState.getInt("second");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        Log.v("hahaha", "create");
        TimeIncrease();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("hahaha", "Resume");
        isRunning=wasRunning;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("hahaha", "Pause");
        wasRunning=isRunning;
        isRunning=false;
    }

    public void pressStart(View view){
        isRunning=true;
    }

    public void pressStop(View view){
        isRunning=false;
    }

    public void pressReset(View view){
        isRunning=false;
        second=0;
    }
}


/*
可以省略 onStart() 和 onStop(), 只写 OnResume() 和 OnPause()
但是不可以省略 wasRunning，否则在切换后台的时候秒表不会停止
 */