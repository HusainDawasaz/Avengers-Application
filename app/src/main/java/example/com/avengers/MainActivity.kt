package example.com.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    lateinit var btnLogin: Button

    val vaildMobileNumber ="111155555"
    val vaildPassword = arrayOf("Tony", "Steve", "Thor", "Hulk")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_main)

        if (isLoggedIn) {
            val intent = Intent(this@MainActivity, avengers_profile::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            val nameOfAvengers: String
            val intent = Intent(this@MainActivity, avengers_profile::class.java)



            if (vaildMobileNumber == mobileNumber){


                    if (password == vaildPassword[0]){

                        nameOfAvengers = "Iron Man"
                        savedPreferences(nameOfAvengers)
                        startActivity(intent)
                    }

                    else if (password == vaildPassword[1]){

                        nameOfAvengers = "Steve Rogers"
                        savedPreferences(nameOfAvengers)
                        startActivity(intent)
                    }
                    else if (password == vaildPassword[2]){

                        nameOfAvengers = "Thor"
                        savedPreferences(nameOfAvengers)
                        startActivity(intent)
                    }

                    else if (password == vaildPassword[3]){

                        nameOfAvengers = "Avengers"
                        savedPreferences(nameOfAvengers)
                        startActivity(intent)
                    }


                else{
                    Toast.makeText(this@MainActivity, "Incorrect Credentials", Toast.LENGTH_SHORT)
                        .show()

                }
            }
        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savedPreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}