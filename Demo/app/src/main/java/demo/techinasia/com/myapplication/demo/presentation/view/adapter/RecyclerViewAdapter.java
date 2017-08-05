package demo.techinasia.com.myapplication.demo.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.presentation.view.Listener;
import demo.techinasia.com.myapplication.demo.presentation.view.viewholder.BaseViewHolder;

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

public abstract class RecyclerViewAdapter<T extends Listener, E extends Model, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private final List<E> mItems = new ArrayList<>();

    public abstract void setListener(T listener);

    public void setList(List list) {
        mItems.clear();
        mItems.addAll(list);

        notifyDataSetChanged();
    }

    public void appendList(List list) {
        mItems.addAll(list);

        notifyDataSetChanged();
    }

    public void appendList(int position, List list) {
        mItems.addAll(position, list);

        notifyItemInserted(position);
    }

    public void appendItem(E item) {
        int lastIndex = mItems.size();

        mItems.add(item);

        notifyItemInserted(lastIndex);
    }

    public void appendItem(int position, E item) {
        mItems.add(position, item);

        notifyItemInserted(position);
    }

    public void removeItems(List list) {
        mItems.remove(list);

        notifyDataSetChanged();
    }

    public void removeItem(E item) {
        int deletedIndex = 0;

        for (Object selectedItem : mItems) {

            if (selectedItem == item) {
                break;
            }

            deletedIndex++;
        }

        mItems.remove(item);

        notifyItemRemoved(deletedIndex);
    }

    public void removeItem(int position) {
        mItems.remove(position);

        notifyItemRemoved(position);
    }

    public void clearList() {
        mItems.clear();

        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder) holder).onBindViewHolder(getList().get(position));
    }

    public List<E> getList() {
        return mItems;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}

