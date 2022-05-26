package com.baec.texttwist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baec.texttwist.ui.game.Game
import com.baec.texttwist.ui.game.GameViewModel
import com.baec.texttwist.ui.login.LoginFragment
import com.baec.texttwist.ui.theme.TextTwistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextTwistTheme {
                val loginFragment = LoginFragment()
                val gameViewModel = viewModel<GameViewModel>()
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login")
                {
                    composable("login") { loginFragment.LoginScreen(navController = navController) }
                    composable("main") {
                        Game(viewModel = gameViewModel)
                    }
                }
            }
        }
    }
}
