package com.thorin.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thorin.mvvmshoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    //kombinasi update dan insert, jika sudah ada update, jika tidak buat baru
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>

}