package gt.edu.edutec.hostapp.venue;

import android.content.Context;

import gt.edu.edutec.hostapp.R;
import gt.edu.edutec.hostapp.general.Event;
import gt.edu.edutec.hostapp.general.InteractorImpl;
import gt.edu.edutec.hostapp.general.Repo;
import gt.edu.edutec.hostapp.lib.base.EventBus;

public class VenueInteractorImpl extends InteractorImpl implements VenueInteractor {

    private VenueRepo venueRepo;

    public VenueInteractorImpl(EventBus bus, Context context, VenueRepo repo) {
        super(bus, context, repo);
        venueRepo = repo;
    }

    @Override
    public void getVenue(String key) {
        if (key != null && !key.isEmpty()){
            venueRepo.getVenue(key);
        }else{
            bus.post(new Event(context.getString(R.string.key_invalid)));
        }
    }
}
