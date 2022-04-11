package edu.wccnet.csherbenou.intentsproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.wccnet.csherbenou.intentsproject.ui.main.MainViewModel


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val ranTitles = MainViewModel.ranTitles

    private val ranDetails = MainViewModel.ranDetails

    private val ranImages = MainViewModel.ranImages


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return ranTitles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = ranTitles[i]
        viewHolder.itemDetail.text = ranDetails[i]
        viewHolder.itemImage.setImageResource(ranImages[i])

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView


        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener {

                var position: Int = getAdapterPosition()

                val i = Intent(it.context, SecondActivity::class.java)

                val sendTitle = MainViewModel.ranTitles[position]

                val sendDetail = MainViewModel.ranDetails[position]

                val sendImage = MainViewModel.ranImages[position]

                i.putExtra("title", sendTitle)

                i.putExtra("detail", sendDetail)

                i.putExtra("image", sendImage)

                it.context.startActivity(i)
                }

            }

        }

}