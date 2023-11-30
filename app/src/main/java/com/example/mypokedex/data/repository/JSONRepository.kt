package com.example.mypokedex.data.repository

import android.content.Context
import com.example.mypokedex.data.model.Pokemon
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class JSONRepository @Inject constructor(@ApplicationContext private val context: Context) : Repository {

    override fun getPokemon(): Pokemon {

        val gson = Gson()
        val jsonString =
            context.assets.open("ditto.json").bufferedReader().use { it.readText() }
        return gson.fromJson<Pokemon>(jsonString, Pokemon::class.java)

    }

}