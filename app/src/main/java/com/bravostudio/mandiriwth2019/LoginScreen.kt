package com.bravostudio.mandiriwth2019

import android.Manifest
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.fingerprint.FingerprintManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bravostudio.mandiriwth2019.helper.NetworkProvider
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import android.os.StrictMode
import android.widget.Toast
import com.bravostudio.mandiriwth2019.datamodel.Response
import com.bravostudio.mandiriwth2019.helper.UnsafeOkHttpClient
import android.net.Uri.fromParts
import android.support.v4.app.ActivityCompat
import com.bravostudio.mandiriwth2019.helper.FingerprintHandler
import com.bravostudio.mandiriwth2019.helper.HelperCallback
import javax.crypto.Cipher

class LoginScreen : AppCompatActivity(), HelperCallback {

    private val cipher: Cipher? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        button_call_14000.setOnClickListener { view ->
            callHotline()
        }

        button_nearest_atm.setOnClickListener { view ->
            nearestATM()
        }

        buttonMasuk.setOnClickListener { view ->
            tryLogin(this)
        }
    }

    override fun onResume() {
        super.onResume()
        setupFingerprint()
    }

    fun setupFingerprint() {
        // Initializing both Android Keyguard Manager and Fingerprint Manager
        val keyguardManager: KeyguardManager = getSystemService(KEYGUARD_SERVICE) as KeyguardManager
        val fingerprintManager: FingerprintManager = getSystemService(FINGERPRINT_SERVICE) as FingerprintManager

        // Check whether the device has a Fingerprint sensor.
        if(!fingerprintManager.isHardwareDetected()){
            Toast.makeText(this, "Your Device does not have a Fingerprint Sensor", Toast.LENGTH_SHORT).show()
        } else {
            // Checks whether fingerprint permission is set on manifest
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Fingerprint authentication permission not enabled", Toast.LENGTH_SHORT).show()
            } else{
                // Check whether at least one fingerprint is registered
                if (!fingerprintManager.hasEnrolledFingerprints()) {
                    Toast.makeText(this, "Register at least one fingerprint in Settings", Toast.LENGTH_SHORT).show()
                } else{
                    // Checks whether lock screen security is enabled or not
                    if (!keyguardManager.isKeyguardSecure()) {
                        Toast.makeText(this, "Lock screen security not enabled in Settings", Toast.LENGTH_SHORT).show()
                    } else{
                        val cryptoObject = FingerprintManager.CryptoObject(cipher)
                        val helper = FingerprintHandler(this, this)
                        helper.startAuth(fingerprintManager, cryptoObject)
                    }
                }
            }
        }
    }

    fun callHotline() {
        val phone = "14000"
        val intent = Intent(Intent.ACTION_DIAL, fromParts("tel", phone, null))
        startActivity(intent)
    }

    fun nearestATM() {
//        val intent = Intent(this, NearestATMScreen::class.java )
//        startActivity(intent)
    }

    override fun successFingerprint() {
        goToDashboard()
    }

    fun tryLogin(context: Context) {
        if (usernameTextBox.text.toString().equals("ayam") && passwordTextBox.text.toString().equals("goreng")) {
            goToDashboard()
        } else {
            Toast.makeText(context, "Username atau password salah", Toast.LENGTH_SHORT).show()
        }
    }

    fun goToDashboard() {
        val intent = Intent(this, DashboardScreen::class.java)
        startActivity(intent)
    }

    fun hitAPITest() {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apigateway.mandiriwhatthehack.com/gateway/ServicingAPI/1.0/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val retrofitTest = Retrofit.Builder()
            .baseUrl("https://www.google.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val apiService = retrofit.create(NetworkProvider::class.java)

        val response = apiService.getCustomer(1000010289)

        response.enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.isSuccessful) {
                    Log.d("JOUVY", "YUHU: ")
                } else {
                    Log.d("JOUVY", "GAGAL BRE")
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("JOUVY", "GAGAL KONEKSI")
            }
        })
    }
}
