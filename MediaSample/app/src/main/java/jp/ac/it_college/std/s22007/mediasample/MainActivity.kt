package jp.ac.it_college.std.s22007.mediasample

import android.app.Activity
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.view.View
import android.widget.CompoundButton
import jp.ac.it_college.std.s22007.mediasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer()
        val mediaFileUri = Uri.parse(
             "android.resource://${packageName}/${R.raw.tanahara}"
        )
        mediaPlayer?.apply {
            setDataSource(applicationContext,mediaFileUri)
            setOnPreparedListener(::mediaPlayerOnPrepared)
            setOnCompletionListener(::mediaPlayerOnCompletion)
            prepareAsync()
        }
        binding.btPlay.setOnClickListener(::onPlayButtonClick)
        binding.btBack.setOnClickListener(::onBackButtonClick)
        binding.btForward.setOnClickListener(::onForwardButtonClick)
    }
    private fun mediaPlayerOnPrepared(mediaPlayer: MediaPlayer){
        binding.btPlay.isEnabled = true
        binding.btBack.isEnabled = true
        binding.btForward.isEnabled = true
        binding.swLoop.setOnCheckedChangeListener(::onLoopSwitchChanged)
    }
    private fun mediaPlayerOnCompletion(mediaPlayer: MediaPlayer){
        binding.btPlay.setText(R.string.bt_play_play)
    }
    private fun onPlayButtonClick(view: View){
        mediaPlayer?.run {
            if(isPlaying){
                pause()
                binding.btPlay.setText(R.string.bt_play_play)
            }else{
                start()
                binding.btPlay.setText(R.string.bt_play_pause)
            }
        }
    }

    override fun onStop() {
        mediaPlayer?.run {
            if(isPlaying){
                stop()
            }
            release()
        }
        super.onStop()
    }

    private fun onBackButtonClick(view: View) {
        mediaPlayer?.seekTo(0)
    }

    private fun onForwardButtonClick(view: View){
        mediaPlayer?.run {
            seekTo(duration)
            if (!isPlaying){
                binding.btPlay.setText(R.string.bt_play_pause)
                start()
            }
        }
    }
    private fun onLoopSwitchChanged(buttonView: CompoundButton, isChecked: Boolean){
        mediaPlayer?.isLooping = isChecked
    }
}