package com.example.utilityApp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences
    val settingsButton = findViewById<Button>(R.id.settings_button)
    val refreshButton = findViewById<Button>(R.id.refresh_button)
    val textViewLocation = findViewById<TextView>(R.id.location)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences(getString(R.string.shared_prefs_key), MODE_PRIVATE)

        // Set the initial state of the location display based on saved preferences
        textViewLocation.text = getString(R.string.default_location)


        // Set the click listener for the settings button
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        // Set the click listener for the refresh button
        refreshButton.setOnClickListener {
            // TODO: Implement weather data refresh functionality
            Toast.makeText(this, "Refresh clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
