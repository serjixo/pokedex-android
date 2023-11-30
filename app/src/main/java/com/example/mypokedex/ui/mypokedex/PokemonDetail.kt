package com.example.mypokedex.ui.mypokedex

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mypokedex.viewmodels.MyPokedexViewModel


@Composable
fun PokemonDetail(pokedexViewModel: MyPokedexViewModel) {
    val pokemon = pokedexViewModel.pokemon.observeAsState()
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        if (pokemon.value != null) {
//            Text(text = "Pokemon: ${pokemon.value!!.name}")
//        } else {
//            Text(text = "Loading...")
//        }
//
//        Button(onClick = { pokedexViewModel.loadPokemon() }) {
//            Text(text = "Load Pokemon")
//        }
//    }

    if (pokemon == null) {
        Text(text = "loading")
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                verticalAlignment = Alignment.Top,

                ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
//                        .c(Color.Green)
                            .clip(shape = CircleShape),
                    ) {
                        AsyncImage(
                            model = pokemon.value?.sprite?.frontDefault,
                            contentDescription = "Translated description of what the image contains",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Text(text = "name")
            }
            Row {
                Text(text = "types")
            }
            Row {
                Text(text = "height and weight")
            }
            Row {
                Text(text = "stats")
            }
        }
    }

}





