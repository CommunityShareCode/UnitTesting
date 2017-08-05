package demo.techinasia.com.myapplication.demo.data.model;

import java.util.ArrayList;
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

public class ProductRecommendation implements Model {

    public String ack;
    public String version;
    public String timestamp;

    public List<Product> products = new ArrayList<>();

        public static class Product implements Model {

            public String catalogName;
            public String imageUrl;
            public String url;
            public String priceRange;
            public String reviewCount;
            public String title;
            public String id;

            @Override
            public String toString() {
                return "Product{" +
                        "catalogName='" + catalogName + '\'' +
                        ", imageUrl='" + imageUrl + '\'' +
                        ", url='" + url + '\'' +
                        ", priceRange='" + priceRange + '\'' +
                        ", reviewCount='" + reviewCount + '\'' +
                        ", title='" + title + '\'' +
                        ", id='" + id + '\'' +
                        '}';
            }
        }

    @Override
    public String toString() {
        return "ProductRecommendation{" +
                "ack='" + ack + '\'' +
                ", version='" + version + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", products=" + products +
                '}';
    }
}
