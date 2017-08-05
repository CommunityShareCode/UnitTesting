package demo.techinasia.com.myapplication.demo.data.repository;

import junit.framework.Assert;

import org.junit.Test;

import demo.techinasia.com.myapplication.demo.data.datasource.TopSellingProductDataStore;
import demo.techinasia.com.myapplication.demo.data.datasource.TopSellingProductDataStoreFactory;
import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

public class TopSellingProductRepositoryImplTest {

    @Test
    public void testGetRequest() throws Exception {
        final TopSellingProductDataStoreFactory mockFactory = mock(TopSellingProductDataStoreFactory.class);
        final Model mockRequest = mock(Model.class);
        final TopSellingProductDataStore mockDataStore = mock(TopSellingProductDataStore.class);
        final ProductRecommendation mockRecommendation = mock(ProductRecommendation.class);

        doReturn(mockDataStore).when(mockFactory).getDataStore();
        doReturn(mockRecommendation).when(mockDataStore).getRequest(eq(mockRequest));

        TopSellingProductRepositoryImpl repository = new TopSellingProductRepositoryImpl(mockFactory);

        final ProductRecommendation result = repository.getRequest(mockRequest);

        Assert.assertEquals(mockRecommendation, result);
    }
}
