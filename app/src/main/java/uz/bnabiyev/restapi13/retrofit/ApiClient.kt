package uz.bnabiyev.restapi13.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "https://hvax.pythonanywhere.com/"
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
}