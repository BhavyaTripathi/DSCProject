package com.example.bhavyatripathi.canteen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<String> lOrderItems = new ArrayList<>();

    Button btnPlaceOrder;
    ArrayList<Product> productOrders = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getProduct();
        listView = (ListView) findViewById(R.id.customListView);
        listAdapter = new ListAdapter(this,products);
        listView.setAdapter(listAdapter);
        btnPlaceOrder = (Button) findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }

    private void placeOrder()
    {
    /* Clear Product Orders for any existing data */
        productOrders.clear();
        lOrderItems.clear();

    /* Loop through each product. If user added any
    *  Quantity then add product in Product Order
    * */
        for(int i=0;i<listAdapter.listProducts.size();i++)
        {
            if(listAdapter.listProducts.get(i).CartQuantity > 0)
            {
                Product products = new Product(
                        listAdapter.listProducts.get(i).ProductName
                        ,listAdapter.listProducts.get(i).ProductPrice
                        ,listAdapter.listProducts.get(i).ProductImage
                );
                products.CartQuantity = listAdapter.listProducts.get(i).CartQuantity;
                productOrders.add(products);
            /* Create a JSON Object and store it in String ArrayList */
                lOrderItems.add(products.getJsonObject().toString());
            }
        }

    /* Convert String ArrayList into JSON Array */
        JSONArray jsonArray = new JSONArray(lOrderItems);
    /* Open Summary with JSONArray String */
        openSummary(jsonArray.toString());
    }

    public void showMessage(String message)
    {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void openSummary(String orderItems)
    {
        Intent summaryIntent = new Intent(this,Summary.class);
        summaryIntent.putExtra("orderItems",orderItems);
        startActivity(summaryIntent);
    }


    public void getProduct() {
        products.add(new Product("Hakka Noodles",50d,R.mipmap.noodless));
        products.add(new Product("Pizza",11.0d,R.mipmap.pizza));
        products.add(new Product("Pizza Roll",12.0d,R.mipmap.pizzaroll));
        products.add(new Product("Aloo Tikki Burger",13.0d,R.mipmap.burger));
        products.add(new Product("Cheese Burger",14.0d,R.mipmap.burger));
        products.add(new Product("Chilli Potato",16.0d,R.mipmap.chillip));
        products.add(new Product("Chola Samosa",11.0d,R.mipmap.chola));
        products.add(new Product("Cheese Sticks",15.0d,R.mipmap.cheese));
        products.add(new Product("Chilli Maggi",17.0d,R.mipmap.maggi));
        products.add(new Product("Cheesy Maggi",67.0d,R.mipmap.maggi));
        products.add(new Product("White Sauce Pasta",41.0d,R.mipmap.white));
        products.add(new Product("Red Sauce Pasta",16.0d,R.mipmap.red));
        products.add(new Product("Paneer Roll",18.0d,R.mipmap.roll));
        products.add(new Product("Vegetable Roll",121.0d,R.mipmap.roll));
        products.add(new Product("Veg Momos",122.0d,R.mipmap.momo));
        products.add(new Product("Paneer Momos",14.0d,R.mipmap.momo));
        products.add(new Product("Paneer Roll",51.0d,R.mipmap.roll));
        products.add(new Product("Chola Bhatura",12.0d,R.mipmap.cb));
        products.add(new Product("Dosa",16.0d,R.mipmap.dosa));
        products.add(new Product("Puri Sabji",12.0d,R.mipmap.puri));
        products.add(new Product("Tea",17.0d,R.mipmap.tea));
        products.add(new Product("Coffee",12.0d,R.mipmap.tea));
        products.add(new Product("Cold Drink",18.0d,R.mipmap.drink));
        products.add(new Product("Ice Cream",19.0d,R.mipmap.ice));
        products.add(new Product("AlooSandwich",21.0d,R.mipmap.sand));
        products.add(new Product("Paneer Sandwich",87.0d,R.mipmap.sand));
        products.add(new Product("Lassi",87.0d,R.mipmap.lassi));
        products.add(new Product("Rajma Chawal",123.0d,R.mipmap.rajma));
        products.add(new Product("Fried Rice",85.0d,R.mipmap.fried));
    }
}