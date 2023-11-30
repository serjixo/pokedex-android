package com.example.mypokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mypokedex.ui.mypokedex.PokemonDetail
import com.example.mypokedex.ui.theme.MyPokedexTheme
import com.example.mypokedex.viewmodels.MyPokedexViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val pokedexViewModel: MyPokedexViewModel by viewModels()
                    val navController: NavHostController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "pokemon_detail_screen"
                    ) {
                        composable(
                            route = "pokemon_detail_screen",
                            arguments = listOf(
                                navArgument(name = "pokemonName") {
                                    type = NavType.StringType
                                },
                                navArgument(name = "pokemonUrl") {
                                    type = NavType.StringType
                                },
                            )
                        ) {
                            val pokemonName = remember { it.arguments?.getString("pokemonName") }
                            PokemonDetail(pokedexViewModel)
                        }
                    }

                }
            }
        }
    }

}
