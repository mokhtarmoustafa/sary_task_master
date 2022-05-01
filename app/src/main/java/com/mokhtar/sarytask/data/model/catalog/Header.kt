package com.mokhtar.sarytask.data.model.catalog


import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("image")
    val image: String,
    @SerializedName("type")
    val type: String
)