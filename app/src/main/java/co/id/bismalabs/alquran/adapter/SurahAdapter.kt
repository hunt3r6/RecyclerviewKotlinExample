package co.id.bismalabs.alquran.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.bismalabs.alquran.R
import co.id.bismalabs.alquran.data.ResponseSurah
import kotlinx.android.synthetic.main.item_surah.view.*

class SurahAdapter(val data: ArrayList<ResponseSurah.Surah>): RecyclerView.Adapter<SurahAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback?){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_surah, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(surah: ResponseSurah.Surah){
            with(itemView){
                tvName.text = surah.name
                setOnClickListener { onItemClickCallback?.onItemClicked(surah)}
            }

        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(surah: ResponseSurah.Surah)
        
    }
}