package com.example.tmapitest.di

import com.example.tmapitest.BuildConfig
import com.example.tmapitest.data.model.utility.CardTypeAdapter
import com.example.tmapitest.data.repository.DataRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// Module for DI objects
object Module {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient.Builder().build()

    // variable needed for viewmodels
    val moshi: Moshi = Moshi.Builder().add(CardTypeAdapter).build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(provideBaseUrl())
            .client(provideOkHttpClient())
            .build()

    @Provides
    @Singleton
    // DI call for repository
    fun providesDataRepository(): DataRepository {
        return DataRepository()
    }
}