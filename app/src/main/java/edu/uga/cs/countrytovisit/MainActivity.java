package edu.uga.cs.countrytovisit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button overviewB, detailsB;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String currentCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overviewB = findViewById(R.id.overview_button);
        detailsB = findViewById(R.id.details_button);

        spinner = findViewById(R.id.country_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(MainActivity.this);
//        System.out.println("I am ready to be clicked");

        System.out.println(currentCountry);

        overviewB.setOnClickListener(new ButtonClickOverview());
        detailsB.setOnClickListener(new ButtonClickDetails());
    }

    private class ButtonClickOverview implements
            View.OnClickListener
    {
        @Override
        public void onClick( View view ) {
//            System.out.println("I WAS CLICKED");
            Intent intent = new
                    Intent( view.getContext(), OverviewActivity.class );
            intent.putExtra("CurrentCountry",currentCountry);
            startActivity( intent );
        }
    }

    private class ButtonClickDetails implements
            View.OnClickListener
    {
        @Override
        public void onClick( View view ) {
//            System.out.println("I WAS CLICKED");
            Intent intent = new
                    Intent( view.getContext(), DetailsActivity.class );
            intent.putExtra("CurrentCountry",currentCountry);
            startActivity( intent );
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        currentCountry = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}