package demo.techinasia.com.myapplication.demo.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.presentation.view.ViewHolderFactory;

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

public class ProductAdapter extends RecyclerViewAdapter<AdapterClickListener, ProductRecommendation.Product, RecyclerView.ViewHolder> implements View.OnClickListener {

    private final Map<Integer, ViewHolderFactory> mViewHolderFactories;

    private AdapterClickListener mListener;

    public ProductAdapter(Map<Integer, ViewHolderFactory> viewHolderFactories) {
        mViewHolderFactories = viewHolderFactories;
    }

    @Override
    public void setListener(AdapterClickListener listener) {
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = mViewHolderFactories.get(viewType).createViewHolder(parent);

        viewHolder.itemView.setTag(viewHolder);

        viewHolder.itemView.setOnClickListener(this);

        return viewHolder;
    }

    public void onClick(android.view.View v) {
        if (v.getTag() instanceof RecyclerView.ViewHolder && mListener != null) {
            final RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            final int position = viewHolder.getAdapterPosition();

            if (position > -1) {
                ProductRecommendation.Product contact = getList().get(position);

                mListener.onItemClicked(contact);
            }
        }
    }
}


