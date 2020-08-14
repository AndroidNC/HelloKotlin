package com.example.hellokotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.hellokotlin.R

class RepoDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_detail)

        val textViewName = findViewById<TextView>(R.id.name)
        val textViewOwnerName = findViewById<TextView>(R.id.owner_name)

        textViewName.setText(intent.getStringExtra("name"))
        textViewOwnerName.setText(intent.getStringExtra("owner_name"))
    }
}