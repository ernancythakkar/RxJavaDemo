package com.rxjavademo.presenter;


import com.rxjavademo.model.AlbumsResponse;
import com.rxjavademo.network.ApiService;

import java.util.List;

public class HomeContract {
    public interface View {
        void success(List<AlbumsResponse> data);
        void error(String message);

    }

    public interface HomeActionsListener {
        // processing to be done here
        void getAlbums(ApiService apiService);
    }
}
