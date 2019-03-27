package kr.greenbugs.android.cleanarchitecturedemo.di.builder

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kr.greenbugs.android.cleanarchitecturedemo.di.ViewModelKey
import kr.greenbugs.android.cleanarchitecturedemo.ui.main.MainViewModel
import kr.greenbugs.android.cleanarchitecturedemo.ui.splash.SplashViewModel
import kr.greenbugs.android.cleanarchitecturedemo.ui.sign.SignViewModel

@Module
abstract class ViewModelsBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignViewModel::class)
    abstract fun bindStartViewModel(signViewModel: SignViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(PhotosViewModel::class)
//    abstract fun bindPhotosViewModel(photosViewModel: PhotosViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(PhotoDetailViewModel::class)
//    abstract fun bindPhotoDetailViewModel(photoDetailViewModel: PhotoDetailViewModel): ViewModel

}