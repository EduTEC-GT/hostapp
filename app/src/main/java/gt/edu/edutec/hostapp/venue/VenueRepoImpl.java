package gt.edu.edutec.hostapp.venue;

import android.content.Context;

import gt.edu.edutec.hostapp.firebase.FirebaseHelper;
import gt.edu.edutec.hostapp.firebase.FirebaseResut;
import gt.edu.edutec.hostapp.general.Event;
import gt.edu.edutec.hostapp.general.RepoImpl;
import gt.edu.edutec.hostapp.lib.base.EventBus;

public class VenueRepoImpl extends RepoImpl implements VenueRepo {

    public VenueRepoImpl(EventBus bus, Context context, FirebaseHelper helper) {
        super(bus, context, helper);
    }

    @Override
    public void getVenue(String key) {
        helper.getVenue(key, new FirebaseResut() {
            @Override
            public void found(Object o) {
                bus.post(new Event(Event.getVenue, o));
            }

            @Override
            public void error(String error) {
                bus.post(new Event(error));
            }

            @Override
            public void ok() {

            }
        });
    }
}
