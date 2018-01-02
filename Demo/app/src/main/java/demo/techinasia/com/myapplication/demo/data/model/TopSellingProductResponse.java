package demo.techinasia.com.myapplication.demo.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

public class TopSellingProductResponse implements Response {

    @JsonProperty("getMostWatchedItemsResponse")
    public Response topSellingProductResponse;

    public static class Response {

        @JsonProperty("itemRecommendations")
        public ProductRecommendation productRecommendation;

        @JsonProperty("ack")
        public String ack;

        @JsonProperty("version")
        public String version;

        @JsonProperty("timestamp")
        public String timestamp;

        public static class ProductRecommendation {

            @JsonProperty("item")
            public List<Product> products;

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Product {

                @JsonProperty("title")
                public String catalogName;

                @JsonProperty("imageURL")
                public String imageUrl;

                @JsonProperty("buyItNowPrice")
                public PriceRange buyItNowPrice;

                @JsonProperty("itemId")
                public String productId;

                @JsonProperty("viewItemURL")
                public String productUrl;

                public static class PriceRange {

                    @JsonProperty("@currencyId")
                    public String currencyId;

                    @JsonProperty("__value__")
                    public Double value;

                    @Override
                    public String toString() {
                        return "PriceRange{" +
                                "currencyId='" + currencyId + '\'' +
                                ", value=" + value +
                                '}';
                    }
                }

                @Override
                public String toString() {
                    return "Product{" +
                            "catalogName='" + catalogName + '\'' +
                            ", imageUrl='" + imageUrl + '\'' +
                            ", buyItNowPrice=" + buyItNowPrice +
                            ", productId='" + productId + '\'' +
                            ", productUrl='" + productUrl + '\'' +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "ProductRecommendation{" +
                        "products=" + products +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "TopSellingProductResponse{" +
                    "productRecommendation=" + productRecommendation +
                    ", ack='" + ack + '\'' +
                    ", version='" + version + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "topSellingProductResponse=" + topSellingProductResponse +
                '}';
    }
}
