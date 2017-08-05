package demo.techinasia.com.myapplication.demo.presentation.view;

import android.content.Intent;
import android.support.v4.app.Fragment;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;

import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.presentation.ApplicationTestCase;

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
public class ProductActivityTest extends ApplicationTestCase {

    private ProductActivity mActivity;

    @Before
    public void setUp() throws Exception {

        mActivity = Robolectric.buildActivity(ProductActivity.class)
                .create()
                .start()
                .visible()
                .get();
    }

    @Test
    public void testOnCreate() {
        final Fragment fragment = mActivity.getSupportFragmentManager().findFragmentById(android.R.id.content);

        Assert.assertNotNull(mActivity);
        Assert.assertNotNull(fragment);
    }

    @Test
    public void testOnProductClicked() {
        final ProductRecommendation.Product mockProduct = mock(ProductRecommendation.Product.class);

        mockProduct.title = "Any Title";
        mockProduct.url = "http://any.url";

        final ShadowActivity shadowActivity = Shadows.shadowOf(mActivity);

        mActivity.onProductClicked(mockProduct);

        Intent expectedIntent = shadowActivity.peekNextStartedActivity();

        Assert.assertEquals("Any Title", expectedIntent.getExtras().getString(ProductDetailActivity.TITLE));
        Assert.assertEquals("http://any.url", expectedIntent.getExtras().getString(ProductDetailActivity.URL));
        Assert.assertEquals(ProductDetailActivity.class.getCanonicalName(), expectedIntent.getComponent().getClassName());
    }
}
