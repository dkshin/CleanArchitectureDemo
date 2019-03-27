package kr.greenbugs.android.cleanarchitecturedemo.domain.repository

import io.reactivex.Single

interface SignRepository {

    fun isAlreadyAccount(): Single<Boolean>
}