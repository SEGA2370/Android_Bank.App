package com.example.myapplication

data class HistoryData(
    val title: String,
    val logo: Int,
    val amount: String,
    val desc: String,
    var isExpandable: Boolean = false
)