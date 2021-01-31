package com.akakim.kotlinlib.adapter

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-31
 */
class ItemDecorator : RecyclerView.ItemDecoration() {

    val defaultColor = Color.TRANSPARENT

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

//        parent.
//        view.layoutParams.apply {
//            this.width
//        }
    }
}