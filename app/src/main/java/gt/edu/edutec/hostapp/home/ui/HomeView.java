package gt.edu.edutec.hostapp.home.ui;

import java.util.List;

import gt.edu.edutec.hostapp.entities.Inmueble;
import gt.edu.edutec.hostapp.general.ui.View;

public interface HomeView extends View {
    void getVenues(List<Inmueble> inmuebles);
}
