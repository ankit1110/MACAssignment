package mac.com.macassignment.Assignment1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import mac.com.macassignment.R;


/**
 * Created by kalpesh on 21/09/2015.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.Holder>

{
    ArrayList<String> mlistData = new ArrayList<>();
    LayoutInflater layoutInflater;
    public ProductsAdapter(Context context)
    {
        layoutInflater = LayoutInflater.from(context);
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
        String name = mlistData.get(position);
        String price = mlistData.get(position);

        holder.itemname.setText(name);
        holder.price.setText(price);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeitem(position);
            }
        });
    }

    public void additem(String name,String price)
    {
       try {
           mlistData.add(name);
           mlistData.add(price);
           notifyItemInserted(mlistData.size() - 1);
       }
           catch(Exception e)
           {
               Log.d("/////////",e.toString());
           }
       
    }
    public void removeitem(int position)
    {
        mlistData.remove(position);
        notifyItemRemoved(position);

    }

    @Override
    public int getItemCount() {

        return mlistData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView itemname,price;
        Button delete;
        public Holder(View itemView) {
            super(itemView);
            itemname = (TextView)itemView.findViewById(R.id.tv_name);
            price = (TextView)itemView.findViewById(R.id.tv_price);
            delete = (Button)itemView.findViewById(R.id.btn_delete);

        }
    }
}


