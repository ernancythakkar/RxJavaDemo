package com.rxjavademo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.rxjavademo.R;
import com.rxjavademo.model.AlbumsResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {
    private ArrayList<AlbumsResponse> albumlist;
    private Context context;
    private Activity activity;

    public AlbumsAdapter(Activity activity, Context context, ArrayList<AlbumsResponse> albumlist) {
        this.albumlist = albumlist;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_albums, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (albumlist.get(i).getTitle()!=null) {
            viewHolder.tv_album_name.setText("Album Name : " + albumlist.get(i).getTitle());
        }else{
            viewHolder.tv_album_name.setText("Album Name : " + "");
        }
        if (albumlist.get(i).getUserId()!=null) {
            viewHolder.tv_userId.setText("User Id :" + albumlist.get(i).getUserId().toString());
        }else{
            viewHolder.tv_userId.setText("User Id :" + "");
        }

        viewHolder.rl_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(context, OfflineActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               // context.startActivity(intent);
               // activity.overridePendingTransition(R.anim.right_in, R.anim.right_out);
               // activity.finish();

            }
        });

    }

    @Override
    public int getItemCount() {
        return albumlist.size();
    }

    public void addAll(List<AlbumsResponse> mcList) {
        albumlist.addAll(mcList);
        notifyDataSetChanged();
    }

    public void clear() {
        albumlist.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_album_name)
        TextView tv_album_name;
        @BindView(R.id.tv_userId)
        TextView tv_userId;
        @BindView(R.id.rl_row)
        RelativeLayout rl_row;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }



}