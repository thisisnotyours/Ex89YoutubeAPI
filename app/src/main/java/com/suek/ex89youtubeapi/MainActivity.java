package com.suek.ex89youtubeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class MainActivity extends AppCompatActivity {

    //YoutubePlayerView 는 반드시 YoutubeBaseActivity 안에서만 보여짐
    //YoutubeBaseActivity 이 androidx. 를 사용한것이 아니라 그냥 Activity 를 받은것임
    //즉, androidx. 에 관련된 모든 작업이 불가!  getSupportActionbar.. etc 안됨
    YouTubePlayerView youTubeView;

    //YouTubePlayerFragment 를 사용하면 Fragment 가 Player 를 가지고 있기 때문에
    //YoutubeBaseActivity 안에서 사용하지 않아도 됨.
    // 유튜브뷰를 내부적으로 가지고있음
    YouTubePlayerFragment youTubeFragment;
    YouTubePlayerFragment youTubeFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //YouTubePlayerFragment 가 일반 Fragment 여서 Support 버전을 관리하는 getSupportFragment 를 사용할 수 없음.
        youTubeFragment= (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
        youTubeFragment.initialize("first", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("2uPlFwI6318");    //비디오 아이디
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });



        youTubeFragment2= (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment2);
        youTubeFragment2.initialize("second", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("ygtlUylfoy8");   //비디오 아이디   //https://www.youtube.com/watch?v=ygtlUylfoy8
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });



        YouTubeThumbnailView thumbnailView= findViewById(R.id.thumbview);
        thumbnailView.initialize("third", new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo("ygtlUylfoy8");   //유튜브 썸네일 이미지
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });










        /*youTubeView= findViewById(R.id.youtube_view);
        youTubeView.initialize("first", new YouTubePlayer.OnInitializedListener() {          //유튜브 주소를 받으려면 초기화를 먼저 시켜야함
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //youtubeview 는 그냥 액자이고, youtubePlayer 가 비디오주소를 가지고있음
                youTubePlayer.cueVideo("2uPlFwI6318");  //유튜브의 동영상 ID [https://www.youtube.com/watch?v=2uPlFwI6318    <-- v파라미터 값]
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });*/
    }





    public void clickBtn(View view) {
        startActivity(new Intent(this, YoutubeDataActivity.class));
    }
}
