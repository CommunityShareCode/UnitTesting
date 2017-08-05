package demo.techinasia.com.myapplication.demo.dependency.module;

import dagger.Module;
import dagger.Provides;
import demo.techinasia.com.myapplication.demo.presentation.presenter.GetTopSellingProductPresenter;
import demo.techinasia.com.myapplication.demo.qualifier.FragmentScope;

import static org.mockito.Mockito.mock;

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

@Module
public class MockGetTopSellingProductModule {

    @Provides
    @FragmentScope
    GetTopSellingProductPresenter provideGetTopSellingProductPresenter() {
        return mock(GetTopSellingProductPresenter.class);
    }
}

