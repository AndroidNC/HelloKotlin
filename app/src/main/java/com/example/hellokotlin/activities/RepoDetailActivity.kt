package com.example.hellokotlin.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.hellokotlin.R
import com.example.hellokotlin.models.Repo

class RepoDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_detail)

        val textViewName = findViewById<TextView>(R.id.name)
        val textViewOwnerName = findViewById<TextView>(R.id.owner_name)

        val stringName = intent.getStringExtra(KEY_NAME)
        val stringOwnerName  = intent.getStringExtra(KEY_OWNER_NAME)

        textViewName.text = stringName
        textViewOwnerName.text = "@$stringOwnerName"
    }

    companion object {
        const val KEY_NAME = "KEY_NAME"
        const val KEY_OWNER_NAME = "KEY_OWNER_NAME"

        fun startActivity(context: Context, repo:Repo) {
            val repoDetailsIntent = Intent(context, RepoDetailActivity::class.java)
            repoDetailsIntent.putExtra(KEY_NAME, repo.name)
            repoDetailsIntent.putExtra(KEY_OWNER_NAME, repo.owner.login)

            context.startActivity(repoDetailsIntent)
        }
    }
}