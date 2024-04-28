package com.insa.gamelist.extentions

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.insa.gamelist.R

fun ImageView.load(url : String){

    val uri = url.toUri().buildUpon().scheme("https").build()
    Glide.with(context).load(uri).into(this)
}

// TODO : here implement the loadConsoleLogo function

fun ImageView.loadConsoleLogo(consoleName : String, context: Context){
    when(consoleName){
        "PS4" -> this.load("https://gmedia.playstation.com/is/image/SIEPDC/ps4-pro-image-block-01-en-24jul20?\$1600px--t\$")
        "PS5" -> this.load("https://m.media-amazon.com/images/I/51QnZ0TtL2L._AC_SL1500_.jpg")
        "Xbox One" -> this.load("https://i5.walmartimages.com/asr/3a1db51b-b723-4d94-9b20-ef9d06ccedd3_1.cf7acb0d090de2a699fb35e55a89ee1a.jpeg")
        "Xbox X|S" -> this.load("https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE4mRni?ver=8361")
        "Switch" -> this.load("https://boulanger.scene7.com/is/image/Boulanger/0045496453442_h_f_l_0?wid=385&hei=385")
        "PC" -> this.load("https://www.seekpng.com/png/detail/438-4384790_computer-icon-transparent-background.png")
    }
}
