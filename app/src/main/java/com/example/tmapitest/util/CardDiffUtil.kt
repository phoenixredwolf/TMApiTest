package com.example.tmapitest.util

import androidx.recyclerview.widget.DiffUtil
import com.example.tmapitest.data.model.Cards

object CardDiffUtil : DiffUtil.ItemCallback<Cards>() {

    override fun areContentsTheSame(
        oldItem: Cards,
        newItem: Cards
    ) = oldItem  == newItem

    override fun areItemsTheSame(
        oldItem: Cards,
        newItem: Cards
    ) = oldItem.cardType == newItem.cardType
}