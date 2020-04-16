package sjsu.cmpe277.myandroidmulti


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnswerMedicalViewModel: ViewModel() {

    var numberOfPatients: String? = null

    var feverTempreture: String? = null

    override fun onCleared() {
        super.onCleared()
        Log.i("AnswerMedicalViewModel","MedicalAnswerViewModel destroyed!")
    }
}