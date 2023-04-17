package edu.psu.cmpsc475.settingsExample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.preference.PreferenceManager;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import edu.psu.cmpsc475.settingsExample.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set default values in shared preferences if they have never been set
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Toast.makeText(MainActivity.this, "The current tf setting value is " + sharedPref.getBoolean("tfSetting", true) +
                                     " and the current string setting is " + sharedPref.getString("stringSetting", ""), Toast.LENGTH_LONG).show();

                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }

}