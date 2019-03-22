package nyc.shannonalexander_navarro.kanyemashup

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 object KanyeClient {

    private val BASE_URL : String = "https://api.kanye.rest"
    private lateinit var kanyeService: KanyeService



    var retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        fun createService() : KanyeService {
            kanyeService = retrofit.create(KanyeService::class.java)
            return kanyeService
        }
}