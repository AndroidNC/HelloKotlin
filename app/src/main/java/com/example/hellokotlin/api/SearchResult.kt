package com.example.hellokotlin.api

import com.example.hellokotlin.models.Repo

data class SearchResult (
    val items: List<Repo>
)