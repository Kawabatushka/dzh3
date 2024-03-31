package ru.stankin.labs.dzh2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list: RecyclerView = findViewById(R.id.list)
        val adapter = landmarksAdapter(generateLandmarks(), this::onlandmarkItemClicked)
        list.adapter = adapter
    }

    private fun onlandmarkItemClicked(item: landmarkItem) {
        Toast.makeText(
            this, "landmark: ${item.name} clicked!", Toast.LENGTH_SHORT
        ).show()

        val intent = Intent(this, landmarkDetailActivity::class.java)
        intent.putExtra("name", item.name)
        intent.putExtra("country", item.country)
        intent.putExtra("city", item.city)
        intent.putExtra("age", item.estimatedAgeYears)
        intent.putExtra("height", item.heightMeters)
        startActivity(intent)
    }
}
