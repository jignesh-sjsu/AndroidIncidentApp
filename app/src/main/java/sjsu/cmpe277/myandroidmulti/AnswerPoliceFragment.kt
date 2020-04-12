package sjsu.cmpe277.myandroidmulti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerPoliceBinding

/**
 * A simple [Fragment] subclass.
 */
class AnswerPoliceFragment : Fragment() {

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
//        return inflater.inflate(R.layout.fragment_answer_police, container, false)

        subtypeOption = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val binding = DataBindingUtil.inflate<FragmentAnswerPoliceBinding>(inflater,
            R.layout.fragment_answer_police, container, false)

        binding.buttonNext.setOnClickListener { view: View ->
            val checkedId = binding.policeRadioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.policeRadioButton1 -> answerIndex = 1
                    R.id.policeRadioButton2 -> answerIndex = 2
                    R.id.policeRadioButton3 -> answerIndex = 3
                    R.id.policeRadioButton4 -> answerIndex = 4
                    R.id.policeRadioButton5 -> answerIndex = 5
                    R.id.policeRadioButton6 -> answerIndex = 6
                }
                when (answerIndex) {
                    1 -> {
                        subtypeOption.subtype.value = "Looting"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerThreeFragment2_to_answerFinalFragment)
                    }
                    2 -> {
                        subtypeOption.subtype.value = "Shots fired"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerThreeFragment2_to_answerFinalFragment)
                    }
                    3 -> {
                        subtypeOption.subtype.value = "Vandalism"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerThreeFragment2_to_answerFinalFragment)
                    }
                    4 -> {
                        subtypeOption.subtype.value = "Assault"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerThreeFragment2_to_answerFinalFragment)
                    }
                    5 -> {
                        subtypeOption.subtype.value = "Gang violence"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerThreeFragment2_to_answerFinalFragment)
                    }
                    else -> {
                        subtypeOption.subtype.value = "Break in"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerThreeFragment2_to_answerFinalFragment)
                    }
                }
            }
        }
        return binding.root
    }

}
