package com.gmail1998milatisidik;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Uri uri = Uri.parse("http://instagram.com/_u/shidiq1210");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.instagram.android");
        try
        {
            Toast.makeText(profile.this, "Instagram", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/shidiq1210")));
        }

    }
}
