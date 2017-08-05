package demo.techinasia.com.myapplication.demo.presentation.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;

import java.util.List;

import demo.techinasia.com.myapplication.R;
import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.presentation.ActivityStub;
import demo.techinasia.com.myapplication.demo.presentation.ApplicationTestCase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
public class ProductFragmentTest extends ApplicationTestCase {

    private static final String ANY_FRAGMENT_TAG = "1";

    private ProductFragment mFragment;

    @Before
    public void setUp() throws Exception {
        final ActivityStub mockActivity = Robolectric.setupActivity(ActivityStub.class);

        mFragment = ProductFragment.newInstance();

        mockActivity.getSupportFragmentManager().beginTransaction().add(mFragment, ANY_FRAGMENT_TAG).commit();
    }

    @Test
    public void testOnCreateView() {
        Assert.assertNotNull(mFragment);
        Assert.assertNotNull(mFragment.getView());
        Assert.assertNotNull(mFragment.getActivity());

        final View view = mFragment.getView();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.product_list);

        Assert.assertEquals(LinearLayoutManager.class, recyclerView.getLayoutManager().getClass());
        Assert.assertEquals(true, recyclerView.hasFixedSize());

        verify(mFragment.mPresenter).attachView(eq(mFragment));
        verify(mFragment.adapter).setListener(eq(mFragment));

        verify(mFragment.mPresenter).getProducts(any(Model.class));
    }

    @Test
    public void testOnDestroyView() {

        mFragment.onDestroyView();

        verify(mFragment.mPresenter).detachView();
    }

    @Test
    public void testShowLoading() {

        mFragment.showLoading();

        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) mFragment.getView().findViewById(R.id.refresh);

        Assert.assertEquals(true, refreshLayout.isRefreshing());
    }

    @Test
    public void testHideLoading() {

        mFragment.hideLoading();

        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) mFragment.getView().findViewById(R.id.refresh);

        Assert.assertEquals(false, refreshLayout.isRefreshing());
    }

    @Test
    public void testOnProductAvailable() {
        final ProductRecommendation mockProduct = mock(ProductRecommendation.class);

        mFragment.onProductAvailable(mockProduct);

        verify(mFragment.adapter).setList(eq(mockProduct.products));
    }

    @Test
    public void testOnProductNotAvailable() {
        final List mockList = mock(List.class);

        doReturn(mockList).when(mFragment.adapter).getList();

        mFragment.onProductNotAvailable();

        verify(mockList).clear();
    }

    @Test
    public void testOnRefresh() {
        mFragment.onRefresh();

        verify(mFragment.mPresenter, times(2)).getProducts(any(Model.class));
    }
}
