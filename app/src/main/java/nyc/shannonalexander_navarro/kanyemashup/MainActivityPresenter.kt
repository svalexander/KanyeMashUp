package nyc.shannonalexander_navarro.kanyemashup

import android.util.Log
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import nyc.shannonalexander_navarro.kanyemashup.model.KanyeQuote

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
        call.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<KanyeQuote> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                   
                }

                override fun onNext(t: KanyeQuote) {
                    Log.d("quote?", t.quote)
                }

                override fun onError(e: Throwable) {
                    Log.d("error?", e.printStackTrace().toString())
                }

            })

        //observable for each type
        //zip
        //create new model
    }
}