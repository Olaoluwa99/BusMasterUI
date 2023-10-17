package com.easit.easino.dmap.ui.entry.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easit.easino.dmap.data.RealmRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpViewModel: ViewModel() {

    private val repo: RealmRepository = RealmRepository()
    //
    private val _emailText = MutableStateFlow("")
    var emailText = _emailText.asStateFlow()

    private val _usernameText = MutableStateFlow("")
    var usernameText = _usernameText.asStateFlow()

    private val _passwordText = MutableStateFlow("")
    var passwordText = _passwordText.asStateFlow()

    private val _registrationSuccessful = MutableStateFlow(false)
    var registrationSuccessful = _registrationSuccessful.asStateFlow()

    private val _loginSuccessful = MutableStateFlow(false)
    var loginSuccessful = _loginSuccessful.asStateFlow()

    private val _createUserSuccessful = MutableStateFlow(false)
    var createUserSuccessful = _createUserSuccessful.asStateFlow()

    //--------------------------------------------------------------
    fun registerUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.registration(
                    password = _passwordText.value,
                    email = _emailText.value).run {
                    withContext(Dispatchers.Main) {
                        _registrationSuccessful.value = true
                        loginUser()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _registrationSuccessful.value = false
                }
            }
        }
    }

    private fun loginUser() = viewModelScope.launch {
        repo.login(emailText.value, passwordText.value).run {//previously "apply"
            withContext(Dispatchers.Main) {
                _loginSuccessful.value = true
                saveUserInfo()
            }
        }
    }

    private fun saveUserInfo() = viewModelScope.launch {
        repo.saveUserInfo(usernameText.value, emailText.value, 0).run {
            withContext(Dispatchers.Main) {
                _createUserSuccessful.value = true
            }
        }
    }

    fun onUsernameTextField(text: String) {
        _usernameText.value = text
    }
    fun onEmailTextField(text: String) {
        _emailText.value = text
    }
    fun onPasswordTextField(text: String) {
        _passwordText.value = text
    }

}