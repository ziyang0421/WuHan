package com.example.wuhan;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundMusicService extends Service {
    private MediaPlayer mediaPlayer;    // MediaPlayer对象

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // 以下是用户重写的部分
    @Override
    public void onStart(Intent intent,int startId){
        super.onStart(intent, startId);

        if(mediaPlayer==null){
            // R.raw.bgmusic是资源文件，MP3格式的
            // java/res/raw
            mediaPlayer = MediaPlayer.create(this, R.raw.honor);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }
}
