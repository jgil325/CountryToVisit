package edu.uga.cs.countrytovisit;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.Locale;

public class OverviewActivity extends AppCompatActivity {

    TextView overviewText;
    InputStream readText;
    ImageView imageView;
    String currentCountry ="Colombia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_overview);

        overviewText = findViewById(R.id.overview_text);
        imageView = findViewById(R.id.overview_image);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        currentCountry = getIntent().getStringExtra("CurrentCountry");
        showSelectedCountry(currentCountry);

    }

    public void showSelectedCountry(String country) {
        try {
            if (country.equals("Colombia")) {
                readText = getResources().openRawResource(R.raw.colombia);
                imageView.setImageResource(R.drawable.col_flag);
            } else if (country.equals("Venezuela")) {
                readText = getResources().openRawResource(R.raw.venezuela);
                imageView.setImageResource(R.drawable.ven_flag);
            } else if (country.equals("Mexico")) {
                readText = getResources().openRawResource(R.raw.mexico);
                imageView.setImageResource(R.drawable.mex_flag);
            } else if (country.equals("France")) {
                readText = getResources().openRawResource(R.raw.france);
                imageView.setImageResource(R.drawable.france_flag);
            } else if (country.equals("Spain")) {
                readText = getResources().openRawResource(R.raw.spain);
                imageView.setImageResource(R.drawable.spain_flag);
            }
            byte[] b = new byte[readText.available()];
            readText.read(b);
            overviewText.setText(new String(b));
        } catch (Exception e) {
            overviewText.setText( "Error: can't show info text." );
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