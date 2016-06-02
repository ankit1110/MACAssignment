package mac.com.macassignment.Assignment1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mac.com.macassignment.R;

public class MainActivity extends AppCompatActivity
{

    EditText item_name,price;
    RecyclerView mRecyclerView;
    ProductsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item_name = (EditText)findViewById(R.id.name);
        price = (EditText)findViewById(R.id.price);
        mRecyclerView =(RecyclerView)findViewById(R.id.list_data);

        mAdapter = new ProductsAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
      //  mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       // mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
    public void additem(View v)
    {

        try
        {
          //mProductlist.add(new Product(item_name.getText().toString(),price.getText().toString()));

            mAdapter.additem(item_name.getText().toString(),price.getText().toString());
           mAdapter.notifyDataSetChanged();





         /*   Product movie = new Product(item_name.getText().toString(),price.getText().toString());

            mProductlist.add(movie);
            productsAdapter.notifyDataSetChanged();*/
            Toast.makeText(MainActivity.this, "Item And Price Inserted Successfully", Toast.LENGTH_SHORT).show();



        }
        catch(Exception e)
        {
            Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
        }


    }
}
