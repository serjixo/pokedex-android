package com.example.mypokedex.di;

import android.content.Context
import com.example.mypokedex.data.repository.JSONRepository
import com.example.mypokedex.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

//TODO Delacaramos Module de dagger para marcar que esta clase va a ser una
// proveedora de dependencias.
//InstallIn lo utilizamos para que las dependencias que este modulo provea
@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

//    @Provides
//    fun provideRepository(
//
//    ): Repository {
//        return JSONRepository(@ApplicationContext private val context: Context)
//    }
//    @Provides
//    @Singleton
//    fun provideContext(application: Application): Context = application.applicationContext
//
}
