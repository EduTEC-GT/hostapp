package gt.edu.edutec.hostapp;

import android.app.Application;

import gt.edu.edutec.hostapp.firebase.DI.FirebaseModule;
import gt.edu.edutec.hostapp.home.DI.DaggerHomeComponent;
import gt.edu.edutec.hostapp.home.DI.HomeComponent;
import gt.edu.edutec.hostapp.home.DI.HomeModule;
import gt.edu.edutec.hostapp.home.ui.HomeView;
import gt.edu.edutec.hostapp.lib.DI.LibsModule;
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
    public HomeComponent home(HomeView view){
        return DaggerHomeComponent.builder()
                .appModule(appModule)
                .libsModule(libsModule)
                .firebaseModule(firebaseModule)
                .homeModule(new HomeModule(view))
                .build();
    }
    //Inyection - FIN
}
