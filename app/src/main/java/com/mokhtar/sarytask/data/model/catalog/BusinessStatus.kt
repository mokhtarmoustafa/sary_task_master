package com.mokhtar.sarytask.data.model.catalog


import com.google.gson.annotations.SerializedName

data class BusinessStatus(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)