package demo.techinasia.com.myapplication.demo.data.datasource;

import android.support.annotation.NonNull;

import java.io.IOException;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.data.model.Response;
import demo.techinasia.com.myapplication.demo.data.model.TopSellingProductResponse;
import demo.techinasia.com.myapplication.demo.data.contract.ProductService;
import retrofit2.Call;

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

public class TopSellingProductDataStore implements CloudDataStore<Model, ProductRecommendation> {

    private final ProductService mService;
    private final ApiToModelMapper<ProductRecommendation, Response> mMapper;

    public TopSellingProductDataStore(
            @NonNull final ProductService service,
            @NonNull final ApiToModelMapper mapper) {

        mService = service;
        mMapper = mapper;
    }

    @Override
    public ProductRecommendation getRequest(Model request) throws IOException {
        final Call<TopSellingProductResponse> call = mService.getTopSellingProducts();

        final TopSellingProductResponse response = call.execute().body();

        return mMapper.transform(response);
    }
}
