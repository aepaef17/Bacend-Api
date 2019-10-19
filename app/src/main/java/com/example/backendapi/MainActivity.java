package com.example.backendapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //attribut atau variable global
    private RecyclerView rvArsenal;
    private ArsenalAdapter adapter;
    private ArrayList<Arsenal> arsenals;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvArsenal = findViewById(R.id.rv_arsenal);
        adapter = new ArsenalAdapter(this);
        arsenals = new ArrayList<>();
        gson = new Gson();

        populateData();

        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this,lm.getOrientation());
        rvArsenal.setLayoutManager(lm);
        rvArsenal.setAdapter(adapter);
        rvArsenal.addItemDecoration(divider);
    }

    public void populateData(){
        //meminta request dengan Volley
        // jika request berhasil, tampilkan ke dalam recyclerView via adapter
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?t=Arsenal";
                    //StringRequest memiliki 4 value
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //ambil data dari response -> json -> arraylist
                        ArsenalResult result = gson.fromJson(response, ArsenalResult.class);
                        arsenals = result.getArsenals();
                        //tampilkan data via adapter
                        adapter.setArsenals(arsenals);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        queue.add(stringRequest);
    }
}
