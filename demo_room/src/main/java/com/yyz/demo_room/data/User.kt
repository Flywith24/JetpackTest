package com.yyz.demo_room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author yyz (杨云召)
 * @date   2019-12-29
 * time   21:29
 * description
 */

@Entity
data class User(
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}