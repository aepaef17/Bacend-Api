package com.example.backendapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    //data terlebih dahulu semua komponen
    private ImageView imageView;
    private TextView tvName, tvNationality, tvPlace, tvBirthday, tvDescription;
    //menampung idPlayer yang sudah dikirim oleh main activiry
    private String idPlayer;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //findview by id, agar view bisa dikenali di java
        imageView = findViewById(R.id.imageView2);
        tvName = findViewById(R.id.tv_name);
        tvNationality = findViewById(R.id.tv_nationality);
        tvPlace = findViewById(R.id.tv_birthplace);
        tvBirthday = findViewById(R.id.tv_birthday);
        tvDescription = findViewById(R.id.tv_description);
        gson = new Gson();

        //idPlayer diterima dan dimasukan ke url
        idPlayer = getIntent().getStringExtra("idPlayer");
        String url = "https://www.thesportsdb.com/api/v1/json/1/lookupplayer.php?id="+idPlayer;

        //ambil data dengan menggunakan Volley dan Gson
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //ambil nilai dan set komponen ke layout
                        ArsenalResult result = gson.fromJson(response, ArsenalResult.class);
                        Arsenal arsenal = result.getArsenals().get(0);
                        tvName.setText(arsenal.getName());
                        tvNationality.setText(arsenal.getNationality());
                        tvPlace.setText(arsenal.getBirthPlace());
                        tvBirthday.setText(arsenal.getBirthDate());
                        tvDescription.setText(arsenal.getDescription());
                        Picasso.get().load(arsenal.getImagePath()).into(imageView);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        queue.add(stringRequest);
    }



}
