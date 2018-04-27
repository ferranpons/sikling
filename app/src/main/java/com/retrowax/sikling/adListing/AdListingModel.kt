package com.retrowax.sikling.adListing

data class AdListingModel(
    internal val id: String,
    internal val title: String,
    internal val price: String,
    internal val image: String,
    internal val date: String,
    internal val favorite: Boolean
)