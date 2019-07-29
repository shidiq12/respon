package com.gmail1998milatisidik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {

    private static final String JSON_URL = "https://gist.githubusercontent.com/shidiq12/fbd6dea09d9d8f8b7295bbd08273f9d6/raw/c434883f10e402c5e792defde994c784da3174d8/kampus.json";


    ListView listView;
    private List<item> playerItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView =  findViewById(R.id.lstview);
        playerItemList = new ArrayList<>();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int jurusan, long l) {

                item playerItem = playerItemList.get(jurusan);

                Intent i = new Intent(getApplicationContext(), detail.class);
                i.putExtra(detail.EXTRA_PLAYER, playerItem);
                startActivity(i);


            }
        });
        loadPlayer();
    }

    private void loadPlayer() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray playerArray = obj.getJSONArray("result");

                            for (int i = 0; i < playerArray.length(); i++) {

                                JSONObject Object = playerArray.getJSONObject(i);


                                item playerItem = new item(Object.getString("no"),
                                        Object.getString("name"),
                                        Object.getString("jurusan"),
                                        Object.getString("universitas"),
                                        Object.getString("daftar"));

                                playerItemList.add(playerItem);
                            }

                            ListViewAdapter adapter = new ListViewAdapter(playerItemList, getApplicationContext());

                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}