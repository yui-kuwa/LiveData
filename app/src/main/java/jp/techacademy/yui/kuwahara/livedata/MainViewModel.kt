package jp.techacademy.yui.kuwahara.livedata

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // Int型のLiveViewを作成
    val counter: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    // 初期値を0に設定
    init{
        counter.value = 0
    }
}