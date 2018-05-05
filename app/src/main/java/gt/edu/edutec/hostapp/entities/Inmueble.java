package gt.edu.edutec.hostapp.entities;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.Date;

@IgnoreExtraProperties
public class Inmueble implements Serializable {
    private String key;
    private String nombre;
}