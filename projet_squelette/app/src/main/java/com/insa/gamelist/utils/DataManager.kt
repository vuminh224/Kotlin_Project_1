package com.insa.gamelist.utils

import android.content.Context
import android.util.Log
import com.insa.gamelist.R
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object DataManager {
    public var games :List<Game> = listOf()
    fun readFile(context: Context): List<Game>? {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val type = Types.newParameterizedType(List::class.java, Game::class.java)
        val jsonAdapter: JsonAdapter<List<Game>> = moshi.adapter(type)

        try {
            val inputStream = context.resources.openRawResource(R.raw.gamelist)
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)

            var line = bufferedReader.readLine()
            val stringBuilder = StringBuilder()

            while (line != null) {
                stringBuilder.append(line)
                line = bufferedReader.readLine()
            }
            val jsonString = stringBuilder.toString()
            //val Stringjson =context.resources.openRawResource(R.raw.gamelist).bufferedReader().use{it.readLine()}
            //Q4
            val games = jsonAdapter.fromJson(jsonString)
            games!!.forEach {
                Log.d("Q4", it.title)
            }
            //fin Q4
            this.games = games
            return games
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
    }

    //Q6
    fun getGame(position: Int): Game? {
        if(position<0 ||position>= games.size){
            return null
        }
        return games[position]
    }
    //fin Q6
}
