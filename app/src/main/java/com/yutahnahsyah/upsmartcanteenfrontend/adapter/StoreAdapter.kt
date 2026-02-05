package com.yutahnahsyah.upsmartcanteenfrontend.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yutahnahsyah.upsmartcanteenfrontend.R
import com.yutahnahsyah.upsmartcanteenfrontend.data.model.Store

class StoreAdapter(
  private val stores: List<Store>,
  private val onClick: (Store) -> Unit
) : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {

  class StoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.storeName)
    val category: TextView = view.findViewById(R.id.storeCategory)
    val image: ImageView = view.findViewById(R.id.storeImage)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_store, parent, false)
    return StoreViewHolder(view)
  }

  override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
    val store = stores[position]
    holder.name.text = store.name
    holder.category.text = store.category
    holder.image.setImageResource(store.imageRes)

    holder.itemView.setOnClickListener { onClick(store) }
  }

  override fun getItemCount() = stores.size
}