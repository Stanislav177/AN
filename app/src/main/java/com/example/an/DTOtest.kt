package com.example.an

data class TestDTO (
    val status: String,
    val code: Long,
    val total: Long,
    val data: List<Data>
)

data class Data (
    val title: String,
    val description: String,
    val url: String
)