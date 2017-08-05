package demo.techinasia.com.myapplication.demo.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import demo.techinasia.com.myapplication.R;

import static android.view.View.SCROLLBARS_INSIDE_OVERLAY;

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

public class ProductDetailActivity extends AppCompatActivity {

    public static final String TITLE = "intent.title";
    public static final String URL = "intent.url";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_detail);

        final Intent intent = getIntent();

        final String title = intent.getStringExtra(TITLE);
        final String url = intent.getStringExtra(URL);

        final WebView webView = (WebView) findViewById(R.id.web_view);

        webView.setFocusableInTouchMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setScrollBarStyle(SCROLLBARS_INSIDE_OVERLAY);

        getSupportActionBar().setTitle(title);

        webView.loadUrl(url);
    }
}
