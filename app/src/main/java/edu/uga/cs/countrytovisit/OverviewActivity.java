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

        //Set variables to the buttons
        overviewText = findViewById(R.id.overview_text);
        imageView = findViewById(R.id.overview_image);

        //Get the back arrow created
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get the current country from mainActivity intent
        currentCountry = getIntent().getStringExtra("CurrentCountry");
        //Show the correct country based on the one selected
        showSelectedCountry(currentCountry);

    }

    //Reads correct text files and sets pictures based on the country
    public void showSelectedCountry(String country) {
        try {
            if (country.equals("Colombia")) {
                setColombia();
            } else if (country.equals("Venezuela")) {
                setVenezuela();
            } else if (country.equals("Mexico")) {
                setMexico();
            } else if (country.equals("Spain")) {
                setSpain();
            } else if (country.equals("France")) {
                setFrance();
            }
            byte[] b = new byte[readText.available()];
            readText.read(b);
            overviewText.setText(new String(b));
        } catch (Exception e) {
            overviewText.setText( "Error: can't show info text." );
        }
    }

    //---------------------------Set images and text file to be read depending on country
    public void setColombia() {
        readText = getResources().openRawResource(R.raw.colombia);
        imageView.setImageResource(R.drawable.col_flag);
    }

    //---------------------------Set images and text file to be read depending on country
    public void setVenezuela() {
        readText = getResources().openRawResource(R.raw.venezuela);
        imageView.setImageResource(R.drawable.ven_flag);
    }

    //---------------------------Set images and text file to be read depending on country
    public void setMexico() {
        readText = getResources().openRawResource(R.raw.mexico);
        imageView.setImageResource(R.drawable.mex_flag);
    }

    //---------------------------Set images and text file to be read depending on country
    public void setSpain() {
        readText = getResources().openRawResource(R.raw.spain);
        imageView.setImageResource(R.drawable.spain_flag);
    }

    //---------------------------Set images and text file to be read depending on country
    public void setFrance() {
        readText = getResources().openRawResource(R.raw.france);
        imageView.setImageResource(R.drawable.france_flag);
    }

    //Used for the back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Used for the back button
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
