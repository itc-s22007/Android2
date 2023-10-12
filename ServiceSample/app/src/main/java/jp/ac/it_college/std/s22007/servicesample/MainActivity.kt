package jp.ac.it_college.std.s22007.servicesample

import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.it_college.std.s22007.servicesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPlay.setOnClickListener{ startSoundManagerService() }
        binding.btStop.setOnClickListener{ stopSoundManagerService() }
    }

    private fun startSoundManagerService(){
        val intent = Intent(this, SoundManageService::class.java)
        startService(intent)
        binding.btPlay.isEnabled = false
        binding.btStop.isEnabled = true
    }
    private fun stopSoundManagerService(){
        val intent = Intent(this, SoundManageService::class.java)
        stopService(intent)
        binding.btPlay.isEnabled = false
        binding.btStop.isEnabled = true
    }
}