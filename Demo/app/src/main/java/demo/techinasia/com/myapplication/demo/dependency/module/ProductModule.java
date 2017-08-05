package demo.techinasia.com.myapplication.demo.dependency.module;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import demo.techinasia.com.myapplication.demo.data.contract.ProductService;
import demo.techinasia.com.myapplication.demo.presentation.view.ViewHolderFactory;
import demo.techinasia.com.myapplication.demo.presentation.view.adapter.ProductAdapter;
import demo.techinasia.com.myapplication.demo.presentation.view.adapter.RecyclerViewAdapter;
import demo.techinasia.com.myapplication.demo.presentation.view.viewholder.ProductViewHolderFactory;
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
public class ProductModule {

    @Provides
    ProductService provideProductService(Retrofit retrofit) {
        return retrofit.create(ProductService.class);
    }

    @Provides
    RecyclerViewAdapter provideProductListAdapter(Map<Integer, ViewHolderFactory> viewHolderFactories) {
        return new ProductAdapter(viewHolderFactories);
    }

    @Provides
    @IntoMap
    @IntKey(0)
    ViewHolderFactory provideProductViewHolder() {
        return new ProductViewHolderFactory();
    }
}
