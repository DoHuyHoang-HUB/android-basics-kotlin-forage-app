package com.example.forage.data

import androidx.room.*
import com.example.forage.model.Forageable
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for database interaction.
 */
@Dao
interface ForageableDao {

    @Query("select * from forageable")
    fun getForageables(): Flow<List<Forageable>>

    @Query("select * from forageable where id = :id")
    fun getForageable(id: Long): Flow<Forageable>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(forageable: Forageable)

    @Update
    fun update(forageable: Forageable)

    @Delete
    fun delete(forageable: Forageable)
}
