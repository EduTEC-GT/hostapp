package gt.edu.edutec.hostapp.venue.DI;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gt.edu.edutec.hostapp.firebase.FirebaseHelper;
import gt.edu.edutec.hostapp.lib.base.EventBus;
import gt.edu.edutec.hostapp.venue.VenueInteractor;
import gt.edu.edutec.hostapp.venue.VenueInteractorImpl;
import gt.edu.edutec.hostapp.venue.VenueRepo;
import gt.edu.edutec.hostapp.venue.VenueRepoImpl;
import gt.edu.edutec.hostapp.venue.ui.VenuePresenter;
import gt.edu.edutec.hostapp.venue.ui.VenuePresenterImpl;
import gt.edu.edutec.hostapp.venue.ui.VenueView;

@Module
public class VenueModule {
    private VenueView venueView;

    public VenueModule(VenueView venueView) {
        this.venueView = venueView;
    }

    @Singleton
    @Provides
    VenueView providesVenueView(){
        return this.venueView;
    }

    @Singleton
    @Provides
    VenuePresenter providesVenuePresenter(EventBus bus, Context context, VenueView view, VenueInteractor interactor){
        return new VenuePresenterImpl(bus, context, view, interactor);
    }

    @Singleton
    @Provides
    VenueInteractor providesVenueInteractor(EventBus bus, Context context, VenueRepo repo){
        return new VenueInteractorImpl(bus, context, repo);
    }

    @Singleton
    @Provides
    VenueRepo providesVenueRepo(EventBus bus, Context context, FirebaseHelper helper){
        return new VenueRepoImpl(bus, context, helper);
    }

}
