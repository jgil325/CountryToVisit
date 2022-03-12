package edu.uga.cs.countrytovisit;

import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class HomeFragmentContainer extends AppCompatActivity {


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
