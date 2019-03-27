package kr.greenbugs.android.cleanarchitecturedemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kr.greenbugs.android.cleanarchitecturedemo.R
import kr.greenbugs.android.cleanarchitecturedemo.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    private lateinit var fragmentMainBinding: FragmentMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        fragmentMainBinding.mainViewModel = viewModel

        arguments?.let {
            val arguments = MainFragmentArgs.fromBundle(it)
            fragmentMainBinding.mainMessage.text = arguments.title
        }

        return fragmentMainBinding.root
    }

    companion object {

        val FRAGMENT_NAME = MainFragment::class.java.name

        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }





}
