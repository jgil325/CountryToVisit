package edu.uga.cs.countrytovisit;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class DetailsActivity extends AppCompatActivity {
    TextView detailsText;
    InputStream readText;
    ImageView imageView1, imageView2;
    String currentCountry ="Colombia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_details);

        detailsText = findViewById(R.id.detail_text);
        imageView1 = findViewById(R.id.detail_img1);
        imageView2 = findViewById(R.id.detail_img2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        currentCountry = getIntent().getStringExtra("CurrentCountry");
        showSelectedCountry(currentCountry);

    }

    public void showSelectedCountry(String country) {
        try {
            if (country.equals("Colombia")) {
                readText = getResources().openRawResource(R.raw.colombia_details);
                imageView1.setImageResource(R.drawable.col_uber);
                imageView2.setImageResource(R.drawable.col_med);
            } else if (country.equals("Colombia")) {
                readText = getResources().openRawResource(R.raw.colombia_details);
                imageView1.setImageResource(R.drawable.col_uber);
                imageView2.setImageResource(R.drawable.col_med);
            } else if (country.equals("Colombia")) {
                readText = getResources().openRawResource(R.raw.colombia_details);
                imageView1.setImageResource(R.drawable.col_uber);
                imageView2.setImageResource(R.drawable.col_med);
            } else if (country.equals("Colombia")) {
                readText = getResources().openRawResource(R.raw.colombia_details);
                imageView1.setImageResource(R.drawable.col_uber);
                imageView2.setImageResource(R.drawable.col_med);
            } else if (country.equals("Colombia")) {
                readText = getResources().openRawResource(R.raw.colombia_details);
                imageView1.setImageResource(R.drawable.col_uber);
                imageView2.setImageResource(R.drawable.col_med);
            }
            byte[] b = new byte[readText.available()];
            readText.read(b);
            detailsText.setText(new String(b));
        } catch (Exception e) {
            detailsText.setText( "Error: can't show info text." );
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
