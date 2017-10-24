package com.example.administrator.recyclerviewandcardview.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.recyclerviewandcardview.R;
import com.example.administrator.recyclerviewandcardview.model.Album;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/24/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{
    private Context context;

    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
        inflater = LayoutInflater.from(context);
    }

    private ArrayList<Album> albums;

    private LayoutInflater inflater;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_album,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album album = albums.get(position);
        Glide.with(context)
                .load(album.getResId())
                .into(holder.imgAlbum);
        holder.txtTileAlbum.setText(album.getName());
        holder.txtNumOfSong.setText(album.getNumberOfSong()+" songs ");
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAlbum;
        private TextView txtTileAlbum;
        private TextView txtNumOfSong;

        public ViewHolder(View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.img_album);
            txtTileAlbum = itemView.findViewById(R.id.txt_title_album);
            txtNumOfSong =  itemView.findViewById(R.id.txt_num_of_song);
        }
    }
}
