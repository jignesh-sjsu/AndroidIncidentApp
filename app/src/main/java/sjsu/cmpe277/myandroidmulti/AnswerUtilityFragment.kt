package sjsu.cmpe277.myandroidmulti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerUtilityBinding


/**
 * A simple [Fragment] subclass.
 */
class AnswerUtilityFragment : Fragment() {

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
        // return inflater.inflate(R.layout.fragment_answer_utility, container, false)

        subtypeOption = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val binding = DataBindingUtil.inflate<FragmentAnswerUtilityBinding>(inflater,
            R.layout.fragment_answer_utility, container, false)

        binding.buttonNext.setOnClickListener { view: View ->
            val checkedId = binding.utilityRadioGroup.checkedRadioButtonId
            val checkBox1 = binding.outageCheckBox1.isChecked
            val checkBox2 = binding.outageCheckBox1.isChecked
            val checkBox3 = binding.outageCheckBox1.isChecked
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.utilityRadioButton1 -> answerIndex = 1
                    R.id.utilityRadioButton2 -> answerIndex = 2
                    R.id.utilityRadioButton3 -> answerIndex = 3
                    R.id.utilityRadioButton4 -> answerIndex = 4
                }
                when (answerIndex) {
                    1 -> {
                        subtypeOption.subtype.value = "Power out"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerUtilityFragment_to_answerFinalFragment)
                    }
                    2 -> {
                        subtypeOption.subtype.value = "Water main break"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerUtilityFragment_to_answerFinalFragment)
                    }
                    3 -> {
                        subtypeOption.subtype.value = "Gas main break"
                        Navigation.findNavController(view).navigate(R.id.action_answerUtilityFragment_to_answerFinalFragment)
                    }
                    else -> {
                        subtypeOption.subtype.value = "Internet and telephone outage"
                        subtypeOption.additionalTextView1.value = "Lines affected by Outage:"
                        if(checkBox1) {
                            subtypeOption.additionalTextView2.value = "Land Line"
                        }
                        if(checkBox2) {
                            subtypeOption.additionalTextView4.value = "Cell Phone"
                        }
                        if(checkBox3) {
                            subtypeOption.additionalTextView5.value = "Internet"
                        }
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerUtilityFragment_to_answerFinalFragment)
                    }
                }
            }
        }
        return binding.root
    }

}
