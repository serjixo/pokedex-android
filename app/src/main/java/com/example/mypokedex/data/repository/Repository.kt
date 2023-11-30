package com.example.mypokedex.data.repository

import com.example.mypokedex.data.model.Pokemon

interface Repository {
    fun getPokemon(): Pokemon
}