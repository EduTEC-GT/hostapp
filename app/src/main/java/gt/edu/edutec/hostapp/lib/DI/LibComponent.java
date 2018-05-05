package gt.edu.edutec.hostapp.lib.DI;

import javax.inject.Singleton;

import dagger.Component;
import gt.edu.edutec.hostapp.AppModule;

/**
 * Created by javie on 11/12/2017.
 */
@Singleton
@Component(modules = {AppModule.class, LibsModule.class})
public interface LibComponent {
}
