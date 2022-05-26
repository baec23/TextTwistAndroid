package com.baec.texttwist.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class LoginViewModel
{
    var loginId by mutableStateOf("")
    var password by mutableStateOf("")

    fun checkIfLoginIdValid(): Boolean
    {
        return loginId.length > 3
    }

    fun tryLogin()
    {

    }
}