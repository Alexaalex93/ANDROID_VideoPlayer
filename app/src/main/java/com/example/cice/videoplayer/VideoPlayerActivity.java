package com.example.cice.videoplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {

    String TAG = "VideoPlayer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        //PAra videos de Drive pondrias el uri para poder utilizarlo 
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4");

        //MediaController
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);


        //Listener
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Log.i(TAG, "Duracion = " + videoView.getDuration());
            }
        });
        videoView.start();
    }
}
