package uz.bnabiyev.restapi13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.bnabiyev.restapi13.databinding.ActivityMainBinding
import uz.bnabiyev.restapi13.models.MyTodo
import uz.bnabiyev.restapi13.retrofit.ApiClient

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val allTodo = ApiClient.getApiService().getAllTodo()
        allTodo.enqueue(object : Callback<List<MyTodo>> {
            override fun onResponse(call: Call<List<MyTodo>>, response: Response<List<MyTodo>>) {
                if (response.isSuccessful) {
                    binding.tv.text = response.body().toString()
                }
            }

            override fun onFailure(call: Call<List<MyTodo>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }

        })

    }
}