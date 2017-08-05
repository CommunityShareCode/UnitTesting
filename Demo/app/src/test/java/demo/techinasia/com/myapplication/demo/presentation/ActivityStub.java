package demo.techinasia.com.myapplication.demo.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import demo.techinasia.com.myapplication.R;

/**
 * Created by fandygotama on 8/5/17.
 * With special thanks to (Alphabetical Order):
 * - Aldy Chrissandy (Indonesia),
 * - Antoni Tirta Riady (Indonesia),
 * - Arman Hendra Harnanda (Indonesia),
 * - Jessa Cahilig (Philippines),
 * - Remerico Cruz (Philippines),
 * - Steven Lewi (Indonesia),
 * For being great teams and excellent collaborators, and
 * also to Rendra Toro for being our Manager.
 * OLX SEA MOBILE APPS TEAM 2016, YOU GUYS ARE AWESOME!!
 */

public class ActivityStub extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> mDispatchingFragmentInjector;

    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        AndroidInjection.inject(this);

        setTheme(R.style.Theme_AppCompat_Light_DarkActionBar);

        super.onCreate(onSavedInstanceState);
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mDispatchingFragmentInjector;
    }
}
