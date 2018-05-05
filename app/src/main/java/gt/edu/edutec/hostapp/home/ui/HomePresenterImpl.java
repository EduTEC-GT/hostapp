package gt.edu.edutec.hostapp.home.ui;

import android.content.Context;

import org.greenrobot.eventbus.Subscribe;

import gt.edu.edutec.hostapp.general.Event;
import gt.edu.edutec.hostapp.general.Interactor;
import gt.edu.edutec.hostapp.general.ui.PresenterImpl;
import gt.edu.edutec.hostapp.general.ui.View;
import gt.edu.edutec.hostapp.home.HomeInteractor;
import gt.edu.edutec.hostapp.lib.base.EventBus;

public class HomePresenterImpl extends PresenterImpl implements HomePresenter {

    private HomeView homeView;
    private HomeInteractor homeInteractor;

    public HomePresenterImpl(EventBus bus, Context context, HomeView view, HomeInteractor interactor) {
        super(bus, context, view, interactor);
        this.homeInteractor = interactor;
        this.homeView = view;
    }

    @Override
    @Subscribe
    public void onEvent(Event event) {
        super.onEvent(event);
    }

    @Override
    public void moreOnEvent(Event event) {
        super.moreOnEvent(event);
    }
}
