package demo.techinasia.com.myapplication.demo.presentation.view.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import demo.techinasia.com.myapplication.R;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.presentation.ApplicationTestCase;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

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

public class ProductViewHolderTest extends ApplicationTestCase {

    @Test
    public void testOnBindViewHolder() {

        final ViewGroup stubViewGroup = new ViewGroup(RuntimeEnvironment.application) {
            @Override
            protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

            }
        };

        final ProductRecommendation.Product mockProduct = mock(ProductRecommendation.Product.class);

        final ProductViewHolder viewHolder = new ProductViewHolder(stubViewGroup);

        mockProduct.title = "Any Title";
        mockProduct.priceRange = "Any Range";

        viewHolder.onBindViewHolder(mockProduct);

        final TextView tvTitle = (TextView) viewHolder.itemView.findViewById(R.id.product_title);
        final TextView tvPriceRange = (TextView) viewHolder.itemView.findViewById(R.id.product_price);

        Assert.assertEquals("Any Title", tvTitle.getText().toString());
        Assert.assertEquals("Any Range", tvPriceRange.getText().toString());
    }
}
