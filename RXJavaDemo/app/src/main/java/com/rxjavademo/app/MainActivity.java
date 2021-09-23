package com.rxjavademo.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rxjavademo.R;
import com.rxjavademo.adapter.AlbumsAdapter;
import com.rxjavademo.model.AlbumsResponse;
import com.rxjavademo.network.ApiClient;
import com.rxjavademo.network.ApiService;
import com.rxjavademo.presenter.HomeContract;
import com.rxjavademo.presenter.HomePresenter;
import com.rxjavademo.utils.CallProgressWheel;
import com.rxjavademo.utils.SharedPrefUtils;
import com.rxjavademo.utils.Util;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends RxJavaActivity implements HomeContract.View {

    RxJavaDemoApplication mApp;
    @Inject
    SharedPrefUtils<String> util;
    ApiService apiService;
    @Inject
    HomePresenter homePresenter;
    LinearLayoutManager mLayoutManager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_toolbar)
    TextView title_toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView  recyclerview;
    @BindView(R.id.no_data)
    TextView no_data;
    private ArrayList<AlbumsResponse> mAlbumsList = new ArrayList<>();
    AlbumsAdapter mAdapter;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mApp = ((RxJavaDemoApplication) this.getApplication());
        mApp.getHomeComponent().inject(this);
        homePresenter.init(this, this.getApplicationContext());
        apiService = ApiClient.getClient().create(ApiService.class);
        requestStoragePermission();
        setupLayout();
    }
    public void setupLayout(){
        title_toolbar.setVisibility(View.VISIBLE);
        title_toolbar.setText(getResources().getString(R.string.albums));
        recyclerview.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(mLayoutManager);
        activity = MainActivity.this;
        getAlbums();
    }
    private void getAlbums() {
        if (Util.isNetworkAvailable(MainActivity.this)) {
            CallProgressWheel.showLoadingDialog(MainActivity.this, "Loading..");
            homePresenter.getAlbums(apiService);
        } else {
          Util.showErrorMessageDialog(MainActivity.this, getResources().getString(R.string.error), getResources().getString(R.string.internet_message), () -> {
            });
        }
    }
    @Override
    public void success(List<AlbumsResponse> data) {
        if (CallProgressWheel.isDialogShowing()) {
            CallProgressWheel.dismissLoadingDialog();
        }
        mAlbumsList.clear();
        for (int i = 0; i < data.size(); i++) {

            mAlbumsList.add(data.get(i));

        }
        if(mAlbumsList.size()>0){
            recyclerview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);
            mAdapter = new AlbumsAdapter(activity,MainActivity.this, mAlbumsList);
            recyclerview.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } else {
            recyclerview.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void error(String message) {
        if(CallProgressWheel.isDialogShowing()){
            CallProgressWheel.dismissLoadingDialog();
        }
        Util.showErrorMessageDialog(MainActivity.this, getResources().getString(R.string.error),message.toString(), () -> {
        });
    }
}