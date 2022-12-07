package com.example.mymovie.Root



import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
// interface
interface MovieApi {
    // digunakn utuk mendapatkan data movie yang populer
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>
}
// fungsi yang dijalankan dari retrofitServic untuk
// menjalankan fungsi interface
object RetrofitInstance {
    val api : MovieApi by lazy {
        Retrofit.Builder()
                // urlBase
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}