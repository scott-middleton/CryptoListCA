package com.example.crytpolistca.feature_currency_info.domain.repository

import com.example.crytpolistca.feature_currency_info.domain.model.CurrencyInfo
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    suspend fun insertCurrencyInfoList()

    fun getCurrencyInfoList(): Flow<List<CurrencyInfo>>
}