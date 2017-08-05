package demo.techinasia.com.myapplication.demo.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;

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

public class ProductActivity extends AppCompatActivity implements
        HasSupportFragmentInjector,
        ProductFragment.Listener {

    @Inject
    DispatchingAndroidInjector<Fragment> mDispatchingFragmentInjector;

    private ProductFragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mFragment = (ProductFragment) getSupportFragmentManager().findFragmentById(android.R.id.content);

        } else {
            mFragment = ProductFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(android.R.id.content, mFragment)
                    .commit();
        }

        mFragment.setListener(this);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mDispatchingFragmentInjector;
    }

    @Override
    public void onProductClicked(@NonNull ProductRecommendation.Product product) {
        final Intent intent = new Intent(this, ProductDetailActivity.class);

        intent.putExtra(ProductDetailActivity.TITLE, product.title);
        intent.putExtra(ProductDetailActivity.URL, product.url);

        startActivity(intent);
    }
}
