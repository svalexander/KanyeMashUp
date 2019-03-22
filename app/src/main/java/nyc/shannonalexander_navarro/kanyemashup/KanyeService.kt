package nyc.shannonalexander_navarro.kanyemashup

import nyc.shannonalexander_navarro.kanyemashup.model.KanyeQuote
import retrofit2.Call
import retrofit2.http.GET

interface KanyeService {

    @GET("/")
    fun getKanyeQuote() : Call<KanyeQuote>
}