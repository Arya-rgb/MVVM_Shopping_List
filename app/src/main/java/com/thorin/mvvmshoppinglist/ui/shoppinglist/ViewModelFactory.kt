package com.thorin.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thorin.mvvmshoppinglist.data.repositories.ShoppingRepository

class ViewModelFactory(private val repository: ShoppingRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }

}