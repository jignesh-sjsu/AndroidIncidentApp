package sjsu.cmpe277.myandroidmulti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import sjsu.cmpe277.myandroidmulti.databinding.FragmentAnswerFinalBinding

/**
 * A simple [Fragment] subclass.
 */
class AnswerFinalFragment : Fragment() {

//    lateinit var followerChannel: NotificationChannel

//    private lateinit var binding: FragmentAnswerFinalBinding
    private lateinit var viewModel: AnswerFinalFragmentViewModel

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

//        followerChannel = FOLLOWERS_CHANNEL_ID; "followers"; NotificationManager.IMPORTANCE_DEFAULT

        val binding = DataBindingUtil.inflate<FragmentAnswerFinalBinding>(inflater,
            R.layout.fragment_answer_final, container, false)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(AnswerFinalFragmentViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModel.emergency.observe(viewLifecycleOwner, Observer { newEmergency ->
            binding.textViewEmergency.text = newEmergency.toString()
        })

        viewModel.subtype.observe(viewLifecycleOwner, Observer { newSubtype ->
            binding.textViewEmergencySubtype.text = newSubtype.toString()
        })

        viewModel.name.observe(viewLifecycleOwner, Observer { newName ->
            binding.textViewName.text = newName.toString()
        })

        viewModel.additionalTextView1.observe(viewLifecycleOwner, Observer { tv12 ->
            binding.textView12.text = tv12.toString()
        })

        viewModel.additionalTextView2.observe(viewLifecycleOwner, Observer { tv13 ->
            binding.textView13.text = tv13.toString()
        })

        viewModel.additionalTextView3.observe(viewLifecycleOwner, Observer { tv15 ->
            binding.textView15.text = tv15.toString()
        })

        viewModel.additionalTextView4.observe(viewLifecycleOwner, Observer { tv16 ->
            binding.textView16.text = tv16.toString()
        })

        viewModel.additionalTextView5.observe(viewLifecycleOwner, Observer { tv17 ->
            binding.textView17.text = tv17.toString()
        })

        viewModel.additionalTextView6.observe(viewLifecycleOwner, Observer { tv18 ->
            binding.textView18.text = tv18.toString()
        })

        viewModel.additionalTextView7.observe(viewLifecycleOwner, Observer { tv19 ->
            binding.textView19.text = tv19.toString()
        })

        viewModel.phoneNumber.observe(viewLifecycleOwner, Observer { newPhoneNumber ->
            binding.textViewPhoneNumber.text = newPhoneNumber.toString()
        })

        binding.buttonThankyou.setOnClickListener { view: View ->
            viewModel.emergency.value = ""
            viewModel.subtype.value = ""
            viewModel.name.value = ""
            viewModel.phoneNumber.value = ""
            viewModel.medicalPatients.value = ""
            viewModel.medicalFever.value = ""
            viewModel.additionalTextView1.value = ""
            viewModel.additionalTextView2.value = ""
            viewModel.additionalTextView3.value = ""
            viewModel.additionalTextView4.value = ""
            viewModel.additionalTextView5.value = ""
            viewModel.additionalTextView6.value = ""
            viewModel.additionalTextView7.value = ""

          Navigation.findNavController(view).navigate(R.id.action_answerFinalFragment_to_titleFragment)
        }

        return binding.root
    }

}
