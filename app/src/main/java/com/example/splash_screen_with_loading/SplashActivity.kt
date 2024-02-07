package com.example.splash_screen_with_loading

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startHeavyTask()
    }
    private fun startHeavyTask() {
        LongOperation().execute()
    }
    //when we create a class inside another class then we use inner class keyword
    private open inner class LongOperation : AsyncTask<String?, Void?, String?>(){
        override fun doInBackground(vararg p0: String?): String? {
            for (i in 0.. 6){
                try{
                    Thread.sleep(1000)
                }
                catch (e: Exception){
                    Thread.interrupted()
                }
            }
            return "result"
        }

        //calling postExecute, basically what we have to do after first function completes, so onPostExecute
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}