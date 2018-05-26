package gt.edu.edutec.hostapp.venue.ui;

import android.content.Context;

import org.greenrobot.eventbus.Subscribe;

import gt.edu.edutec.hostapp.entities.Inmueble;
import gt.edu.edutec.hostapp.general.Event;
import gt.edu.edutec.hostapp.general.Interactor;
import gt.edu.edutec.hostapp.general.ui.PresenterImpl;
import gt.edu.edutec.hostapp.general.ui.View;
import gt.edu.edutec.hostapp.lib.base.EventBus;
import gt.edu.edutec.hostapp.venue.VenueInteractor;

public class VenuePresenterImpl extends PresenterImpl implements VenuePresenter {

    private VenueView venueView;
    private VenueInteractor venueInteractor;

    public VenuePresenterImpl(EventBus bus, Context context, VenueView view, VenueInteractor interactor) {
        super(bus, context, view, interactor);
        this.venueInteractor = interactor;
        this.venueView = view;
    }

    @Override
    @Subscribe
    public void onEvent(Event event) {
        super.onEvent(event);
    }

    @Override
    public void moreOnEvent(Event event) {
        switch (event.getTipo()){
            case Event.getVenue:
                venueView.getVenue((Inmueble) event.getObject());
                break;
        }
    }


    @Override
    public void getVenue(String key) {
        view.loading(true);
        venueInteractor.getVenue(key);
    }
}
