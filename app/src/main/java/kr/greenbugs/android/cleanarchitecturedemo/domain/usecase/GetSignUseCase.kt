package kr.greenbugs.android.cleanarchitecturedemo.domain.usecase

import io.reactivex.Single
import kr.greenbugs.android.cleanarchitecturedemo.domain.repository.SignRepository
import kr.greenbugs.android.cleanarchitecturedemo.usecase.base.SingleUseCase
import javax.inject.Inject

/**
 * Created by SHIN on 25/03/2019.
 */
class GetSignUseCase @Inject constructor(private val repository: SignRepository) : SingleUseCase<Boolean>() {

    override fun buildUseCaseSingle(): Single<Boolean> {
        return repository.isAlreadyAccount()
    }
}