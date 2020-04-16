package sjsu.cmpe277.myandroidmulti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerMedicalBinding
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerTrappedBinding

/**
 * A simple [Fragment] subclass.
 */
class AnswerTrappedFragment : Fragment() {

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

        subtypeOption = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val binding = DataBindingUtil.inflate<FragmentAnswerTrappedBinding>(inflater,
            R.layout.fragment_answer_trapped,container,false)

        binding.buttonTrappedSubmit.setOnClickListener {view: View ->
            val checkedId = binding.trappedRadioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.trappedRadioButton1 -> answerIndex = 1
                    R.id.trappedRadioButton2 -> answerIndex = 2
                }
                when (answerIndex) {
                    1 -> {
                        subtypeOption.subtype.value = "Injured: Yes"
                        Navigation.findNavController(view).navigate(R.id.action_answerTrappedFragment_to_answerFinalFragment)
                    }
                    else -> {
                        subtypeOption.subtype.value = "Injured: No"
                        Navigation.findNavController(view).navigate(R.id.action_answerTrappedFragment_to_answerFinalFragment)
                    }
                }
            }

        }
        return binding.root
    }

}
