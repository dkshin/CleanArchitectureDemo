package kr.greenbugs.android.cleanarchitecturedemo.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import kr.greenbugs.android.cleanarchitecturedemo.AndroidApplication
import kr.greenbugs.android.cleanarchitecturedemo.di.module.ActivityModule
import kr.greenbugs.android.cleanarchitecturedemo.di.module.ApplicationModule
import kr.greenbugs.android.cleanarchitecturedemo.di.module.NetworkModule
import kr.greenbugs.android.cleanarchitecturedemo.di.module.SignModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        NetworkModule::class,
        SignModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: AndroidApplication)
}