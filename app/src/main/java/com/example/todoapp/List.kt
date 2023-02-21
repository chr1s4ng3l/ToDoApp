package com.example.todoapp

class List {


    companion object {
        fun addI(item: String): MutableList<Item> {
            return mutableListOf(
                Item(item)
            )
        }
    }
}


