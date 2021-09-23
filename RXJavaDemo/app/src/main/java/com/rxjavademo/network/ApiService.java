package com.rxjavademo.network;


import com.rxjavademo.model.AlbumsResponse;
import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;


/**
 * API endpoint retrofit definition
 */
public interface ApiService {

    @GET("albums")
    Single<List<AlbumsResponse>> getAlbums();

}

