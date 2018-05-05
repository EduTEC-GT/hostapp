package gt.edu.edutec.hostapp.home.DI;

import javax.inject.Singleton;

import dagger.Component;
import gt.edu.edutec.hostapp.AppModule;
import gt.edu.edutec.hostapp.firebase.DI.FirebaseModule;
import gt.edu.edutec.hostapp.home.ui.Home;
import gt.edu.edutec.hostapp.lib.DI.LibsModule;

@Singleton
@Component(modules = {AppModule.class, LibsModule.class, FirebaseModule.class, HomeModule.class})
public interface HomeComponent {
    void inject(Home home);
}
