package kr.greenbugs.android.cleanarchitecturedemo.data.repository

import io.reactivex.Single
import kr.greenbugs.android.cleanarchitecturedemo.domain.repository.CommonRepository
import java.util.concurrent.TimeUnit

/**
 * Created by SHIN on 25/03/2019.
 */
class CommonRepositoryImp() :
    CommonRepository {

    override fun getLoading(): Single<Boolean> {
        return Single.just(true).delay(5000, TimeUnit.MILLISECONDS)
    }

}