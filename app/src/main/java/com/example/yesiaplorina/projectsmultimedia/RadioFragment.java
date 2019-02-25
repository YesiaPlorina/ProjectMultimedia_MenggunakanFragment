package com.example.yesiaplorina.projectsmultimedia;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment {


    public RadioFragment() {
        // Required empty public constructor
    }

    ProgressBar progress;
    Button btnPlay, btnStop;
    MediaPlayer player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_radio, container, false);
        progress = view.findViewById(R.id.progressBar);
        btnPlay = view.findViewById(R.id.btn_play);
        btnStop = view.findViewById(R.id.btn_stop);

        //menyembunyikan progresbar

        progress.setVisibility(View.INVISIBLE);
        progress.setIndeterminate(true);

        btnStop.setVisibility(View.GONE);

        //untuk menjalankan
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.VISIBLE);
                btnPlay.setVisibility(View.GONE);

                player = new MediaPlayer();
                try {
                    player.setDataSource("http://gajahmada.i.streaming.id:8000/live");
                    //tambah
                    player.prepareAsync();
                    player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            player.start();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.GONE);
                btnPlay.setVisibility(View.VISIBLE);

                try {
                    if (player.isPlaying()) {
                        player.stop();
                        player.release();
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

}
