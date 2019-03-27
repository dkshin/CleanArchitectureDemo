package kr.greenbugs.android.cleanarchitecturedemo.data.repository

import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single
import kr.greenbugs.android.cleanarchitecturedemo.domain.repository.SignRepository
import java.util.concurrent.TimeUnit

/**
 * Created by SHIN on 25/03/2019.
 */
class SignRepositoryImp() : SignRepository {

    override fun isAlreadyAccount(): Single<Boolean> {
        return Single
            .just(true)
            .delay(2000, TimeUnit.MILLISECONDS)
            .flatMap {
                Single.fromCallable { FirebaseAuth.getInstance().currentUser != null
                }
            }
    }

}