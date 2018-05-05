package gt.edu.edutec.hostapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        //addSlide(firstFragment);
        //addSlide(secondFragment);
        //addSlide(thirdFragment);
        //addSlide(fourthFragment);

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance("Bienvenido", "Bienvenido a HostApp", R.drawable.hostapp2, getResources().getColor(R.color.colorFondoIntro)));
        addSlide(AppIntroFragment.newInstance("HostApp", "Tu nueva App para busqueda de Inmuebles", R.drawable.hostapp3, getResources().getColor(R.color.colorFondoIntro)));
        addSlide(AppIntroFragment.newInstance("Encuentra rapido", "Local u Hogar, aqui lo encuentras", R.drawable.hostapp3, getResources().getColor(R.color.colorFondoIntro)));
        addSlide(AppIntroFragment.newInstance("Encuentra rapido", "Alquilas o Vendes, aqui debes anunciarte", R.drawable.hostapp2, getResources().getColor(R.color.colorFondoIntro)));


        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#4ba3c7"));
        setSeparatorColor(Color.parseColor("#8bf6ff"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}