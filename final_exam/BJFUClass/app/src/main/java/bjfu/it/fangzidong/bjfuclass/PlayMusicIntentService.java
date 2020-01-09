package bjfu.it.fangzidong.bjfuclass;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;

import androidx.annotation.Nullable;


public class PlayMusicIntentService extends IntentService {


    public PlayMusicIntentService() {
        super("PlayMusicIntentService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.notice);
        mediaPlayer.start();
    }
}
