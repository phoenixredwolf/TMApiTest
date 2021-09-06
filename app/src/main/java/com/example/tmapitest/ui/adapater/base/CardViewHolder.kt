package com.example.tmapitest.ui.adapater.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tmapitest.data.model.Card

// Base view holder that all others must inherit from
abstract class CardViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bindData(card: Card)
}