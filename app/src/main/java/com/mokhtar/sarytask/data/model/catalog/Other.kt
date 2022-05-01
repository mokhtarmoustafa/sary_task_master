package com.mokhtar.sarytask.data.model.catalog


import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("business_status")
    val businessStatus: BusinessStatus,
    @SerializedName("header")
    val header: Header,
    @SerializedName("show_special_order_view")
    val showSpecialOrderView: Boolean,
    @SerializedName("show_vat")
    val showVat: Boolean,
    @SerializedName("uncompleted_profile_settings")
    val uncompletedProfileSettings: UncompletedProfileSettings
)