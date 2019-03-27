package kr.greenbugs.android.cleanarchitecturedemo.ui.sign

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.orhanobut.logger.Logger
import dagger.android.support.DaggerFragment
import kr.greenbugs.android.cleanarchitecturedemo.R
import kr.greenbugs.android.cleanarchitecturedemo.databinding.FragmentSignBinding
import javax.inject.Inject

class SignFragment : DaggerFragment() {
    private val TAG = SignFragment::class.java.simpleName

    private lateinit var fragmentSignBinding: FragmentSignBinding
    private lateinit var firebaseAuth: FirebaseAuth

    @Inject
    lateinit var googleSignInOptions: GoogleSignInOptions
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SignViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SignViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.w("onCreate")
        firebaseAuth = FirebaseAuth.getInstance()
        viewModel.startSign()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logger.w("onCreateView")
        fragmentSignBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign, container, false)
        fragmentSignBinding.signViewModel = viewModel
        viewModel.isSigned.observe(this, Observer {
            Logger.w("user isAlready ? : $it")
            if (it) {
                Logger.w("이미존재")
                var user = firebaseAuth.currentUser
                var testText = "이미존재... : ${user?.displayName}"
                val directions = SignFragmentDirections.actionSignToMain()
                directions.title = testText
                Navigation.findNavController(fragmentSignBinding.root).navigate(directions)
            } else {
                Logger.w("로그인진행")
                doGoogleSignIn()
            }
        })

        return fragmentSignBinding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Logger.w("onActivityResult")
        if (requestCode == RC_SIGN_IN) {
            var task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                var account = task.getResult(ApiException::class.java)
                var credential = GoogleAuthProvider.getCredential(account?.idToken, null)
                firebaseAuth.signInWithCredential(credential).addOnCompleteListener(activity!!) { task ->
                    if (task.isSuccessful) {
                        val user = firebaseAuth.currentUser
                        updateUI(user)
                    }else{
                        updateUI(null)
                    }
                }
            } catch (e: ApiException) {
                updateUI(null)
                FirebaseAuth.getInstance().signOut()
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        user?.let {
            Logger.w("로긴완료")
            viewModel.doSignIn(it.uid)

            var testText = "로긴완료 : ${it.displayName}"
            val directions = SignFragmentDirections.actionSignToMain()
            directions.title = testText
            Navigation.findNavController(fragmentSignBinding.root).navigate(directions)
        }
//        if (user != null) {
//            Logger.w("로긴완료")
//            viewModel.doSignIn(user.uid)
//
//            var testText = "로긴완료 : ${user.displayName}"
//            val directions = SignFragmentDirections.actionSignToMain()
//            directions.title = testText
//            Navigation.findNavController(fragmentSignBinding.root).navigate(directions)
//        } else {
//            //showRetryDialog()
//        }
    }

    private fun doGoogleSignIn() {
        var googleSignInClient = GoogleSignIn.getClient(activity!!, googleSignInOptions)
        startActivityForResult(googleSignInClient.signInIntent, RC_SIGN_IN)
    }

    companion object {

        val FRAGMENT_NAME = SignFragment::class.java.name
        const val RC_SIGN_IN = 9001

        @JvmStatic
        fun newInstance() =
            SignFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}