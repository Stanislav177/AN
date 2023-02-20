package com.example.an

data class EntityServerBloodMine(
    val servers: List<EntityServers>,
)

data class EntityServers(
    var numberServer: String,
    val fields: List<EntityField>? = null
)

data class EntityField(
    val title: String,
    val ip: String,
    val port: String,
    val image: String,
    val description: String
)