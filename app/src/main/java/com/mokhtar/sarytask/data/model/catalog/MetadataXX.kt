package com.mokhtar.sarytask.data.model.catalog


import com.google.gson.annotations.SerializedName

data class MetadataXX(
    @SerializedName("consumable_display")
    val consumableDisplay: Any,
    @SerializedName("sub_title")
    val subTitle: String,
    @SerializedName("title")
    val title: String
)