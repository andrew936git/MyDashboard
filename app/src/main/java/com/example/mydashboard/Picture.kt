package com.example.mydashboard

import java.io.Serializable

class Picture(val image: Int): Serializable {
    companion object{
        val pictureList = mutableListOf(
            Picture(R.drawable.kotiki1),
            Picture(R.drawable.kotiki2),
            Picture(R.drawable.kotiki3),
            Picture(R.drawable.kotiki4),
            Picture(R.drawable.kotiki5)

        )
    }
}