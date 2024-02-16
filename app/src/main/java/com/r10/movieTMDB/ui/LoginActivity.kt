package com.r10.movieTMDB.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.r10.movieTMDB.MainActivity
import com.r10.movieTMDB.data.local.UserPreferences
import com.r10.movieTMDB.data.response.ResponseLogin
import com.r10.moviezzz.databinding.ActivityLoginBinding // Impor ActivityLoginBinding
import android.widget.Toast // Impor Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding // Mendeklarasikan variabel binding dengan tipe ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) // Menginisialisasi binding dengan menggunakan metode inflate dari ActivityLoginBinding
        setContentView(binding.root) // Mengatur tampilan utama menggunakan root dari binding

        binding.btnLogin.setOnClickListener {
            submitLogin()
        }
    }

    private fun submitLogin() {
        val username = binding.etUsername.text
        val password = binding.etPassword.text

        if (username.isNotEmpty() && password.isNotEmpty()) {
            val database = UserPreferences(this)
            val user = ResponseLogin()
            user.username = username.toString()
            user.password = password.toString()

            database.setUser(user)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            // Menampilkan pesan toast jika username atau password kosong
            Toast.makeText(this, "Username or password cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }
}


