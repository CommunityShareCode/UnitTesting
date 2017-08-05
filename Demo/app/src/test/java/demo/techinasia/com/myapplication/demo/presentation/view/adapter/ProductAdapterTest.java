package demo.techinasia.com.myapplication.demo.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.presentation.ApplicationTestCase;
import demo.techinasia.com.myapplication.demo.presentation.view.ViewHolderFactory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
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

public class ProductAdapterTest extends ApplicationTestCase {
    private static final int ANY_TYPE = 0;

    @Test
    public void testOnCreateViewHolder() {
        final Map mockFactory = mock(HashMap.class);
        final ViewHolderFactory mockViewHolderFactory = mock(ViewHolderFactory.class);
        final View mockView = mock(View.class);

        final RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(mockView) {
            @Override
            public String toString() {
                return super.toString();
            }
        };

        final RecyclerView.ViewHolder spyViewHolder = spy(viewHolder);

        doReturn(mockViewHolderFactory).when(mockFactory).get(eq(ANY_TYPE));
        doReturn(spyViewHolder).when(mockViewHolderFactory).createViewHolder(any(ViewGroup.class));

        final ProductAdapter adapter = new ProductAdapter(mockFactory);

        RecyclerView.ViewHolder holder = adapter.onCreateViewHolder(mock(ViewGroup.class), ANY_TYPE);

        Assert.assertEquals(spyViewHolder, holder);
    }

    @Test
    public void testOnItemClicked() {
        final AdapterClickListener mockListener = mock(AdapterClickListener.class);
        final Map mockFactory = mock(HashMap.class);
        final RecyclerView.ViewHolder mockViewHolder = mock(RecyclerView.ViewHolder.class);
        final View mockView = mock(View.class);
        final List list = new ArrayList();

        list.add(mock(ProductRecommendation.Product.class));

        final ProductAdapter adapter = new ProductAdapter(mockFactory);

        doReturn(mockViewHolder).when(mockView).getTag();

        adapter.setList(list);
        adapter.setListener(mockListener);

        adapter.onClick(mockView);

        verify(mockListener).onItemClicked(any(Model.class));
    }
}
