package gt.edu.edutec.hostapp.general.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import gt.edu.edutec.hostapp.LoginActivity;
import gt.edu.edutec.hostapp.R;
import gt.edu.edutec.hostapp.home.ui.Home;
import gt.edu.edutec.hostapp.lib.base.ImageLoader;

public class DrawableActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.loader)
    public ProgressBar loader;
    private ImageLoader imgLoader;
    private Presenter gPresenter;

    public void setMenu(ImageLoader imgLoader,  Presenter gPresenter){
        this.imgLoader = imgLoader;
        this.gPresenter = gPresenter;
        gPresenter.getUsuario();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getHeaderView(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_inicio:
                startActivity(new Intent(this, Home.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK
                        |Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK
                                |Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void loading(boolean load) {
        loader.setVisibility(load ? android.view.View.VISIBLE : android.view.View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadUser(FirebaseUser user) {
        android.view.View header = (android.view.View) navigationView.getHeaderView(0);
        TextView nombre = (TextView) header.findViewById(R.id.nombre);
        TextView email = (TextView) header.findViewById(R.id.email);
        CircleImageView avatar = (CircleImageView) header.findViewById(R.id.avatar);
        nombre.setText(user.getDisplayName());
        email.setText(user.getEmail());
        this.imgLoader.load(avatar, user.getPhotoUrl().toString());
    }

    @Override
    public void forcedLogout() {
        /*startActivity(new Intent(this, LoginActivity.class).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|
                        Intent.FLAG_ACTIVITY_NEW_TASK
        ));*/
    }
}
