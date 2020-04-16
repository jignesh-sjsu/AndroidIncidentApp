package sjsu.cmpe277.myandroidmulti

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerMedicalBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AnswerMedicalFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AnswerMedicalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnswerMedicalFragment() : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//    private var listener: OnFragmentInteractionListener? = null

    private lateinit var subtypeOption: AnswerFinalFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_answer_medical, container, false)

        subtypeOption = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val binding = DataBindingUtil.inflate<FragmentAnswerMedicalBinding>(inflater,
            R.layout.fragment_answer_medical,container,false)

        binding.buttonNext.setOnClickListener {view: View ->
            val checkedId = binding.medicalRadioGroup.checkedRadioButtonId
            val checkBox1 = binding.medicalCheckBox1.isChecked
            val checkBox2 = binding.medicalCheckBox2.isChecked
            val checkBox3 = binding.medicalCheckBox3.isChecked
            val checkBox4 = binding.medicalCheckBox4.isChecked
            subtypeOption.additionalTextView1.value = "No of patients:"
            subtypeOption.additionalTextView2.value = binding.editText.text.toString()
            val checkNoOfPatients = binding.editText
                if (-1 != checkedId) {
                    var answerIndex = 0
                    when (checkedId) {
                        R.id.medicalRadioButton1 -> answerIndex = 1
                        R.id.medicalRadioButton2 -> answerIndex = 2
                        R.id.medicalRadioButton3 -> answerIndex = 3
                        R.id.medicalRadioButton4 -> answerIndex = 4
                        R.id.MedicalRadioButton5 -> answerIndex = 5
                    }
                    when (answerIndex) {
                        1 -> {
                            subtypeOption.subtype.value = "Breathing Problem"
                            subtypeOption.medicalPatients.value = binding.editText.text.toString()
                            subtypeOption.medicalFever.value = binding.editText3.text.toString()
                            Navigation.findNavController(view).navigate(R.id.action_answerOneFragment_to_answerFinalFragment)
                        }
                        2 -> {
                            subtypeOption.subtype.value = "Unconscious"
                            Navigation.findNavController(view).navigate(R.id.action_answerOneFragment_to_answerFinalFragment)
                        }
                        3 -> {
                            subtypeOption.subtype.value = "Injury"
                            Navigation.findNavController(view).navigate(R.id.action_answerOneFragment_to_answerFinalFragment)
                        }
                        4 -> {
                            subtypeOption.subtype.value = "Fever"
                            subtypeOption.additionalTextView3.value = "Tempreture:"
                            subtypeOption.additionalTextView4.value = binding.editText3.text.toString()
                            Navigation.findNavController(view).navigate(R.id.action_answerOneFragment_to_answerFinalFragment)
                        }
                        else -> {
                            subtypeOption.subtype.value = "In shock"
                            subtypeOption.additionalTextView3.value = "Type of Shock:"
                            if(checkBox1) {
                                subtypeOption.additionalTextView4.value = "Cold"
                            }
                            if(checkBox2) {
                                subtypeOption.additionalTextView5.value = "Clammy"
                            }
                            if(checkBox3) {
                                subtypeOption.additionalTextView6.value = "Gray Color"
                            }
                            if(checkBox4) {
                                subtypeOption.additionalTextView7.value = "Problem Breathing"
                            }
                            Navigation.findNavController(view).navigate(R.id.action_answerOneFragment_to_answerFinalFragment)
                        }
                    }
                }

        }
        return binding.root
    }
}
