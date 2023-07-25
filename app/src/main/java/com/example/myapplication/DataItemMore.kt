package com.example.myapplication

sealed class DataItemMore {
    data class Item(val id: Int, val text: String): DataItemMore()
    data class Header(val text:String): DataItemMore()
}