package kr.greenbugs.android.cleanarchitecturedemo.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import kr.greenbugs.android.cleanarchitecturedemo.presentation.ViewModelFactory

@Module(includes = [(ViewModelsBuilder::class)])
abstract class ViewModelFactoryBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}