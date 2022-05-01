package com.mokhtar.sarytask.data.model.catalog


import com.google.gson.annotations.SerializedName

data class UncompletedProfileSettings(
    @SerializedName("image")
    val image: String,
    @SerializedName("is_completed_profile")
    val isCompletedProfile: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("show_tag")
    val showTag: Boolean
)