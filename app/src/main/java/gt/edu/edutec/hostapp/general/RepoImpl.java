package gt.edu.edutec.hostapp.general;

import android.content.Context;

import gt.edu.edutec.hostapp.firebase.FirebaseHelper;
import gt.edu.edutec.hostapp.firebase.FirebaseResut;
import gt.edu.edutec.hostapp.lib.base.EventBus;

public class RepoImpl implements Repo {

    public EventBus bus;
    public Context context;
    public FirebaseHelper helper;

    public RepoImpl(EventBus bus, Context context, FirebaseHelper helper) {
        this.bus = bus;
        this.context = context;
        this.helper = helper;
    }

    @Override
    public void getUsuario() {
        helper.getUsuario(new FirebaseResut() {
            @Override
            public void found(Object o) {
                bus.post(new Event(Event.getUsuario, o));
            }

            @Override
            public void error(String error) {
                bus.post(new Event(Event.forcedLogout));
            }

            @Override
            public void ok() {

            }
        });
    }
}
