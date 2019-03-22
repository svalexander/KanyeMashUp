package nyc.shannonalexander_navarro.kanyemashup

import nyc.shannonalexander_navarro.kanyemashup.model.KanyeQuote

interface MainActivityContract {

    fun showResponse(quotes : MutableList<KanyeQuote>)
    fun displayToast()
    fun showProgressBar()
    fun hideProgressBar()
}