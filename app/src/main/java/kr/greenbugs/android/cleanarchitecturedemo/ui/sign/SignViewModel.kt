package kr.greenbugs.android.cleanarchitecturedemo.ui.sign

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.greenbugs.android.cleanarchitecturedemo.domain.usecase.GetSignUseCase
import javax.inject.Inject

class SignViewModel @Inject constructor(private val getSignUseCase: GetSignUseCase) : ViewModel(){

    private val TAG = SignViewModel::class.java.simpleName

    var isLoad = MutableLiveData<Boolean>()
    var isSigned = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
//        isSigned.value = false
    }

    fun startSign(){
        getSignUseCase.execute(
            onSuccess = {
                isLoad.value = true
                isSigned.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun doSignIn(uid: String) {

    }

    override fun onCleared() {
        getSignUseCase.clear()
        super.onCleared()
    }


}
