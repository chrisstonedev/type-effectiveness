package net.cjstone.pocketmonstertypeeffectiveness

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EffectivenessDao {

    @Query("SELECT * from effectiveness_database ORDER BY attack ASC")
    fun getAlphabetizedWords(): LiveData<List<Effectiveness>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(effectiveness: Effectiveness)

    @Query("DELETE FROM effectiveness_database")
    suspend fun deleteAll()

    @Query("SELECT defense from effectiveness_database WHERE attack = :attackType AND factor = 2")
    fun getSuperEffectiveAgainstTypes(attackType: String): List<String>

}