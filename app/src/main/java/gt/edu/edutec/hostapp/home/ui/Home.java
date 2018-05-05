package gt.edu.edutec.hostapp.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import gt.edu.edutec.hostapp.App;
import gt.edu.edutec.hostapp.R;
import gt.edu.edutec.hostapp.entities.Inmueble;
import gt.edu.edutec.hostapp.general.ui.DrawableActivity;
import gt.edu.edutec.hostapp.lib.GlideImageLoader;
import gt.edu.edutec.hostapp.lib.base.ImageLoader;
import gt.edu.edutec.hostapp.util.ObjectSerializer;

public class Home extends DrawableActivity implements HomeView{

    @Inject
    ImageLoader imageLoader;
    @Inject
    HomePresenter presenter;

    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        injection();
        presenter.onCreate();
        ArrayList<Inmueble> list = new ArrayList<>();
        try {
            new Intent().putExtra("lista", ObjectSerializer.serialize(list));
            ArrayList<Inmueble> lista2 = (ArrayList<Inmueble>) ObjectSerializer.deserialize(getIntent()
            .getStringExtra("lista"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        setMenu(imageLoader, presenter);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void injection() {
        app = (App) getApplication();
        app.home(this).inject(this);
    }
}
