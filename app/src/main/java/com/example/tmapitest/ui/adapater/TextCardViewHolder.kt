package com.example.tmapitest.ui.adapater

import android.view.ViewGroup
import com.example.tmapitest.databinding.TextCardItemBinding
import com.example.tmapitest.ui.adapater.base.CardViewHolder
import com.example.tmapitest.util.inflater
import com.example.tmapitest.util.loadValue
import com.example.tmapitest.data.model.Card

class TextCardViewHolder(
    private val binding: TextCardItemBinding
) : CardViewHolder(binding) {

    override fun bindData(card: Card) : Unit = with(binding) {
        cardText.loadValue(card)
    }

    companion object {
        fun newInstance(parent: ViewGroup) = TextCardViewHolder(
            TextCardItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}