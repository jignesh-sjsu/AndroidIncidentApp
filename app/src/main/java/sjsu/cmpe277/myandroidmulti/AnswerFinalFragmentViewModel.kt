package sjsu.cmpe277.myandroidmulti

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnswerFinalFragmentViewModel: ViewModel() {

    val emergency = MutableLiveData<String>()
    val subtype = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()
    val medicalPatients = MutableLiveData<String>()
    val medicalFever = MutableLiveData<String>()
    val additionalTextView1 = MutableLiveData<String>()
    val additionalTextView2 = MutableLiveData<String>()
    val additionalTextView3 = MutableLiveData<String>()
    val additionalTextView4 = MutableLiveData<String>()

    init {
        Log.i("QuestionViewModel", "QuestionViewModel created!")
        emergency.value = ""
        subtype.value = ""
        name.value = ""
        phoneNumber.value = ""
        medicalPatients.value = ""
        medicalFever.value = ""
        additionalTextView1.value = ""
        additionalTextView2.value = ""
        additionalTextView3.value = ""
        additionalTextView4.value = ""

    }

    override fun onCleared() {
        super.onCleared()
        Log.i("AnswerFinalFragmentViewModel","FinalAnswerViewModel destroyed!")
    }
}