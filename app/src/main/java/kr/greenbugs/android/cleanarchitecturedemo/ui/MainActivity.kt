package kr.greenbugs.android.cleanarchitecturedemo.ui

import android.os.Bundle
import androidx.navigation.Navigation
import com.afollestad.materialdialogs.MaterialDialog
import dagger.android.support.DaggerAppCompatActivity
import kr.greenbugs.android.cleanarchitecturedemo.R
import kr.greenbugs.android.cleanarchitecturedemo.ui.main.MainFragment
import kr.greenbugs.android.cleanarchitecturedemo.ui.sign.SignFragment

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        navigateToStart()
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.navHostFragment).navigateUp()
    }

    override fun onBackPressed() {
        when(Navigation.findNavController(this, R.id.navHostFragment).currentDestination?.id) {
            R.id.mainFragment-> {
                MaterialDialog(this).show {
                    message(text = "종료하시겠습니까?")
                    positiveButton(text = "예"){
                        finish()
                    }
                    negativeButton(text = "아니오"){
                        dismiss()
                    }
                }
            }
            else -> {
                super.onBackPressed()
            }
        }
    }

    private fun navigateToStart() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                SignFragment.newInstance(),
                SignFragment.FRAGMENT_NAME)
            .commitNow()
    }

    private fun navigateToMain() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                MainFragment.newInstance(),
                MainFragment.FRAGMENT_NAME
            ).commitNow()
    }

}
