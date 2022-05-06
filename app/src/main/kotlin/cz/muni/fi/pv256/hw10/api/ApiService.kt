package cz.muni.fi.pv256.hw10.api

import cz.muni.fi.pv256.hw10.data.NamedApiResourceList
import cz.muni.fi.pv256.hw10.data.Pokemon
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("pokemon?offset=0&limit=151")
    suspend fun getNamedApiResourceList(): NamedApiResourceList

    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): Pokemon

    companion object {

        private const val API_ENDPOINT = "https://pokeapi.co/api/v2/"

        val apiService by lazy { create() }

        private fun create(): ApiService = Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(ApiService::class.java)
    }
}

// for implementation without paging, use https://pokeapi.co/api/v2/pokemon?offset=0&limit=151
