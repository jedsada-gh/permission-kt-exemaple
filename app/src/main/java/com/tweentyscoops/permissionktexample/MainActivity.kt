package com.tweentyscoops.permissionktexample

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.sembozdemir.permissionskt.askPermissions
import com.sembozdemir.permissionskt.handlePermissionsResult

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        askPermissions(Manifest.permission.CAMERA) {
            onDenied {
                Snackbar.make(this@MainActivity.window.decorView.rootView, "onDenied Camera permission", Snackbar.LENGTH_INDEFINITE)
                        .show()
            }
            onGranted {
                Snackbar.make(this@MainActivity.window.decorView.rootView, "onGranted Camera permission", Snackbar.LENGTH_INDEFINITE)
                        .show()
            }
            onShowRationale { req ->
                Snackbar.make(this@MainActivity.window.decorView.rootView, "You should grant Camera permission", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Retry") { req.retry() }
                        .show()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        handlePermissionsResult(requestCode, permissions, grantResults)
    }
}
