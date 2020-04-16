package sjsu.cmpe277.myandroidmulti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerFireBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AnswerFireFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AnswerFireFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnswerFireFragment : Fragment() {
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
        //return inflater.inflate(R.layout.fragment_answer_fire, container, false)

        subtypeOption = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val binding = DataBindingUtil.inflate<FragmentAnswerFireBinding>(inflater,
            R.layout.fragment_answer_fire,container,false)

        binding.buttonNext.setOnClickListener {view: View ->
            val checkedId = binding.fireRadioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.fireRadioButton1 -> answerIndex = 1
                    R.id.fireRadioButton2 -> answerIndex = 2
                    R.id.fireRadioButton3 -> answerIndex = 3
                }
                when (answerIndex) {
                    1 -> {
                        subtypeOption.subtype.value = "Collapsed building"
                        subtypeOption.additionalTextView1.value = "No of buildings"
                        subtypeOption.additionalTextView2.value = binding.editText4.text.toString()
                        Navigation.findNavController(view).navigate(R.id.action_answerTwoFragment_to_answerFinalFragment)
                    }
                    2 -> {
                        subtypeOption.subtype.value = "Trapped people"
                        Navigation.findNavController(view).navigate(R.id.action_answerTwoFragment_to_answerFinalFragment)
                    }
                    else -> {
                        subtypeOption.subtype.value = "Fire near chemical/hazardous material"
                        subtypeOption.additionalTextView1.value = "Name of chemical"
                        subtypeOption.additionalTextView2.value = binding.chemicalsAnswer.text.toString()
                        Navigation.findNavController(view).navigate(R.id.action_answerTwoFragment_to_answerFinalFragment)
                    }
                }
            }
        }
        return binding.root
    }


}
