package kr.greenbugs.android.cleanarchitecturedemo.di.provider

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.greenbugs.android.cleanarchitecturedemo.ui.sign.SignFragment

@Module
abstract class StartFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideStartFragment(): SignFragment
}