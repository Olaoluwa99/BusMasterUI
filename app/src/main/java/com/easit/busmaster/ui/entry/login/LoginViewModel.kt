package com.easit.easino.dmap.ui.entry.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easit.easino.dmap.data.RealmRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel: ViewModel() {

    private val repo: RealmRepository = RealmRepository()

    private val _emailText = MutableStateFlow("")
    var emailText = _emailText.asStateFlow()

    private val _passwordText = MutableStateFlow("")
    var passwordText = _passwordText.asStateFlow()

    private val _loginState = MutableStateFlow(0)
    var loginState = _loginState.asStateFlow()

    fun loginUser() {
        _loginState.value = 1
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.login(
                    password = _passwordText.value,
                    email = _emailText.value).run {
                    withContext(Dispatchers.Main) {
                        _loginState.value = 2
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _loginState.value = 3
                }
            }
        }
    }

    fun onEmailTextField(text: String) {
        _emailText.value = text
    }
    fun onPasswordTextField(text: String) {
        _passwordText.value = text
    }

}