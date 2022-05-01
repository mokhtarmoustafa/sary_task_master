package com.mokhtar.sarytask.data.model.catalog


import com.google.gson.annotations.SerializedName

data class CatalogResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("other")
    val other: Other,
    @SerializedName("result")
    val catalogResult: List<CatalogResult>,
    @SerializedName("status")
    val status: Boolean
)
{
    val validCatalogs:List<CatalogResult> get() {
        return catalogResult.filter { it.dataType in setOf(
            DataType.SMART.type,
            DataType.GROUP.type,
            DataType.BANNER.type
        ) }
    }
}
