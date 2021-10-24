package com.example.kawa.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonInfoNetworkModelResponse(
    @SerializedName("results")
    @Expose
    val results: List<PersonInfoNetworkModel>,

    @SerializedName("info")
    @Expose
    val info: InfoNetworkModel
)

data class InfoNetworkModel(
    @SerializedName("seed")
    @Expose
    val seed: String,

    @SerializedName("results")
    @Expose
    val results: Int,

    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("version")
    @Expose
    val version: String
)

data class PersonInfoNetworkModel(
    @SerializedName("gender")
    @Expose
    val gender: String,

    @SerializedName("name")
    @Expose
    val name: NameNetworkModel,

    @SerializedName("location")
    @Expose
    val location: LocationNetworkModel,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("picture")
    @Expose
    val picture: PictureNetworkModel,

    @SerializedName("nat")
    @Expose
    val nationality: String,
)

data class PictureNetworkModel(
    @SerializedName("large")
    @Expose
    val large: String,

    @SerializedName("medium")
    @Expose
    val medium: String,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String,
)

data class LocationNetworkModel(
    @SerializedName("street")
    @Expose
    val street: StreetNetworkModel,

    @SerializedName("city")
    @Expose
    val city: String,

    @SerializedName("state")
    @Expose
    val state: String,

    @SerializedName("country")
    @Expose
    val country: String,

    @SerializedName("postcode")
    @Expose
    val postcode: String,

    @SerializedName("coordinates")
    @Expose
    val coordinates: Coordinates,

    @SerializedName("timezone")
    @Expose
    val timezone: Timezone,
)

data class Timezone(
    @SerializedName("offset")
    @Expose
    val offset: String,

    @SerializedName("description")
    @Expose
    val description: String,
)

data class Coordinates(
    @SerializedName("latitude")
    @Expose
    val latitude: String,

    @SerializedName("longitude")
    @Expose
    val longitude: String,
)

data class StreetNetworkModel(
    @SerializedName("number")
    @Expose
    val number: String,

    @SerializedName("name")
    @Expose
    val name: String,
)

data class NameNetworkModel(
    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("first")
    @Expose
    val first: String,

    @SerializedName("last")
    @Expose
    val last: String
)
