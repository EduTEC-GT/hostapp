package gt.edu.edutec.hostapp.general.ui;


import gt.edu.edutec.hostapp.general.Event;

public interface Presenter {
    void onCreate();
    void onDestroy();
    void getUsuario();
    void onEvent(Event event);
    void moreOnEvent(Event event);
}
