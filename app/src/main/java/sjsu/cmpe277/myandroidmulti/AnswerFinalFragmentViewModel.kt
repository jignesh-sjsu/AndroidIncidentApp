package sjsu.cmpe277.myandroidmulti

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnswerFinalFragmentViewModel: ViewModel() {

    val emergency = MutableLiveData<String>()
    val subtype = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        Log.i("AnswerFinalFragmentViewModel","FinalAnswerViewModel destroyed!")
    }
}