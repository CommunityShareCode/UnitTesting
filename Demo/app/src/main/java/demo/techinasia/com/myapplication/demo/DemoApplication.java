package demo.techinasia.com.myapplication.demo;

import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import demo.techinasia.com.myapplication.demo.dependency.component.AppComponent;
import demo.techinasia.com.myapplication.demo.dependency.component.DaggerAppComponent;
import demo.techinasia.com.myapplication.demo.dependency.module.AppModule;
import demo.techinasia.com.myapplication.demo.dependency.module.NetworkModule;

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

public class DemoApplication extends Application implements HasActivityInjector {

    /**
     * Replace this with your EBAY_CONSUMER_ID, please visit:
     * https://developer.ebay.com
     * to get your id
     */
    private static final String EBAY_CONSUMER_ID = "0";

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        NetworkModule networkModule = new NetworkModule("http://svcs.ebay.com/", EBAY_CONSUMER_ID);

        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        DaggerDemoComponent.builder()
                .appComponent(appComponent)
                .networkModule(networkModule)
                .build()
                .inject(this);

        if ("0".equals(EBAY_CONSUMER_ID)) {
            Toast.makeText(this, "Please replace EBAY_CONSUMER_ID", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
