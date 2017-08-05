package demo.techinasia.com.myapplication.demo.data.model;

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

    @JsonProperty("getTopSellingProductsResponse")
    public Response topSellingProductResponse;

    public static class Response {

        @JsonProperty("productRecommendations")
        public ProductRecommendation productRecommendation;

        @JsonProperty("ack")
        public String ack;

        @JsonProperty("version")
        public String version;

        @JsonProperty("timestamp")
        public String timestamp;

        public static class ProductRecommendation {

            @JsonProperty("product")
            public List<Product> products;

            public static class Product {

                @JsonProperty("catalogName")
                public String catalogName;

                @JsonProperty("imageURL")
                public String imageUrl;

                @JsonProperty("priceRangeMax")
                public PriceRange priceRangeMax;

                @JsonProperty("priceRangeMin")
                public PriceRange priceRangeMin;

                @JsonProperty("productId")
                public ProductId productId;

                @JsonProperty("productURL")
                public String productUrl;

                @JsonProperty("reviewCount")
                public String reviewCount;

                @JsonProperty("title")
                public String title;

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

                public static class ProductId {

                    @JsonProperty("@type")
                    public String type;

                    @JsonProperty("__value__")
                    public String value;

                    @Override
                    public String toString() {
                        return "ProductId{" +
                                "type='" + type + '\'' +
                                ", value='" + value + '\'' +
                                '}';
                    }
                }

                @Override
                public String toString() {
                    return "Product{" +
                            "catalogName='" + catalogName + '\'' +
                            ", imageUrl='" + imageUrl + '\'' +
                            ", priceRangeMax=" + priceRangeMax +
                            ", priceRangeMin=" + priceRangeMin +
                            ", url='" + productUrl + '\'' +
                            ", reviewCount='" + reviewCount + '\'' +
                            ", title='" + title + '\'' +
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
