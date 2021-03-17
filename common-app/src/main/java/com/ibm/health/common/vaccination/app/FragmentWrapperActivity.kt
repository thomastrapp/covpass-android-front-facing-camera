package com.ibm.health.common.vaccination.app

import android.os.Bundle
import com.ibm.health.common.navigation.android.*
import kotlinx.parcelize.Parcelize

/** Displays a fragment (via a [FragmentNav]) in its own activity. */
@Parcelize
public data class FragmentWrapperActivityNav(val fragmentNav: FragmentNav) :
    IntentNav(FragmentWrapperActivity::class)

/** Displays a fragment (via a [FragmentNav]) in its own activity. */
public class FragmentWrapperActivity : BaseActivity(), NavigatorOwner {

    override val navigator: Navigator = Navigator()

    private val nav by lazy { getArgs<FragmentWrapperActivityNav>().fragmentNav }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null && navigator.isEmpty()) {
            navigator.push(nav)
        }
    }
}