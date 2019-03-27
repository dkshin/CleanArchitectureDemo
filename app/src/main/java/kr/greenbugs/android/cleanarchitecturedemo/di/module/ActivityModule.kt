package kr.greenbugs.android.cleanarchitecturedemo.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kr.greenbugs.android.cleanarchitecturedemo.di.provider.MainFragmentProvider
import kr.greenbugs.android.cleanarchitecturedemo.di.provider.StartFragmentProvider
import kr.greenbugs.android.cleanarchitecturedemo.ui.MainActivity
import kr.greenbugs.android.cleanarchitecturedemo.ui.splash.SplashActivity

@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityModule {

    @ContributesAndroidInjector
    fun splashActivityInjector(): SplashActivity

    @ContributesAndroidInjector(
        modules = [
            StartFragmentProvider::class,
            MainFragmentProvider::class
        ])
    fun mainActivityInjector(): MainActivity




}