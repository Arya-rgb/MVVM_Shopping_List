package com.thorin.mvvmshoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thorin.mvvmshoppinglist.R
import com.thorin.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.thorin.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(var item: List<ShoppingItem>, private val viewModel: ShoppingViewModel): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingitem = item[position]

        holder.itemView.tvName.text = curShoppingitem.name
        holder.itemView.tvAmount.text = "${curShoppingitem.amount}"

        holder.itemView.tvDelete.setOnClickListener {
            viewModel.delete(curShoppingitem)
        }

        holder.itemView.tvPlus.setOnClickListener {
            curShoppingitem.amount++
            viewModel.upsert(curShoppingitem)
        }

        holder.itemView.tvMinus.setOnClickListener {
            if (curShoppingitem.amount > 0) {
                curShoppingitem.amount--
                viewModel.upsert(curShoppingitem)
            }
        }
    }

    override fun getItemCount(): Int = item.size

}