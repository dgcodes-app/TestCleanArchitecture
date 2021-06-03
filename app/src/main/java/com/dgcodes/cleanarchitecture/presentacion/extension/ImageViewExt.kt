package com.dgcodes.cleanarchitecture.presentacion.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.glide(url: String, scale: ImageView.ScaleType = ImageView.ScaleType.CENTER) {
   // this.scaleType = scale

    Glide.with(this.context).load(url).into(this)
}
