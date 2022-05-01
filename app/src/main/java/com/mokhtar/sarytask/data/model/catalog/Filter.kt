package com.mokhtar.sarytask.data.model.catalog


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("filter_id")
    val filterId: Int,
    @SerializedName("image")
    val image: Any,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("name")
    val name: String
)