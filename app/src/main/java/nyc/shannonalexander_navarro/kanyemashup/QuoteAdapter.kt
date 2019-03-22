package nyc.shannonalexander_navarro.kanyemashup

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import nyc.shannonalexander_navarro.kanyemashup.model.KanyeQuote

class QuoteAdapter(private val quoteList: List<KanyeQuote>) : RecyclerView.Adapter<QuoteViewHolder>() {

 //   private lateinit var quotes: List<KanyeQuote>

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): QuoteViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return QuoteViewHolder(root)
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {

        val quote: KanyeQuote = quoteList[position]
        holder.bind(quote)
    }
}