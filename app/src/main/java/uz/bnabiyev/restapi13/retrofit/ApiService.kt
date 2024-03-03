package uz.bnabiyev.restapi13.retrofit

import retrofit2.Call
import retrofit2.http.GET
import uz.bnabiyev.restapi13.models.MyTodo

interface ApiService {

    @GET("plan")
    fun getAllTodo():Call<List<MyTodo>>
}