package jp.techacademy.yui.kuwahara.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainViewModel()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        textView.text = viewModel.counter.toString()

        textView.setOnClickListener {
            viewModel.counter.value = viewModel.counter.value!! + 1
            textView.text = viewModel.counter.toString()
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.counter.observe(this, Observer {
            Log.d("kotlintest",it.toString())

            // 更新を受け取ったらTextViewを更新
            textView.text = viewModel.counter.toString()
        })
    }
}