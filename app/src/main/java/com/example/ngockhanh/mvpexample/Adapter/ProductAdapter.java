package com.example.ngockhanh.mvpexample.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ngockhanh.mvpexample.Model.Products.Products;
import com.example.ngockhanh.mvpexample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ngoc Khanh on 1/2/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ShowHolder> {

    private List<Products> productList;
    private Context context;

    class ShowHolder extends RecyclerView.ViewHolder {

        CardView cardView;
       TextView tvProductName;
      ImageView img_Thumnail;

        public ShowHolder(View view) {
            super(view);
          //  ButterKnife.bind(this, itemView);
            cardView =(CardView) view.findViewById(R.id.cardView);
            tvProductName=(TextView) view.findViewById(R.id.tv_Name);
            img_Thumnail=(ImageView) view.findViewById(R.id.img_Thumnail);
        }
    }

    public ProductAdapter(List<Products> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @Override
    public ShowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_item, viewGroup, false);
        ShowHolder showHolder= new ShowHolder(view);
        return showHolder;
    }

    @Override
    public void onBindViewHolder(ShowHolder showHolder, int i) {
        Products product = productList.get(i);
        showHolder.tvProductName.setText(product.getProductName());
       // Glide.with(context).load(product.getThumnail())
            //    .override(150,150).centerCrop().into(showHolder.img_Thumnail);

        Picasso.with(context).load(product.getThumnail()).into(showHolder.img_Thumnail);
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }

}