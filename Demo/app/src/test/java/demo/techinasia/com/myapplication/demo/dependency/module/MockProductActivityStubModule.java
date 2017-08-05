package demo.techinasia.com.myapplication.demo.dependency.module;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import demo.techinasia.com.myapplication.demo.dependency.component.MockProductActivityStubSubComponent;
import demo.techinasia.com.myapplication.demo.presentation.ActivityStub;

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

@Module(subcomponents = MockProductActivityStubSubComponent.class)
public abstract class MockProductActivityStubModule {

    @Binds
    @IntoMap
    @ActivityKey(ActivityStub.class)
    abstract AndroidInjector.Factory<? extends Activity> bindActivityInjectorFactory(MockProductActivityStubSubComponent.Builder builder);

}
