package gt.edu.edutec.hostapp.entities;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.Date;

@IgnoreExtraProperties
public class Inmueble implements Serializable {
    private String key;
    private String nombre;
    private String latitud;
    private String longitud;
    private String image;
    private String descripcion;
    private String direccion;

    public Inmueble() {
    }

    public Inmueble(String nombre, String latitud, String longitud, String image, String descripcion, String direccion) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.image = image;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}