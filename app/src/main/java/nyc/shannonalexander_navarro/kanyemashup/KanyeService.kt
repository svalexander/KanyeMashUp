package nyc.shannonalexander_navarro.kanyemashup

import io.reactivex.Observable
import nyc.shannonalexander_navarro.kanyemashup.model.KanyeQuote
import retrofit2.http.GET

interface KanyeService {

    @GET("/")
    fun getKanyeQuote() : Observable<KanyeQuote>
}