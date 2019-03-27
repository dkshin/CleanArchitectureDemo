package kr.greenbugs.android.cleanarchitecturedemo.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel(){

    private val TAG = SplashViewModel::class.java.simpleName

    private val compositeDisposable = CompositeDisposable()

    private var lastDisposable: Disposable? = null
    private var delaySingle :Single<Boolean>

    var isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
        delaySingle = Single.just(true).delay(2000, TimeUnit.MILLISECONDS)
    }

    fun startLoading() {
        execute(
            onSuccess = {
                isLoad.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    private fun execute(
        onSuccess: ((t: Boolean) -> Unit),
        onError: ((t: Throwable) -> Unit),
        onFinished: () -> Unit = {}
    ) {
        disposeLast()
        lastDisposable = delaySingle
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(onFinished)
            .subscribe(onSuccess, onError)
        lastDisposable?.let {
            compositeDisposable.add(it)
        }
    }

    private fun disposeLast() {
        lastDisposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
