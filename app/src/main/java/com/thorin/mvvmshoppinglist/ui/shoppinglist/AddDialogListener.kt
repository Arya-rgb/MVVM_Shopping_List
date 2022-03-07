package com.thorin.mvvmshoppinglist.ui.shoppinglist

import com.thorin.mvvmshoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}