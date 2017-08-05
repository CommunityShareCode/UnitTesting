package demo.techinasia.com.myapplication.demo.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.presentation.ApplicationTestCase;
import demo.techinasia.com.myapplication.demo.presentation.view.Listener;

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

public class RecyclerViewAdapterTest extends ApplicationTestCase {

    private RecyclerViewAdapter mAdapter;

    @Before
    public void setUp() {
        mAdapter = new RecyclerViewAdapter() {
            @Override
            public void setListener(Listener listener) {

            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }
        };
    }

    @Test
    public void testSetList() {
        List list = new ArrayList();

        list.add(mock(Model.class));
        list.add(mock(Model.class));

        mAdapter.setList(list);

        Assert.assertEquals(2, mAdapter.getList().size());

        list.clear();

        list.add(mock(Model.class));
        list.add(mock(Model.class));
        list.add(mock(Model.class));

        mAdapter.setList(list);

        Assert.assertEquals(3, mAdapter.getList().size());
    }

    @Test
    public void testAppendList() {
        List list = new ArrayList();

        list.add(mock(Model.class));
        list.add(mock(Model.class));

        mAdapter.appendList(list);

        Assert.assertEquals(2, mAdapter.getList().size());

        list.clear();

        list.add(mock(Model.class));
        list.add(mock(Model.class));
        list.add(mock(Model.class));

        mAdapter.appendList(list);

        Assert.assertEquals(5, mAdapter.getList().size());
    }

    @Test
    public void testAppendListInPosition() {
        List list1 = new ArrayList();

        Model model1 = mock(Model.class);
        Model model2 = mock(Model.class);

        list1.add(model1);
        list1.add(model2);

        mAdapter.appendList(list1);

        List list2 = new ArrayList();

        Model model3 = mock(Model.class);
        Model model4 = mock(Model.class);

        list2.add(model3);
        list2.add(model4);

        mAdapter.appendList(1, list2);

        Assert.assertEquals(model1, mAdapter.getList().get(0));
        Assert.assertEquals(model3, mAdapter.getList().get(1));
        Assert.assertEquals(model4, mAdapter.getList().get(2));
        Assert.assertEquals(model2, mAdapter.getList().get(3));
    }

    @Test
    public void testAppendItem() {
        mAdapter.appendItem(mock(Model.class));

        Assert.assertEquals(1, mAdapter.getList().size());

        mAdapter.appendItem(mock(Model.class));

        Assert.assertEquals(2, mAdapter.getList().size());
    }

    @Test
    public void testAppendItemInPosition() {
        Model model1 = mock(Model.class);
        Model model2 = mock(Model.class);

        mAdapter.appendItem(model1);
        mAdapter.appendItem(0, model2);

        Assert.assertEquals(model2, mAdapter.getList().get(0));
        Assert.assertEquals(model1, mAdapter.getList().get(1));
    }

    @Test
    public void testRemoveItem() {
        Model model1 = mock(Model.class);
        Model model2 = mock(Model.class);

        mAdapter.appendItem(model1);
        mAdapter.appendItem(model2);

        mAdapter.removeItem(model2);

        Assert.assertEquals(1, mAdapter.getList().size());
    }

    @Test
    public void testRemoveItemInPosition() {
        Model model1 = mock(Model.class);
        Model model2 = mock(Model.class);

        mAdapter.appendItem(model1);
        mAdapter.appendItem(model2);

        mAdapter.removeItem(0);

        Assert.assertEquals(1, mAdapter.getList().size());
    }

    @Test
    public void testClearList() {
        Model model1 = mock(Model.class);
        Model model2 = mock(Model.class);

        mAdapter.appendItem(model1);
        mAdapter.appendItem(model2);

        mAdapter.clearList();

        Assert.assertEquals(0, mAdapter.getList().size());
    }

    @Test
    public void testGetItemCount() {
        Model model1 = mock(Model.class);
        Model model2 = mock(Model.class);

        mAdapter.appendItem(model1);
        mAdapter.appendItem(model2);

        Assert.assertEquals(2, mAdapter.getItemCount());
    }
}
