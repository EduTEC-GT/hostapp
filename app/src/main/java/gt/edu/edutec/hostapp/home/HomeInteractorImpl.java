package gt.edu.edutec.hostapp.home;

import android.content.Context;

import gt.edu.edutec.hostapp.general.InteractorImpl;
import gt.edu.edutec.hostapp.general.Repo;
import gt.edu.edutec.hostapp.lib.base.EventBus;

public class HomeInteractorImpl extends InteractorImpl implements HomeInteractor {

    private HomeRepo homeRepo;

    public HomeInteractorImpl(EventBus bus, Context context, HomeRepo repo) {
        super(bus, context, repo);
        this.homeRepo = repo;
    }

    @Override
    public void getVenues() {
        this.homeRepo.getVenues();
    }
}
