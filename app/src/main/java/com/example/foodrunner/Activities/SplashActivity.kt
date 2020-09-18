package com.example.foodrunner.Activities

import android.animation.Animator
import android.animation.AnimatorSet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.foodrunner.R
import java.lang.Exception
import java.util.prefs.Preferences

class SplashActivity : AppCompatActivity() {
 private  lateinit var preferences: com.example.foodrunner.Util.Preferences
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        preferences = com.example.foodrunner.Util.Preferences(this)
        imageView= findViewById(R.id.imageView)


        val background= object: Thread(){

            override fun run() {
                try {
                    sleep(5000)

                 /* here we are asking whether the user was logged in or out during his last work on app,if the user
                    logged out last time then, we go to login activity else we transit straight to main activity
                 */
                    if (preferences.isLoggedIn()) {
                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        val intent = Intent(baseContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
    background.start()
    }
    override fun onPause() {
        super.onPause()
        finish()

    }

}
