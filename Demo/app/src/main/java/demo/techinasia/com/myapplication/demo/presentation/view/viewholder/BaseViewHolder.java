package demo.techinasia.com.myapplication.demo.presentation.view.viewholder;

import android.support.v7.widget.RecyclerView;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.presentation.view.Listener;

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

public abstract class BaseViewHolder<T extends Model, E extends Listener> extends RecyclerView.ViewHolder {

    public BaseViewHolder(android.view.View itemView) {
        super(itemView);
    }

    public abstract void onBindViewHolder(T model);

    public abstract void setListener(E listener);
}
