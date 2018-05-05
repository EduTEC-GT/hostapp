package gt.edu.edutec.hostapp.general;

import java.io.Serializable;

public class Event implements Serializable {

    public final static int getUsuario = 0;
    public final static int forcedLogout = 1;
    public final static int listadoInmueble = 2;

    private int tipo;
    private String error;
    private String mensaje;
    private Object object;

    public Event() {
    }

    public Event(int tipo) {
        this.tipo = tipo;
    }

    public Event(int tipo, String mensaje) {
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public Event(int tipo, Object object) {
        this.tipo = tipo;
        this.object = object;
    }

    public Event(int tipo, String mensaje, Object object) {
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.object = object;
    }

    public Event(String error) {
        this.error = error;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
