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
        Assert.assertEquals("1.5.0", productRecommendation.version);
        Assert.assertEquals("2017-08-05T02:08:161.004Z", productRecommendation.timestamp);

        Assert.assertEquals("eBay", product.catalogName);
        Assert.assertEquals("http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/WWwAAOSwiONYLavl/$_6.JPG?set_id=89040003C1", product.imageUrl);
        Assert.assertEquals("USD 552.95 - USD 575.95", product.priceRange);
        Assert.assertEquals("223384827", product.id);
        Assert.assertEquals("http://www.ebay.com/ctg/Canon-PowerShot-G7-X-Mark-II-20-1MP-Digital-Camera-Black/223384827", product.url);
        Assert.assertEquals("Canon PowerShot G7 X Mark II 20.1MP Digital Camera - Black", product.title);
        Assert.assertEquals("0", product.reviewCount);
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
