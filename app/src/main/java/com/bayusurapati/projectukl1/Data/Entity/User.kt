package com.bayusurapati.projectukl1.Data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    val temanId: Int? = null,
    val nama: String,
    val kelamin: String,
    val email: String,
    val telp: String,
    val alamat: String,
    val date: String

)