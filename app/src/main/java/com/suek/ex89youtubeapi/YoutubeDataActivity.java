package com.suek.ex89youtubeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class YoutubeDataActivity extends AppCompatActivity {

    EditText et;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_data);

        et= findViewById(R.id.et);
        tv= findViewById(R.id.tv);
    }


    //검색버튼을 누르면
    public void clickSearch(View view) {
        //Youtube Data API 사용
        // 검색기능 API 는 REST 방식으로 데이터(json)를 제공
        // GET https://www.googleapis.com/youtube/v3/search
        //요청 파라미터 : key(필수), part(필수), q(검색어), maxResults(결과개수: 0~50개)
        String key= "AIzaSyAhg2AjdIlR7s_9hRIrvwzLC0TGEjk9iuw";    //API 키
        String part= "snippet";
        String query= et.getText().toString();  //q
        int maxResults= 10;

        //Retrofit 을 쓰되- 결과를 우선은 String 으로 받기 --> 연습할때는 json 으로..
        Retrofit retrofit= RetrofitHelper.getInstance();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);

        Call<String> call= retrofitService.searchVideos(key, part, query, maxResults);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data= response.body();
                tv.setText(data);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}
