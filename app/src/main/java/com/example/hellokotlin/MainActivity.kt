package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hellokotlin.models.Repo
import com.example.hellokotlin.reposlist.ReposAdapter

class MainActivity : AppCompatActivity() {
    val adapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list: RecyclerView = findViewById(R.id.list);
        list.layoutManager = LinearLayoutManager(this);
        list.adapter = adapter

        var sampleData = mutableListOf<Repo>(
        )

        for (i in 0..1000) {
            sampleData.add(i, Repo("Repo " + i))
        }

        adapter.submitList(sampleData)
    }
}