package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hanks.passcodeview.PasscodeView

class MainPasscode : AppCompatActivity() {

    private lateinit var passcodeView: PasscodeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_passcode)

        passcodeView = findViewById(R.id.passcodeView)

        passcodeView.setPasscodeLength(4)
            .setLocalPasscode("1234")
            .setListener(object : PasscodeView.PasscodeViewListener {
                override fun onFail() {
                    Toast.makeText(this@MainPasscode, "Password is Wrong", Toast.LENGTH_SHORT).show()
                }

                override fun onSuccess(number: String) {
                    startActivity(Intent(this@MainPasscode, MainActivity::class.java))
                }
            })
    }
}