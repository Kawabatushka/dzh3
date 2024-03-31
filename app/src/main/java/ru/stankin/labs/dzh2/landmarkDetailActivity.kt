package ru.stankin.labs.dzh2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class landmarkDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmark_detail)

        val landmarkNameTextView: TextView = findViewById(R.id.landmark_name)
        val landmarkCountryTextView: TextView = findViewById(R.id.landmark_country)
        val landmarkCityTextView: TextView = findViewById(R.id.landmark_city)
        val landmarkAgeTextView: TextView = findViewById(R.id.landmark_age)
        val landmarkHeightTextView: TextView = findViewById(R.id.landmark_height)

        landmarkNameTextView.text = intent.getStringExtra("name")
        landmarkCountryTextView.text = "Country of origin: ${intent.getStringExtra("country")}"
        landmarkCityTextView.text = "City: ${intent.getStringExtra("city")}"
        landmarkAgeTextView.text = "Estimated age: ${intent.getIntExtra("age", 0)} years"
        landmarkHeightTextView.text = "Height: ${intent.getDoubleExtra("height", 0.0)} meters"
        val openMapButton: Button = findViewById(R.id.openMapButton)

        openMapButton.setOnClickListener {
            val city = intent.getStringExtra("city")
            val country = intent.getStringExtra("country")
            val name = intent.getStringExtra("name")
            val location = "$city, $country"
            val gmmIntentUri = Uri.parse("geo:0,0?q=$location $name")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            //mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}
