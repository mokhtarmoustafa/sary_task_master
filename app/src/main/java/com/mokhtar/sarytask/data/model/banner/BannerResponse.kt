package com.mokhtar.sarytask.data.model.banner


import com.google.gson.annotations.SerializedName

data class BannerResponse(
    @SerializedName("result")
    val result: List<Banner>,
    @SerializedName("status")
    val status: Boolean
)