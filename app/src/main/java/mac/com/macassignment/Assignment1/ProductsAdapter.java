package mac.com.macassignment.Assignment1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mac.com.macassignment.R;


/**
 * Created by kalpesh on 21/09/2015.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.Holder>

{
    private List<Product> mData = Collections.emptyList();
    Context context;
    LayoutInflater layoutInflater;
    public ProductsAdapter(Context context)
    {
        this.context = context;
        //layoutInflater = LayoutInflater.from(context);
    }

    public ProductsAdapter()
    {

    }

    public void updateList(List<Product> data) {
        mData = data;
        notifyDataSetChanged();
    }



    @Override
    public ProductsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row =  layoutInflater.inflate(R.layout.card_row, parent,false);
        Holder holder = new Holder(row);
        return null;
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.Holder holder, final int position)
    {
        String name = mData.get(position).getItem_name();
        String price = mData.get(position).getItem_price();

        holder.itemname.setText(name);
        holder.price.setText(price);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
    }

    public void addItem(int position, Product data) {
        mData.add(position, data);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView itemname,price;
        Button delete;
        public Holder(View itemView) {
            super(itemView);
            itemname = (TextView)itemView.findViewById(R.id.etTitle);
            price = (TextView)itemView.findViewById(R.id.etDescription);
            delete = (Button)itemView.findViewById(R.id.btnAddItem);

        }
    }
}


