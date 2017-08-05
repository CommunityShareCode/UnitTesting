package demo.techinasia.com.myapplication.demo.data.contract;

import demo.techinasia.com.myapplication.demo.data.model.TopSellingProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;

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

public interface ProductService {

    @GET("MerchandisingService?OPERATION-NAME=getTopSellingProducts&SERVICE-NAME=MerchandisingService&SERVICE-VERSION=1.5.0&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&maxResults=50")
    Call<TopSellingProductResponse> getTopSellingProducts();
}
