package com.example.mypokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.data.model.Pokemon
import com.example.mypokedex.data.repository.JSONRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MyPokedexViewModel @Inject constructor(private val pokemonRepository: JSONRepository) :
    ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

//    val pokemonRepository: Repository = JSONRepository(application)

    init {
        loadPokemon();
    }

    fun loadPokemon() {

        viewModelScope.launch {
            val loadedPokemon = withContext(Dispatchers.IO) {
                pokemonRepository.getPokemon()
            }
            _pokemon.postValue(loadedPokemon)
        }

    }

}