package gt.edu.edutec.hostapp.firebase.DI;

import javax.inject.Singleton;

import dagger.Component;
import gt.edu.edutec.hostapp.AppModule;
import gt.edu.edutec.hostapp.lib.DI.LibsModule;

/**
 * Created by javie on 11/12/2017.
 */
@Singleton
@Component(modules = {AppModule.class, LibsModule.class, FirebaseModule.class})
public interface FirebaseComponent {
}
