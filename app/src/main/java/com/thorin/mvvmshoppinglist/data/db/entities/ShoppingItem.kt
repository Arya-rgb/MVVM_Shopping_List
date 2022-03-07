package com.thorin.mvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//memberi nama untuk entitas/nama tablenya
@Entity(tableName = "shopping_item")

data class ShoppingItem(

//column info berguna untuk mengganti nama kolom dari default
    @ColumnInfo(name = "item_name")
    var name: String,

    @ColumnInfo(name = "item_amount")
    var amount: Int

) {

    //id nya autogenerate, jadi engga perlu buat id di atas/konstruktor, biarkan di handle room aja
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}
