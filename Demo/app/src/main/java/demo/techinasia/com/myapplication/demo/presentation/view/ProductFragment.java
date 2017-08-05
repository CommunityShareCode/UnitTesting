package demo.techinasia.com.myapplication.demo.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import demo.techinasia.com.myapplication.R;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.presentation.model.ProductRequest;
import demo.techinasia.com.myapplication.demo.presentation.presenter.GetTopSellingProductPresenter;
import demo.techinasia.com.myapplication.demo.presentation.view.adapter.AdapterClickListener;
import demo.techinasia.com.myapplication.demo.presentation.view.adapter.RecyclerViewAdapter;

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

public class ProductFragment extends Fragment implements
        GetTopSellingProductView,
        SwipeRefreshLayout.OnRefreshListener,
        AdapterClickListener<ProductRecommendation.Product> {

    @Inject
    RecyclerViewAdapter adapter;

    @Inject
    GetTopSellingProductPresenter mPresenter;

    @Inject
    ProductRequest mRequest;

    private RecyclerView rvProducts;

    private SwipeRefreshLayout refreshLayout;

    private Listener mListener;

    public static final ProductFragment newInstance() {

        ProductFragment fragment = new ProductFragment();

        return fragment;
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.fragment_product_list, container, false);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        final DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider));

        mPresenter.attachView(this);

        rvProducts = (RecyclerView) view.findViewById(R.id.product_list);
        rvProducts.addItemDecoration(divider);
        rvProducts.setHasFixedSize(true);
        rvProducts.setLayoutManager(layoutManager);
        rvProducts.setAdapter(adapter);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(this);

        adapter.setListener(this);

        return view;
    }

    @Override
    public void onDestroyView() {
        rvProducts = null;
        refreshLayout = null;

        mListener = null;

        mPresenter.detachView();

        super.onDestroyView();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        mPresenter.getProducts(mRequest);
    }

    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onProductAvailable(ProductRecommendation productRecommendation) {
        adapter.setList(productRecommendation.products);
    }

    @Override
    public void onProductNotAvailable() {
        adapter.getList().clear();
    }

    @Override
    public void onItemClicked(ProductRecommendation.Product model) {
        if (mListener != null) {
            mListener.onProductClicked(model);
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.getProducts(mRequest);
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

    public interface Listener {
        void onProductClicked(@NonNull final ProductRecommendation.Product product);
    }
}