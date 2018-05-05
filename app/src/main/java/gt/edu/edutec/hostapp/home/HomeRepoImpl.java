package gt.edu.edutec.hostapp.home;

import android.content.Context;

import gt.edu.edutec.hostapp.firebase.FirebaseHelper;
import gt.edu.edutec.hostapp.general.RepoImpl;
import gt.edu.edutec.hostapp.general.Repo;
import gt.edu.edutec.hostapp.lib.base.EventBus;

public class HomeRepoImpl extends RepoImpl implements HomeRepo {
    public HomeRepoImpl(EventBus bus, Context context, FirebaseHelper helper) {
        super(bus, context, helper);
    }
}
