package com.insa.gamelist.utils

//Q2
data class Game(
    val id:Int,
    val title:String,
    val type: String,
    val console:List<String>,
    val editor: String,
    val developer:String,
    val timestamp:Long,
    val image:String,
    val description: String
    )
