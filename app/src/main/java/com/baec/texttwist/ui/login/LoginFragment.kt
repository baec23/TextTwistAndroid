package com.baec.texttwist.ui.login

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

class LoginFragment {
    val loginViewModel = LoginViewModel()

    @Composable
    fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
        var usernameTextState by remember { mutableStateOf("") }
        var passwordTextState by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                EditTextBox(label = "Username",
                    text = usernameTextState,
                    onTextChange = { changedText: String ->
                        usernameTextState = changedText
                    })
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                EditTextBox(label = "Password",
                    text = passwordTextState,
                    onTextChange = { changedText: String ->
                        passwordTextState = changedText
                    })
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            loginViewModel.loginId = usernameTextState
                            loginViewModel.password = passwordTextState
                            Log.d(
                                "DEBUG:LoginFragment", "Login Button Clicked\n" +
                                        "Username= ${loginViewModel.loginId}\n" +
                                        "Password= ${loginViewModel.password}"
                            )
                            navController.navigate("main")
                        })
                    {
                        Text("Login")
                    }
                }
            }
        }
    }

    @Composable
    fun EditTextBox(label: String, text: String = "", onTextChange: (String) -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            TextField(
                value = text,
                onValueChange = {
                    onTextChange(it)
                },
                label = { Text(label) },
                maxLines = 1,
            )
        }
    }
}