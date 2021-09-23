package com.rxjavademo.presenter;

import android.content.Context;
import android.util.Log;

import com.rxjavademo.model.AlbumsResponse;
import com.rxjavademo.network.ApiService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.HomeActionsListener{

    HomeContract.View view;
    ApiService apiService;
    CompositeDisposable disposable = new CompositeDisposable();

    public void init(HomeContract.View view, Context context) {
        this.view = view;

    }

    @Override
    public void getAlbums(ApiService apiService) {
        try {
            // do stream work here
            disposable.add(apiService.getAlbums().
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribeWith(new DisposableSingleObserver<List<AlbumsResponse>>() {
                        @Override
                        public void onSuccess(List<AlbumsResponse> data) {
                            Log.d("==()()()()()",data.toString());
                            view.success(data);
                            disposable.clear();

                        }
                        @Override
                        public void onError(Throwable e) {
                            Log.d("my error", e.getMessage());
                            view.error(e.getMessage());
                        }
                    }));

        } catch (Exception e){
            e.printStackTrace();

        }
    }
}

