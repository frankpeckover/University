package com.example.utilityApp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        sharedPref = getSharedPreferences(getString(R.string.shared_prefs_key), MODE_PRIVATE)

        // Set the initial state of the switches based on saved preferences
        switchDisplayLocation.isChecked = sharedPref.getBoolean(getString(R.string.pref_key_display_location), true)
        switchDarkMode.isChecked = sharedPref.getBoolean(getString(R.string.pref_key_dark_mode), false)

        // Save the new switch state when it is changed
        switchDisplayLocation.setOnCheckedChangeListener { _, isChecked ->
            with(sharedPref.edit()) {
                putBoolean(getString(R.string.pref_key_display_location), isChecked)
                apply()
            }
        }

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            with(sharedPref.edit()) {
                putBoolean(getString(R.string.pref_key_dark_mode), isChecked)
                apply()
            }
        }
    }
}
