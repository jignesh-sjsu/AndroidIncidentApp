package sjsu.cmpe277.myandroidmulti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_answer_final.*
import sjsu.cmpe277.myandroidmulti.Question.QuestionFragment
import sjsu.cmpe277.myandroidmulti.Title.TitleViewModel
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerFinalBinding

/**
 * A simple [Fragment] subclass.
 */
class AnswerFinalFragment : Fragment() {

    private lateinit var binding: FragmentAnswerFinalBinding
    private lateinit var viewModel: AnswerFinalFragmentViewModel
    private lateinit var name: TitleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//            questionFragment.questionIncident.observe()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_answer_final, container, false)

        binding = DataBindingUtil.inflate<FragmentAnswerFinalBinding>(inflater,
            R.layout.fragment_answer_final, container, false)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        name = activity?.run {
            ViewModelProviders.of(this).get(TitleViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModel.emergency.observe(viewLifecycleOwner, Observer { newEmergency ->
            binding.textViewEmergency.text = newEmergency.toString()
        })

        viewModel.subtype.observe(viewLifecycleOwner, Observer { newSubtype ->
            binding.textViewEmergencySubtype.text = newSubtype.toString()
        })

        name.yourname.observe(viewLifecycleOwner, Observer { newName ->
            binding.textViewName.text = newName.toString()
        })

        viewModel.phoneNumber.observe(viewLifecycleOwner, Observer { newPhoneNumber ->
            binding.textViewPhoneNumber.text = newPhoneNumber.toString()
        })


      binding.buttonThankyou.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_answerFinalFragment_to_titleFragment)
        }
        return binding.root
    }
}
