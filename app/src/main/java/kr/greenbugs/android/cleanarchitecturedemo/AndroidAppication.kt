package kr.greenbugs.android.cleanarchitecturedemo

import android.app.Activity
import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kr.greenbugs.android.cleanarchitecturedemo.di.component.DaggerApplicationComponent
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by SHIN on 21/03/2019.
 */
class AndroidApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())

        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector() = activityInjector

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    companion object {

        private val TAG = AndroidApplication::class.java.simpleName
        var instance: AndroidApplication by Delegates.notNull()
    }

}