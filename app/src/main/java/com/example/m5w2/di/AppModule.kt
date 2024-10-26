package com.example.m5w2.di

import android.content.Context
import android.content.SharedPreferences
import com.example.m5w2.OnLesson.LoveApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideLoveApiService(retrofit: Retrofit): LoveApiService{
        return  retrofit.create(LoveApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("onboarding_prefs", Context.MODE_PRIVATE)
    }
}