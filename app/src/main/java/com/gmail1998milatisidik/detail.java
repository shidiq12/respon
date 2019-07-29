package com.gmail1998milatisidik;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class detail extends AppCompatActivity {

    public static String EXTRA_PLAYER = "extra_player";
    TextView tvNo, tvNama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNo = findViewById(R.id.tvNo);
        tvNama = findViewById(R.id.tvNama);


        item playerItem =  getIntent().getParcelableExtra(EXTRA_PLAYER);

        String no = playerItem.getNo();
        String name = playerItem.getName();

        tvNo.setText(no);
        tvNama.setText(name);


    }
}
