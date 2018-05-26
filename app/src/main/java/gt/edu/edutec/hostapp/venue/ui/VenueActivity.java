package gt.edu.edutec.hostapp.venue.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gt.edu.edutec.hostapp.App;
import gt.edu.edutec.hostapp.R;
import gt.edu.edutec.hostapp.entities.Inmueble;
import gt.edu.edutec.hostapp.general.ui.DrawableActivity;
import gt.edu.edutec.hostapp.lib.base.ImageLoader;

public class VenueActivity extends DrawableActivity implements VenueView {

    @BindView(R.id.content_venue)
    RelativeLayout content;

    @BindView(R.id.nombre_venue)
    TextView nombre;
    @BindView(R.id.imagen_venue)
    ImageView imagen;
    @BindView(R.id.direccion_venue)
    TextView direccion;
    @BindView(R.id.descripcion_venue)
    TextView descripcion;

    @Inject
    VenuePresenter presenter;
    @Inject
    ImageLoader imageLoader;

    private App app;
    private Inmueble inmueble;

    public final static String key = "KEY";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        content.setVisibility(View.VISIBLE);
        injection();
        presenter.onCreate();
        setMenu(imageLoader, presenter);
        presenter.getVenue(getIntent().getStringExtra(this.key));
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void injection() {
        app = (App) getApplication();
        app.venue(this).inject(this);
    }

    @Override
    public void getVenue(Inmueble inmueble) {
        this.inmueble = inmueble;
        nombre.setText(inmueble.getNombre());
        if(inmueble.getImage() != null && !inmueble.getImage().isEmpty()){
            imageLoader.load(imagen, inmueble.getImage());
        }
        descripcion.setText(inmueble.getDescripcion());
        direccion.setText(inmueble.getDireccion());
    }

    @OnClick(R.id.gps_venue)
    public void gpsVenue(){
        String uri = String.format(Locale.ENGLISH,
                "geo:%s,%s?q=%s,%s(%s)", this.inmueble.getLatitud(), this.inmueble.getLongitud(),
                this.inmueble.getLatitud(), this.inmueble.getLongitud(), nombre);
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)).setPackage("com.google.android.apps.maps"));
    }
}
