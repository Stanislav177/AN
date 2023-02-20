package com.example.an

import com.google.gson.annotations.SerializedName

//data class DTO (
//    @SerializedName("servers1.1-1.16")
//    val servers11116: Servers,
//    @SerializedName("servers1.16-1.19")
//    val servers116119: Servers,
//    val serversMiniGames: Servers
//)
//
//data class Servers (
//    @SerializedName("id-1")
//    val id1: ID,
//    @SerializedName("id-2")
//    val id2: ID,
//    @SerializedName("id-3")
//    val id3: ID,
//    @SerializedName("id-4")
//    val id4: ID
//)
//
//data class ID (
//    val title: String,
//    val ip: String,
//    val port: String,
//    val image: String,
//    val description: String,
//    val version: String? = null
//)

data class DTO(
    @SerializedName("servers1.1-1.16")
    val servers11116: Servers,
    @SerializedName("servers1.16-1.19")
    val servers116119: Servers,
    val serversMiniGames: Servers
)

data class Servers(
    val fields: List<Field>
)

data class Field(
    val title: String,
    val ip: String,
    val port: String,
    val image: String,
    val description: String
)
