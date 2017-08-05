package demo.techinasia.com.myapplication.demo.data.repository;

import android.support.annotation.NonNull;

import java.io.IOException;

import demo.techinasia.com.myapplication.demo.data.datasource.TopSellingProductDataStoreFactory;
import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.domain.respository.Repository;

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

public class TopSellingProductRepositoryImpl implements Repository<ProductRecommendation, Model> {

    private final TopSellingProductDataStoreFactory mFactory;

    public TopSellingProductRepositoryImpl(@NonNull TopSellingProductDataStoreFactory factory) {
        mFactory = factory;
    }

    @Override
    public ProductRecommendation getRequest(Model request) throws IOException {
        return mFactory.getDataStore().getRequest(request);
    }
}
