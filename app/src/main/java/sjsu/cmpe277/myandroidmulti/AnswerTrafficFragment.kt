package sjsu.cmpe277.myandroidmulti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerTrafficBinding


/**
 * A simple [Fragment] subclass.
 */
class AnswerTrafficFragment : Fragment() {

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
        // return inflater.inflate(R.layout.fragment_answer_traffic, container, false)

        subtypeOption = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val binding = DataBindingUtil.inflate<FragmentAnswerTrafficBinding>(
            inflater,
            R.layout.fragment_answer_traffic, container, false)

        binding.buttonNext.setOnClickListener { view: View ->
            val checkedId = binding.trafficRadioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.trafficRadioButton1 -> answerIndex = 1
                    R.id.trafficRadioButton2 -> answerIndex = 2
                    R.id.trafficRadioButton3 -> answerIndex = 3
                }
                when (answerIndex) {
                    1 -> {
                        subtypeOption.subtype.value = "Accident"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerTrafficFragment_to_answerFinalFragment)
                    }
                    2 -> {
                        subtypeOption.subtype.value = "Road damage"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerTrafficFragment_to_answerFinalFragment)
                    }
                    else -> {
                        subtypeOption.subtype.value = "Road impassable"
                        Navigation.findNavController(view)
                            .navigate(R.id.action_answerTrafficFragment_to_answerFinalFragment)
                    }
                }
            }
        }
        return binding.root
    }

}
