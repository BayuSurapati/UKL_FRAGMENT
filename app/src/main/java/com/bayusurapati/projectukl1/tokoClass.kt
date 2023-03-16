package com.bayusurapati.projectukl1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class tokoClass(
    var nama: String = "",
    var price: String = "",
    var photo: Int? = null
)   :Parcelable
