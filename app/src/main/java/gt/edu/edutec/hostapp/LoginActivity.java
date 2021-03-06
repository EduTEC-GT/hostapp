package gt.edu.edutec.hostapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import gt.edu.edutec.hostapp.home.ui.Home;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private static final int RC_SIGN_IN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() == null){
            AuthUI.SignInIntentBuilder intentBuilder = AuthUI.getInstance().createSignInIntentBuilder()
                    .setAvailableProviders(getProviders())
                    .setIsSmartLockEnabled(false);
            Intent intent = intentBuilder.build();
            startActivityForResult(intent, RC_SIGN_IN);
        }else{
            startActivity(new Intent(this, Home.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|
                            Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    public List<AuthUI.IdpConfig> getProviders() {
        List<AuthUI.IdpConfig> providers = new ArrayList<AuthUI.IdpConfig>();
        providers.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        providers.add(new AuthUI.IdpConfig.FacebookBuilder().build());

        return providers;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Log.e("SIGN_IN_OK", String.valueOf(auth.getCurrentUser().getUid()));
                startActivity(new Intent(this, Home.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|
                        Intent.FLAG_ACTIVITY_NEW_TASK));
            }else{
                Log.e("SIGN_IN_FAIL", String.valueOf(data.getDataString()));
            }
        }
    }
}
