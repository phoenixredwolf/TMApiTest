package com.example.tmapitest.ui.adapater

import android.view.ViewGroup
import com.example.tmapitest.databinding.ImageCardItemBinding
import com.example.tmapitest.ui.adapater.base.CardViewHolder
import com.example.tmapitest.util.inflater
import com.example.tmapitest.util.loadDescription
import com.example.tmapitest.util.loadImage
import com.example.tmapitest.util.loadTitle
import com.example.tmapitest.data.model.Card

class ImageCardViewHolder(
    private val binding: ImageCardItemBinding
) : CardViewHolder(binding) {

    override fun bindData(card: Card) : Unit = with(binding) {
        cardImage.loadImage(card.image)
        descriptionContainer.title.loadTitle(card.title)
        descriptionContainer.description.loadDescription(card.description)
        return@with
    }

    companion object {
        fun newInstance(parent: ViewGroup) = ImageCardViewHolder(
            ImageCardItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}