package com.mokhtar.sarytask.data.repo.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mokhtar.sarytask.util.LANGUAGE_VALUE_AR
import com.mokhtar.sarytask.util.SARY_DATA_STORE_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


val Context.dataStore by preferencesDataStore(SARY_DATA_STORE_NAME)

@ViewModelScoped
class DataStoreRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private object preferencesKeys {
        var languageValue = stringPreferencesKey(LANGUAGE_VALUE_AR)
    }


     suspend fun saveData(
        languageValue: String
    ) {
        context.dataStore.edit { data ->
            data[preferencesKeys.languageValue] = languageValue

        }

    }

    val readData: Flow<SaryDataStore> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException)
                emit(emptyPreferences())
            else
                throw  exception
        }.map { prefrences ->
            prefrences.let {
                val languageValue = prefrences[preferencesKeys.languageValue] ?: "ar"
                SaryDataStore(languageValue)
            }


        }

    data class SaryDataStore(
        val languageValue: String

    )


}