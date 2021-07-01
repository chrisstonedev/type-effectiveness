package net.cjstone.pocketmonstertypeeffectiveness

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class EffectivenessRepository(private val effectivenessDao: EffectivenessDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Effectiveness>> = effectivenessDao.getAlphabetizedWords()

    suspend fun insert(effectiveness: Effectiveness) {
        effectivenessDao.insert(effectiveness)
    }
}