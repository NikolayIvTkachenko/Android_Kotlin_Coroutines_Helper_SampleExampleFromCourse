package com.rsh_engineering.tkachenkoni.coroutinesroomdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * Created by Nikolay Tkachenko on 27, September, 2020
 *
 */

@Entity
data class User(
    val username: String,

    @ColumnInfo(name = "password_hash")
    val passwordHash: Int,

    val info: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}