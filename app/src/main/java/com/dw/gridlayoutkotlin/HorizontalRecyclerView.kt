package com.dw.gridlayoutkotlin
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class HorizontalRecyclerView(private val uri: ArrayList<Uri>) :
    RecyclerView.Adapter<HorizontalRecyclerView.HorizontalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): HorizontalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.recycle_design, parent, false)
        return HorizontalViewHolder(view)
    }

    override fun onBindViewHolder(horizontalViewHolder: HorizontalViewHolder, position: Int) {
        horizontalViewHolder.mImageRecyclerView.setImageURI(uri[position])
    }

    override fun getItemCount(): Int {
        return uri.size
    }

    inner class HorizontalViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var mImageRecyclerView: ImageView

        init {
            mImageRecyclerView = itemView.findViewById(R.id.image)
        }
    }
}
