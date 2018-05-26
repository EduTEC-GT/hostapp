package gt.edu.edutec.hostapp.venue.DI;

import javax.inject.Singleton;

import dagger.Component;
import gt.edu.edutec.hostapp.AppModule;
import gt.edu.edutec.hostapp.firebase.DI.FirebaseModule;
import gt.edu.edutec.hostapp.lib.DI.LibsModule;
import gt.edu.edutec.hostapp.venue.ui.VenueActivity;

@Singleton
@Component(modules = {AppModule.class, LibsModule.class, FirebaseModule.class, VenueModule.class})
public interface VenueComponent {
    void inject(VenueActivity activity);
}
