package gt.edu.edutec.hostapp;

import android.app.Application;

import gt.edu.edutec.hostapp.firebase.DI.FirebaseModule;
import gt.edu.edutec.hostapp.home.DI.DaggerHomeComponent;
import gt.edu.edutec.hostapp.home.DI.HomeComponent;
import gt.edu.edutec.hostapp.home.DI.HomeModule;
import gt.edu.edutec.hostapp.home.ui.HomeView;
import gt.edu.edutec.hostapp.home.ui.VenueClickListener;
import gt.edu.edutec.hostapp.lib.DI.LibsModule;
import gt.edu.edutec.hostapp.venue.DI.DaggerVenueComponent;
import gt.edu.edutec.hostapp.venue.DI.VenueComponent;
import gt.edu.edutec.hostapp.venue.DI.VenueModule;
import gt.edu.edutec.hostapp.venue.ui.VenueView;
/*
 * Created by javie on 11/28/2017.
 */

public class App extends Application {
    private AppModule appModule;
    private LibsModule libsModule;
    private FirebaseModule firebaseModule;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initModules();
    }

    private void initModules() {
        this.appModule = new AppModule(this);
        this.libsModule = new LibsModule();
        this.firebaseModule = new FirebaseModule();
    }

    public static synchronized App getInstance() {
        return instance;
    }

    public static String getUserSharedPreferences() {
        return "host-app";
    }

    //Inyeccion - INICIO
    public HomeComponent home(HomeView view, VenueClickListener listener){
        return DaggerHomeComponent.builder()
                .appModule(appModule)
                .libsModule(libsModule)
                .firebaseModule(firebaseModule)
                .homeModule(new HomeModule(view, listener))
                .build();
    }

    public VenueComponent venue(VenueView view){
        return DaggerVenueComponent.builder()
                .appModule(appModule)
                .libsModule(libsModule)
                .firebaseModule(firebaseModule)
                .venueModule(new VenueModule(view))
                .build();
    }
    //Inyection - FIN
}
