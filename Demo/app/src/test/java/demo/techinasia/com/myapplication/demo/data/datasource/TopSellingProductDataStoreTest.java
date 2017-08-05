package demo.techinasia.com.myapplication.demo.data.datasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import demo.techinasia.com.myapplication.demo.data.contract.ProductService;
import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.data.model.TopSellingProductResponse;
import retrofit2.Call;
import retrofit2.Response;

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

@RunWith(PowerMockRunner.class)
@PrepareForTest(Response.class)
public class TopSellingProductDataStoreTest {

    @Test
    public void testGetRequest() throws Exception {
        final ProductService mockService = mock(ProductService.class);
        final ApiToModelMapper mockMapper = mock(ApiToModelMapper.class);
        final Call mockCall = mock(Call.class);
        final Response mockResponse = mock(Response.class);
        final TopSellingProductResponse mockProductResponse = mock(TopSellingProductResponse.class);

        final TopSellingProductDataStore dataStore = new TopSellingProductDataStore(mockService, mockMapper);

        doReturn(mockCall).when(mockService).getTopSellingProducts();
        doReturn(mockResponse).when(mockCall).execute();
        doReturn(mockProductResponse).when(mockResponse).body();

        dataStore.getRequest(mock(Model.class));

        verify(mockService).getTopSellingProducts();
        verify(mockMapper).transform(eq(mockProductResponse));
    }
}
