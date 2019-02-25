package com.example.yesiaplorina.projectsmultimedia;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    public VideoFragment() {
        // Required empty public constructor
    }

    VideoView video;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        video = view.findViewById(R.id.videoView);

        video.setVideoURI(Uri.parse("http://idn.id/semarang/tes/imastudio.3gp"));

        MediaController controller = new MediaController(getActivity());
        controller.setAnchorView(video);

        video.setMediaController(controller);
        video.requestFocus();
        video.start();


        return view;
    }

}
