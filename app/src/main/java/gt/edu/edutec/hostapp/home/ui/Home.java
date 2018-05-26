package gt.edu.edutec.hostapp.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import gt.edu.edutec.hostapp.App;
import gt.edu.edutec.hostapp.R;
import gt.edu.edutec.hostapp.entities.Inmueble;
import gt.edu.edutec.hostapp.general.ui.DrawableActivity;
import gt.edu.edutec.hostapp.lib.GlideImageLoader;
import gt.edu.edutec.hostapp.lib.base.ImageLoader;
import gt.edu.edutec.hostapp.util.ObjectSerializer;
import gt.edu.edutec.hostapp.venue.ui.VenueActivity;

public class Home extends DrawableActivity implements HomeView, VenueClickListener{


    @BindView(R.id.content_home)
    RelativeLayout content;
    @BindView(R.id.venue_list)
    RecyclerView venueList;

    @Inject
    ImageLoader imageLoader;
    @Inject
    HomePresenter presenter;
    @Inject
    VenueAdapter adapter;

    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        content.setVisibility(View.VISIBLE);
        injection();
        presenter.onCreate();
        setMenu(imageLoader, presenter);
        presenter.getVenues();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void injection() {
        app = (App) getApplication();
        app.home(this, this).inject(this);
        venueList.setLayoutManager(new LinearLayoutManager(this));
        venueList.setAdapter(adapter);
    }

    @Override
    public void getVenues(List<Inmueble> inmuebles) {
        adapter.setInmuebles(inmuebles);
    }

    @Override
    public void clicked(Inmueble inmueble) {
        startActivity(new Intent(this, VenueActivity.class)
        .putExtra(VenueActivity.key, inmueble.getKey()));
    }
}
