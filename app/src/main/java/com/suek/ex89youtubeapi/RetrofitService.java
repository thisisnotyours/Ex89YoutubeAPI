package com.suek.ex89youtubeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    //요청 파라미터 : key(필수), part(필수), q(검색어), maxResults(결과개수: 0~50개)
    @GET("/youtube/v3/search")    //@GET 안에 상세주소   //https://www.googleapis.com/youtube/v3/search
    Call<String> searchVideos(@Query("key") String key,
                              @Query("part") String part,
                              @Query("q") String q,
                              @Query("maxResults") int maxResults);
}
