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

        //Set variables to the buttons
        detailsText = findViewById(R.id.detail_text);
        imageView1 = findViewById(R.id.detail_img1);
        imageView2 = findViewById(R.id.detail_img2);

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
            detailsText.setText(new String(b));
        } catch (Exception e) {
            detailsText.setText( "Error: can't show info text." );
        }
    }

    //---------------------------Set images and text file to be read depending on country
    public void setColombia() {
        readText = getResources().openRawResource(R.raw.colombia_details);
        imageView1.setImageResource(R.drawable.col_uber);
        imageView2.setImageResource(R.drawable.col_med);
    }

    //---------------------------Set images and text file to be read depending on country
    public void setVenezuela() {
        readText = getResources().openRawResource(R.raw.venezuela_details);
        imageView1.setImageResource(R.drawable.ven_1);
        imageView2.setImageResource(R.drawable.ven_2);
    }

    //---------------------------Set images and text file to be read depending on country
    public void setMexico() {
        readText = getResources().openRawResource(R.raw.mexico_details);
        imageView1.setImageResource(R.drawable.mex_1);
        imageView2.setImageResource(R.drawable.mex_2);
    }

    //---------------------------Set images and text file to be read depending on country
    public void setSpain() {
        readText = getResources().openRawResource(R.raw.spain_details);
        imageView1.setImageResource(R.drawable.spain_1);
        imageView2.setImageResource(R.drawable.spain_2);
    }

    //---------------------------Set images and text file to be read depending on country
    public void setFrance() {
        readText = getResources().openRawResource(R.raw.france_details);
        imageView1.setImageResource(R.drawable.france_1);
        imageView2.setImageResource(R.drawable.france_2);
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
