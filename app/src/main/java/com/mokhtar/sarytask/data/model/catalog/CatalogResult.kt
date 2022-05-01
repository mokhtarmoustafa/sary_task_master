package com.mokhtar.sarytask.data.model.catalog


import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName


data class CatalogResult(
    @SerializedName("data")
    val `data`: List<CatalogData>,
    @SerializedName("data_type")
    val dataType: String,
    @SerializedName("excluded_business_segments")
    val excludedBusinessSegments: List<Int>,
    @SerializedName("group_id")
    val groupId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("items_count")
    val itemsCount: Int,
    @SerializedName("metadata")
    val metadata: MetadataXX,
    @SerializedName("row_count")
    val rowCount: Int,
    @SerializedName("show_more_enabled")
    val showMoreEnabled: Boolean,
    @SerializedName("show_title")
    val showTitle: Boolean,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("ui_type")
    val uiType: String
)
{
    val notNullCatalogItems: List<CatalogData>
        get() {
            return data.filter { it.image.isNullOrEmpty().not() }
        }

    val validTypes: List<CatalogData>
        get() {
            return data.filter { this.dataType in setOf(
                DataType.SMART.type,
                DataType.GROUP.type,
                DataType.BANNER.type
            ) }
        }



    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CatalogResult>() {
            override fun areItemsTheSame(oldItem: CatalogResult, newItem: CatalogResult): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CatalogResult, newItem: CatalogResult): Boolean {
                return oldItem == newItem
            }
        }
    }
}