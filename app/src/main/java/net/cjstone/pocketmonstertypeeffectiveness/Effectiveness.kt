package net.cjstone.pocketmonstertypeeffectiveness

import androidx.room.Entity

@Entity(tableName = "effectiveness_database", primaryKeys = ["attack", "defense"])
data class Effectiveness (
    val attack: String,
    val defense: String,
    val factor: Float
)