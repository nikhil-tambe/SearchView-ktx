package com.nikhil.wahwah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DataRecyclerAdapter :
    ListAdapter<Data, DataRecyclerAdapter.DataViewHolder>(DataDiffUtil()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DataViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val locationImageView: ImageView = itemView.findViewById(R.id.location_ImageView)
        private val nameTextView: TextView = itemView.findViewById(R.id.name_TextView)
        private val locationTextView: TextView = itemView.findViewById(R.id.location_TextView)

        companion object {
            fun from(parent: ViewGroup): DataViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_data, parent, false
                )
                return DataViewHolder(view)
            }
        }

        fun bind(item: Data) {
            nameTextView.text = item.name
            locationTextView.text = item.location
            Glide.with(itemView.context)
                .setDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(item.imageUrl)
                .into(locationImageView)
        }

    }

}

class DataDiffUtil : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }

}
