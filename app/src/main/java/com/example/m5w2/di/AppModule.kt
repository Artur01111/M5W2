package com.example.m5w2.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.m5w2.OnLesson.LoveApiService
import com.example.m5w2.di.room.LoveDao
import com.example.m5w2.di.room.LoveDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoveApiService(retrofit: Retrofit): LoveApiService {
        return retrofit.create(LoveApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("onboarding_prefs", Context.MODE_PRIVATE)
    }

    // Метод для предоставления базы данных Room
    @Singleton
    @Provides
    fun provideLoveDatabase(@ApplicationContext context: Context): LoveDataBase {
        return Room.databaseBuilder(
            context,
            LoveDataBase::class.java,
            "love_database"
        ).build()
    }

    // Метод для предоставления DAO
    @Singleton
    @Provides
    fun provideLoveDao(loveDatabase: LoveDataBase): LoveDao {
        return loveDatabase.loveDao()
    }
}