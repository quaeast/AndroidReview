package bjfu.it.fangzidong.starbuzzdb;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

import androidx.annotation.Nullable;

public class PlayMusicService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public PlayMusicService() {
        super("playMusicService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.notice);
        mediaPlayer.start();
        Log.v("my_music", "play");
    }
}
