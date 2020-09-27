package com.rsh_engineering.tkachenkoni.coroutinesroomdb.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 *
 * Created by Nikolay Tkachenko on 27, September, 2020
 *
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM user WHERE username = :username")
    suspend fun getUser(username: String): User

    @Query("DELETE FROM user WHERE id = :id")
    suspend fun deleteUser(id: Long)
}