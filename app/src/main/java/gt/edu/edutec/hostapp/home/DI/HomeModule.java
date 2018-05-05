package gt.edu.edutec.hostapp.home.DI;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import gt.edu.edutec.hostapp.firebase.FirebaseHelper;
import gt.edu.edutec.hostapp.home.HomeInteractor;
import gt.edu.edutec.hostapp.home.HomeInteractorImpl;
import gt.edu.edutec.hostapp.home.HomeRepo;
import gt.edu.edutec.hostapp.home.HomeRepoImpl;
import gt.edu.edutec.hostapp.home.ui.HomePresenter;
import gt.edu.edutec.hostapp.home.ui.HomePresenterImpl;
import gt.edu.edutec.hostapp.home.ui.HomeView;
import gt.edu.edutec.hostapp.lib.base.EventBus;

@Module
public class HomeModule {

    private HomeView view;

    public HomeModule(HomeView view) {
        this.view = view;
    }

    @Singleton
    @Inject
    HomeView providesHomeView(){
        return this.view;
    }

    @Singleton
    @Inject
    HomePresenter providesHomePresenter(EventBus bus, Context context, HomeView view, HomeInteractor interactor){
        return new HomePresenterImpl(bus, context, view, interactor);
    }

    @Singleton
    @Inject
    HomeInteractor providesHomeInteractor(EventBus bus, Context context, HomeRepo repo){
        return new HomeInteractorImpl(bus, context, repo);
    }

    @Singleton
    @Inject
    HomeRepo providesHomeRepo(EventBus bus, Context context, FirebaseHelper helper){
        return new HomeRepoImpl(bus, context, helper);
    }
}
