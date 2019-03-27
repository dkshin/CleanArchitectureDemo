package kr.greenbugs.android.cleanarchitecturedemo.di.provider

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.greenbugs.android.cleanarchitecturedemo.ui.main.MainFragment

@Module
abstract class MainFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideMainFragment(): MainFragment
}