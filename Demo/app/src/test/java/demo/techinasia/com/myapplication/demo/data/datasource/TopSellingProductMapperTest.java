package demo.techinasia.com.myapplication.demo.data.datasource;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import demo.techinasia.com.myapplication.demo.TestHelper;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.data.model.TopSellingProductResponse;

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

public class TopSellingProductMapperTest {

    @Test
    public void testTransform() throws Exception {
        final TopSellingProductResponse topSellingProductResponse = mockResponse();

        final TopSellingProductMapper mapper = new TopSellingProductMapper();

        final ProductRecommendation productRecommendation = mapper.transform(topSellingProductResponse);

        final List<ProductRecommendation.Product> products = productRecommendation.products;

        final ProductRecommendation.Product product = products.get(0);

        Assert.assertEquals("Success", productRecommendation.ack);
        Assert.assertEquals("1.1.0", productRecommendation.version);
        Assert.assertEquals("2018-01-02T05:01:986.027Z", productRecommendation.timestamp);

        Assert.assertEquals("Apple iPhone 5S 16GB \"Factory Unlocked\" 4G LTE iOS Smartphone", product.catalogName);
        Assert.assertEquals("http://thumbs.ebaystatic.com/d/l140/m/mZV7qvI0ZoeQMQSqD3t1fKA.jpg", product.imageUrl);
        Assert.assertEquals("USD 137.95", product.price);
        Assert.assertEquals("361122672377", product.id);
        Assert.assertEquals("https://www.ebay.com/itm/Apple-iPhone-5S-16GB-Factory-Unlocked-4G-LTE-iOS-Smartphone/361122672377?_trkparms=mehot%3Dpp%26&_trksid=p0", product.url);

    }

    @CheckResult
    @NonNull
    private TopSellingProductResponse mockResponse() throws IOException {

        final String fileName = "getTopSellingProducts_json_200_ok.json";

        final String jsonFile = TestHelper.getFileFromResource(this, fileName);

        final ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonFile, TopSellingProductResponse.class);
    }
}
