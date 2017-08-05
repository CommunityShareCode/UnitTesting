package demo.techinasia.com.myapplication.demo.dependency.module;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import demo.techinasia.com.myapplication.demo.data.contract.ProductService;
import demo.techinasia.com.myapplication.demo.data.datasource.ApiToModelMapper;
import demo.techinasia.com.myapplication.demo.data.datasource.DataStore;
import demo.techinasia.com.myapplication.demo.data.datasource.TopSellingProductDataStore;
import demo.techinasia.com.myapplication.demo.data.datasource.TopSellingProductDataStoreFactory;
import demo.techinasia.com.myapplication.demo.data.datasource.TopSellingProductMapper;
import demo.techinasia.com.myapplication.demo.data.repository.TopSellingProductRepositoryImpl;
import demo.techinasia.com.myapplication.demo.domain.interactor.UseCase;
import demo.techinasia.com.myapplication.demo.domain.respository.Repository;
import demo.techinasia.com.myapplication.demo.presentation.presenter.GetTopSellingProductPresenter;
import demo.techinasia.com.myapplication.demo.presentation.presenter.GetTopSellingProductPresenterImpl;
import demo.techinasia.com.myapplication.demo.qualifier.FragmentScope;
import retrofit2.Retrofit;

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
public class GetTopSellingProductModule {

    @Provides
    @FragmentScope
    ApiToModelMapper provideTopSellingProductResponseMapper() {
        return new TopSellingProductMapper();
    }

    @Provides
    @FragmentScope
    DataStore provideTopSellingProductDataStore(ProductService service, ApiToModelMapper mapper) {
        return new TopSellingProductDataStore(service, mapper);
    }

    @Provides
    @FragmentScope
    Repository provideTopSellingProductRepository(TopSellingProductDataStoreFactory dataStoreFactory) {
        return new TopSellingProductRepositoryImpl(dataStoreFactory);
    }

    @Provides
    @FragmentScope
    UseCase provideGetTopSellingProductUseCase(
            Activity activity,
            Repository repository) {

        return new UseCase(activity, repository);
    }

    @Provides
    @FragmentScope
    GetTopSellingProductPresenter provideGetTopSellingProductPresenter(UseCase useCase, Activity activity) {
        return new GetTopSellingProductPresenterImpl(
                useCase,
                ((AppCompatActivity) activity).getSupportLoaderManager(),
                1);
    }
}
