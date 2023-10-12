package jp.ac.it_college.std.s22007.servicesample

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder

class SoundManageService : Service() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()

        mediaPlayer = MediaPlayer()
    }

    override fun onDestroy() {
        mediaPlayer?.run {
            if (isPlaying){
                stop()
            }
        }
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val mediaFileUri = Uri.parse(
            "android.resource://${packageName}/${R.raw.tanahara2}"
        )
        mediaPlayer?.run {
            setDataSource(this@SoundManageService, mediaFileUri)
            setOnPreparedListener{ onMediaPlayerPrepared() }
            setOnCompletionListener { onPlaybackEnd() }
            prepareAsync()
        }
        return START_NOT_STICKY
    }

    private fun onMediaPlayerPrepared(){
        mediaPlayer?.start()
    }

    private fun onPlaybackEnd(){
        mediaPlayer?.stop()
    }
}