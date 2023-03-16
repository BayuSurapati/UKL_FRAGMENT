package com.bayusurapati.projectukl1

object tokoData {
    private val data = arrayOf(
        arrayOf(
            "Bonk Drink",
            "12$",
            R.drawable.bonk
        ),
        arrayOf(
            "Banana",
            "10$",
            R.drawable.banana
        ),
        arrayOf(
            "Fish Cake",
            "15$",
            R.drawable.fishcake
        ),
        arrayOf(
            "Lolipop",
            "8$",
            R.drawable.lolipop
        ),
        arrayOf(
            "Crit Cola",
            "20$",
            R.drawable.crit_a_cola
        ),
        arrayOf(
            "Milk",
            "10$",
            R.drawable.milk
        ),
        arrayOf(
            "Sandvich",
            "8$",
            R.drawable.sandvich
        ),
        arrayOf(
            "Scootish Drink",
            "8$",
            R.drawable.scottish_drink
        )
    )
    val listData: ArrayList<tokoClass>
        get() {
            val list = arrayListOf<tokoClass>()
            for (aData in data) {
                val tf2 = tokoClass()
                tf2.nama = aData[0] as String
                tf2.price = aData[1] as String
                tf2.photo = aData[2] as Int

                list.add(tf2)
            }
            return list
        }
}