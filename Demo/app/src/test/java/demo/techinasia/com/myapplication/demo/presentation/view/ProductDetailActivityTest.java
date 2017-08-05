package demo.techinasia.com.myapplication.demo.presentation.view;

import android.content.Intent;
import android.webkit.WebView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;

import demo.techinasia.com.myapplication.R;
import demo.techinasia.com.myapplication.demo.presentation.ApplicationTestCase;

import static org.robolectric.Shadows.shadowOf;

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

public class ProductDetailActivityTest extends ApplicationTestCase {

    private ProductDetailActivity mActivity;

    @Before
    public void setUp() throws Exception {

        final Intent intent = new Intent();

        intent.putExtra(ProductDetailActivity.TITLE, "Any Title");
        intent.putExtra(ProductDetailActivity.URL, "http://any.url");

        mActivity = Robolectric.buildActivity(ProductDetailActivity.class, intent)
                .create()
                .start()
                .visible()
                .get();
    }

    @Test
    public void testOnCreate() {

        Assert.assertNotNull(mActivity);

        final WebView webView = (WebView) mActivity.findViewById(R.id.web_view);

        Assert.assertEquals("Any Title", mActivity.getSupportActionBar().getTitle());
        Assert.assertEquals("http://any.url", shadowOf(webView).getLastLoadedUrl());
    }
}
