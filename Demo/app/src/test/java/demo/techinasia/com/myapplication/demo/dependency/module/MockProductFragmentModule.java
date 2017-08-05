package demo.techinasia.com.myapplication.demo.dependency.module;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import demo.techinasia.com.myapplication.demo.presentation.view.ProductFragment;
import demo.techinasia.com.myapplication.demo.dependency.component.MockProductFragmentSubComponent;

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

@Module(subcomponents = MockProductFragmentSubComponent.class)
public abstract class MockProductFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(ProductFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindFragmentInjectorFactory(MockProductFragmentSubComponent.Builder builder);

}
