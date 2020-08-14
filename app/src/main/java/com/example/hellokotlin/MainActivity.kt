package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hellokotlin.api.SearchResult
import com.example.hellokotlin.api.createGitHubApiService
import com.example.hellokotlin.models.Repo
import com.example.hellokotlin.reposlist.ReposAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ReposAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ReposAdapter {repo ->
            Toast.makeText(this, repo.name, Toast.LENGTH_SHORT).show()
        }

        var list: RecyclerView = findViewById(R.id.list);
        list.layoutManager = LinearLayoutManager(this);
        list.adapter = adapter

        val service = createGitHubApiService()
        service.searchRepositories("user:ReactNativeC").enqueue(object: Callback<SearchResult>{
            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("Not yet implemented")

            }
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                val repos = response.body()?.items.orEmpty()
                adapter.submitList(repos)
            }
        })
    }
}