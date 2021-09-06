package com.example.tmapitest.ui.adapater

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.tmapitest.ui.adapater.base.CardViewHolder
import com.example.tmapitest.util.CardDiffUtil
import com.example.tmapitest.util.CardType
import com.example.tmapitest.data.model.Cards
import java.lang.IllegalArgumentException

class DataAdapter : ListAdapter<Cards, CardViewHolder>(CardDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = when (viewType) {
        CardType.IMAGE_ITEM.ordinal -> ImageCardViewHolder.newInstance(parent)
        CardType.NOIMAGE_ITEM.ordinal -> NoImageCardViewHolder.newInstance(parent)
        CardType.TEXT_ITEM.ordinal -> TextCardViewHolder.newInstance(parent)
        else -> throw IllegalArgumentException("Invalid view type")
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindData(getItem(position).card)
    }

    override fun getItemViewType(position: Int) = getItem(position).cardType.ordinal
}