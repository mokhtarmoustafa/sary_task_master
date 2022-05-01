package com.mokhtar.sarytask.data.model.catalog


import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class CatalogData(
    @SerializedName("cover")
    val cover: Any,
    @SerializedName("deep_link")
    val deepLink: String,
    @SerializedName("filters")
    val filters: List<Filter>,
    @SerializedName("group_id")
    val groupId: Int,
    @SerializedName("group_type")
    val groupType: Any,
    @SerializedName("header")
    val header: Any,
    @SerializedName("image")
    val image: String,
    @SerializedName("metadata")
    val metadata: MetadataX,
    @SerializedName("name")
    val name: String
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CatalogData>() {
            override fun areItemsTheSame(oldItem: CatalogData, newItem: CatalogData): Boolean {
                return oldItem.groupId == newItem.groupId
            }

            override fun areContentsTheSame(oldItem: CatalogData, newItem: CatalogData): Boolean {
                return oldItem == newItem
            }
        }
    }
}