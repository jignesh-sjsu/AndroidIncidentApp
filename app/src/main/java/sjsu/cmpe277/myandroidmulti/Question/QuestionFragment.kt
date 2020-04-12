package sjsu.cmpe277.myandroidmulti.Question

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sjsu.cmpe277.myandroidmulti.AnswerFinalFragmentViewModel
import sjsu.cmpe277.myandroidmulti.R
import sjsu.cmpe277.myandroidmulti.databinding.FragmentQuestionBinding

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [QuestionFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuestionViewModel
    private lateinit var emergencyOption: AnswerFinalFragmentViewModel

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
        //return inflater.inflate(R.layout.fragment_question, container, false)

        emergencyOption = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val binding = DataBindingUtil.inflate<FragmentQuestionBinding>(inflater,
            R.layout.fragment_question,container,false)

        binding.buttonMedical.setOnClickListener {view: View ->
            emergencyOption.emergency.value = "Medical Emergency"
            Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_answerOneFragment2)
        }

        binding.buttonFire.setOnClickListener {view: View ->
            emergencyOption.emergency.value = "Fire Emergency"
            Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_answerTwoFragment2)
        }

        binding.buttonPolice.setOnClickListener {view: View ->
            emergencyOption.emergency.value = "Police Emergency"
            Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_answerThreeFragment2)
        }

        binding.buttonTraffic.setOnClickListener {view: View ->
            emergencyOption.emergency.value = "Traffic Emergency"
            Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_answerTrafficFragment)
        }

        binding.buttonUtility.setOnClickListener {view: View ->
            emergencyOption.emergency.value = "Utility Emergency"
            Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_answerUtilityFragment)
        }

        Log.i("QuestionFragment","Called ViewModelProviders.of")
        //viewModelFactory = QuestionViewModelFactory(QuestionFragmentArgs.fromBundle(arguments!!).score)
        //viewModel = ViewModelProviders.of(this, viewModelFactory).get(QuestionViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //val argscore = QuestionFragmentArgs.fromBundle(savedInstanceState!!).riskscore
        val argscore = QuestionFragmentArgs.fromBundle(arguments!!).riskscore
    }

}
