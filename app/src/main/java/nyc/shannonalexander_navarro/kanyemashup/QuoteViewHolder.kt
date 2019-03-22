package nyc.shannonalexander_navarro.kanyemashup

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import nyc.shannonalexander_navarro.kanyemashup.model.KanyeQuote

class QuoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private var iv : ImageView
    private var tv : TextView

    init {
        iv = itemView.findViewById(R.id.iv)
        tv = itemView.findViewById(R.id.tv)
    }

    fun bind(quote: KanyeQuote) {
        tv.text = quote.quote
    }
}