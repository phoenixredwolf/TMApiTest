package com.example.tmapitest.ui.adapater

import android.view.ViewGroup
import com.example.tmapitest.databinding.NoimageCardItemBinding
import com.example.tmapitest.ui.adapater.base.CardViewHolder
import com.example.tmapitest.util.inflater
import com.example.tmapitest.util.loadDescription
import com.example.tmapitest.util.loadTitle
import com.example.tmapitest.data.model.Card

class NoImageCardViewHolder(
    private val binding: NoimageCardItemBinding
) : CardViewHolder(binding) {

    override fun bindData(card: Card) : Unit = with(binding) {
        title.loadTitle(card.title)
        description.loadDescription(card.description)
        return@with
    }

    companion object {
        fun newInstance(parent: ViewGroup) = NoImageCardViewHolder(
            NoimageCardItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}