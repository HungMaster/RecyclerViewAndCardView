package com.example.administrator.recyclerviewandcardview;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.recyclerviewandcardview.model.Album;
import com.example.administrator.recyclerviewandcardview.view.AlbumAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvAlbum;
    private AlbumAdapter albumAdapter;
    private ArrayList<Album> albums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        setupAlbum();

        rcvAlbum = findViewById(R.id.rcv_albums);
        albumAdapter = new AlbumAdapter(this,albums);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        rcvAlbum.setLayoutManager(layoutManager);
        rcvAlbum.setItemAnimator(new DefaultItemAnimator());
        rcvAlbum.setAdapter(albumAdapter);

        Glide.with(this)
                .load(R.drawable.album_main)
                .into((ImageView) findViewById(R.id.img_album_main));

    }

    private void setupAlbum() {
        albums = new ArrayList<>();
        albums.add(new Album("WestLife",30,R.drawable.album1));
        albums.add(new Album("Adele",25,R.drawable.album2));
        albums.add(new Album("Taylor Swift",20,R.drawable.album3));
        albums.add(new Album("Justin Bieber",30,R.drawable.album4));
        albums.add(new Album("BackStreetBoy",30,R.drawable.album5));
        albums.add(new Album("Maroon5",30,R.drawable.album6));
        albums.add(new Album("Shayne Ward",30,R.drawable.album7));
        albums.add(new Album("Rihanna",30,R.drawable.album8));
        albums.add(new Album("Charlie Puth",30,R.drawable.album9));
        albums.add(new Album("Alan Walker",30,R.drawable.album11));
        albums.add(new Album("Alan Walker",30,R.drawable.album12));
        albums.add(new Album("Alan Walker",30,R.drawable.album13));
        albums.add(new Album("Alan Walker",30,R.drawable.album14));
        albums.add(new Album("Alan Walker",30,R.drawable.album15));
        albums.add(new Album("Alan Walker",30,R.drawable.album16));
        albums.add(new Album("Alan Walker",30,R.drawable.album17));
        albums.add(new Album("Alan Walker",30,R.drawable.album18));
        albums.add(new Album("Alan Walker",30,R.drawable.album19));
        albums.add(new Album("Alan Walker",30,R.drawable.album20));
        albums.add(new Album("Alan Walker",30,R.drawable.album21));
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("");
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            int scollRange = -1;
            boolean isShow = false;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scollRange==-1){
                    scollRange = appBarLayout.getTotalScrollRange();
                }
                if (scollRange+verticalOffset==0){
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                }
                else if(isShow){
                    collapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });
    }
}
