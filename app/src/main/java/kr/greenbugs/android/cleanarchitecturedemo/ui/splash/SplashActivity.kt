package kr.greenbugs.android.cleanarchitecturedemo.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import kr.greenbugs.android.cleanarchitecturedemo.R
import kr.greenbugs.android.cleanarchitecturedemo.databinding.ActivitySplashBinding
import kr.greenbugs.android.cleanarchitecturedemo.ui.MainActivity
import javax.inject.Inject
/**
 * Created by SHIN on 26/03/2019.
 */
class SplashActivity : DaggerAppCompatActivity() {

    private val TAG = SplashActivity::class.java.simpleName

    private lateinit var activitySplashBinding: ActivitySplashBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SplashViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        activitySplashBinding.splashViewModel = viewModel

        viewModel.isLoad.observe(this, Observer {
//            activitySplashBinding.progressBar.visibility = if (it!!) View.GONE else View.VISIBLE
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        viewModel.startLoading()
    }
}