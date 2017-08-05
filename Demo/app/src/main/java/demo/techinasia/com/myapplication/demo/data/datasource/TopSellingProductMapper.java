package demo.techinasia.com.myapplication.demo.data.datasource;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

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

public class TopSellingProductMapper implements ApiToModelMapper<ProductRecommendation, TopSellingProductResponse> {

    @Override
    @CheckResult
    @NonNull
    public ProductRecommendation transform(final @NonNull TopSellingProductResponse response) {

        final ProductRecommendation productRecommendation = new ProductRecommendation();

        productRecommendation.ack = response.topSellingProductResponse.ack;
        productRecommendation.timestamp = response.topSellingProductResponse.timestamp;
        productRecommendation.version = response.topSellingProductResponse.version;

        for (TopSellingProductResponse.Response.ProductRecommendation.Product productResponse : response.topSellingProductResponse.productRecommendation.products) {
            final ProductRecommendation.Product product = new ProductRecommendation.Product();

            product.id = productResponse.productId.value;
            product.catalogName = productResponse.catalogName;
            product.imageUrl = productResponse.imageUrl;
            product.title = productResponse.title;
            product.reviewCount = productResponse.reviewCount;
            product.url = productResponse.productUrl;

            product.priceRange =
                    productResponse.priceRangeMin.currencyId + " " + productResponse.priceRangeMin.value
                    + " - "
                    + productResponse.priceRangeMax.currencyId + " " + productResponse.priceRangeMax.value;

            productRecommendation.products.add(product);

        }

        return productRecommendation;
    }
}
