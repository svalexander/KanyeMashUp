package nyc.shannonalexander_navarro.kanyemashup

import android.util.Log
import nyc.shannonalexander_navarro.kanyemashup.model.KanyeQuote
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPresenter {

    private var contract: MainActivityContract? = null

    fun attachPresenter(contract: MainActivityContract) {
        this.contract = contract
    }

    fun detachPresenter() {
        contract = null
    }

    fun getResponse() {
        contract!!.showProgressBar()

        val call = KanyeClient.createService().getKanyeQuote()

        call.enqueue(object : Callback<KanyeQuote> {
            override fun onResponse(call: Call<KanyeQuote>, response: Response<KanyeQuote>) {
                contract!!.hideProgressBar()
                if(response.isSuccessful){
                   var result : KanyeQuote? = response.body()
                    Log.d("result?", result?.quote)
                }
            }

            override fun onFailure(call: Call<KanyeQuote>, t: Throwable) {
                contract!!.hideProgressBar()
                contract!!.displayToast()
                Log.d("failed?", "failed")
                Log.d("url?", call.request().url().toString())
            }

        })
        //observable for each type
        //zip
        //create new model
    }
}