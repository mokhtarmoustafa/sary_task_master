package com.mokhtar.sarytask.data.model.catalog


import com.google.gson.annotations.SerializedName

data class MetadataX(
    @SerializedName("consumable_display")
    val consumableDisplay: Any,
    @SerializedName("sub_title")
    val subTitle: Any,
    @SerializedName("title")
    val title: String
)