package gt.edu.edutec.hostapp.firebase;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import gt.edu.edutec.hostapp.entities.Inmueble;
import gt.edu.edutec.hostapp.lib.base.EventBus;

public class FirebaseHelper {

    private Context context;
    private DatabaseReference reference;
    private FirebaseAuth mAuth;
    private EventBus bus;

    public FirebaseHelper(Context context, EventBus bus) {
        this.context = context;
        this.mAuth = FirebaseAuth.getInstance();
        this.reference = FirebaseDatabase.getInstance().getReference();
        this.bus = bus;
    }

    public void getUsuario(final FirebaseResut result){
        if (mAuth.getCurrentUser() != null){
            result.found(mAuth.getCurrentUser());
        }else{
            result.error("");
        }
    }

    public void getVenues(final FirebaseResut resut){
        reference.child("venues").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Inmueble> inmuebles = new ArrayList<Inmueble>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Inmueble inmueble = snapshot.getValue(Inmueble.class);
                    inmueble.setKey(snapshot.getKey());
                    inmuebles.add(inmueble);
                }
                resut.found(inmuebles);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                resut.error(databaseError.toException().getLocalizedMessage());
            }
        });
    }

    public void getVenue(String key, final FirebaseResut resut){
        reference.child("venues").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Inmueble inmueble = dataSnapshot.getValue(Inmueble.class);
                inmueble.setKey(dataSnapshot.getKey());
                resut.found(inmueble);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                resut.error(databaseError.toException().getLocalizedMessage());
            }
        });
    }
}
