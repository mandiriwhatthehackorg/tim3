package com.bravostudio.mandiriwth2019.helper

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.fingerprint.FingerprintManager
import android.os.CancellationSignal
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import com.bravostudio.mandiriwth2019.DashboardScreen

/**
 * Created by jouvyalifpradewo on 2019-07-20.
 */
open class FingerprintHandler// Constructor
    (private val context: Context, val callback: HelperCallback) : FingerprintManager.AuthenticationCallback() {

    fun startAuth(manager: FingerprintManager, cryptoObject: FingerprintManager.CryptoObject) {
        val cancellationSignal = CancellationSignal()
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.USE_FINGERPRINT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        manager.authenticate(cryptoObject, cancellationSignal, 0, this, null)
    }


    override fun onAuthenticationError(errMsgId: Int, errString: CharSequence) {
        Toast.makeText(context, "Fingerprint Authentication error\n$errString", Toast.LENGTH_SHORT).show()
    }


    override fun onAuthenticationHelp(helpMsgId: Int, helpString: CharSequence) {
        Toast.makeText(context, "Fingerprint Authentication help\n$helpString", Toast.LENGTH_SHORT).show()
    }


    override fun onAuthenticationFailed() {
        Toast.makeText(context, "Fingerprint Authentication failed.", Toast.LENGTH_SHORT).show()
    }


    override fun onAuthenticationSucceeded(result: FingerprintManager.AuthenticationResult) {
        Toast.makeText(context, "Fingerprint Authentication succeeded.", Toast.LENGTH_SHORT).show()
        callback.successFingerprint()
    }
}