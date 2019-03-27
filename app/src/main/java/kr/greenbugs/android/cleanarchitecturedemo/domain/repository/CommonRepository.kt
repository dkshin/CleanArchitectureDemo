package kr.greenbugs.android.cleanarchitecturedemo.domain.repository

import io.reactivex.Single

interface CommonRepository {

    fun getLoading(): Single<Boolean>
}