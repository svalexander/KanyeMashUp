package nyc.shannonalexander_navarro.kanyemashup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import nyc.shannonalexander_navarro.kanyemashup.model.KanyeQuote

class MainActivity : AppCompatActivity(), MainActivityContract {

    private lateinit var quoteAdapter: QuoteAdapter
    private lateinit var presenter: MainActivityPresenter
    private lateinit var progressBar: ProgressBar
    private val quoteList: MutableList<KanyeQuote> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDummyData()
        initRV()
        initPresenter()
        progressBar = findViewById(R.id.progress_bar)

    }

    private fun initPresenter() {
        presenter = MainActivityPresenter()
    }

    private fun initRV() {
        val rv: RecyclerView = findViewById(R.id.rv)
        quoteAdapter = QuoteAdapter(quoteList)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.adapter = quoteAdapter
    }

    private fun setDummyData() {
        val kq = KanyeQuote("I'm kanye", "qwty")
        quoteList.add(kq)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachPresenter(this)
        showResponse(quoteList)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachPresenter()
    }

    override fun showResponse(quotes: MutableList<KanyeQuote>) {
        presenter.getResponse()
    }

    override fun displayToast() {
        Toast.makeText(this, "Danger Will Robinson", Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }


}
