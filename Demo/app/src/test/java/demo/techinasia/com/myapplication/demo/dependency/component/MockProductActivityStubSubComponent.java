package demo.techinasia.com.myapplication.demo.dependency.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import demo.techinasia.com.myapplication.demo.qualifier.ActivityScope;
import demo.techinasia.com.myapplication.demo.dependency.module.MockProductFragmentModule;
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

@ActivityScope
@Subcomponent(modules = MockProductFragmentModule.class)
public interface MockProductActivityStubSubComponent extends AndroidInjector<ActivityStub> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ActivityStub> {}

}
