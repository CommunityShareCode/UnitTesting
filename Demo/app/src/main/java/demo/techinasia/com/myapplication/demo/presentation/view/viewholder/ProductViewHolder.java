package demo.techinasia.com.myapplication.demo.presentation.view.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.auto.factory.AutoFactory;

import demo.techinasia.com.myapplication.R;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.presentation.view.Listener;
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
@AutoFactory(implementing = ViewHolderFactory.class)
public class ProductViewHolder extends BaseViewHolder<ProductRecommendation.Product, Listener> {

    private ImageView imgProduct;
    private TextView tvTitle;
    private TextView tvPrice;

    public ProductViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_item, parent, false));

        imgProduct = itemView.findViewById(R.id.product_image);
        tvTitle = itemView.findViewById(R.id.product_title);
        tvPrice = itemView.findViewById(R.id.product_price);
    }

    @Override
    public void onBindViewHolder(ProductRecommendation.Product model) {
        Glide.with(itemView.getContext())
                .load(model.imageUrl)
                .apply(new RequestOptions().fitCenter())
                .into(imgProduct);

        tvTitle.setText(model.catalogName);
        tvPrice.setText(model.price);
    }

    @Override
    public void setListener(Listener listener) {
        // Do Nothing
    }
}
