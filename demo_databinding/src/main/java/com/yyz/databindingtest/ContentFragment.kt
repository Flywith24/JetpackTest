package com.yyz.databindingtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.button.MaterialButton

/**
 * @author yyz (杨云召)
 * @date   2019/12/19
 * time   17:39
 * description
 */
class ContentFragment : Fragment() {
    private lateinit var mRedPointViewModel: RedPointViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_content, container, false)
        mRedPointViewModel = ViewModelProviders.of(requireActivity()).get(RedPointViewModel::class.java)

        val textView = view.findViewById<TextView>(R.id.textView).apply {
            text = arguments?.getString(KEY)
        }
        view.findViewById<MaterialButton>(R.id.show).setOnClickListener {
            Log.i("yyz", "show")
            mRedPointViewModel.redPoint.set(true)
        }
        view.findViewById<MaterialButton>(R.id.dismiss).setOnClickListener {
            Log.i("yyz", "dismiss")
            mRedPointViewModel.redPoint.set(false)
        }
        textView.text = "${arguments?.getString(KEY)} ${mRedPointViewModel.redPoint.get()}"
        return view
    }


    companion object {
        const val KEY = "KEY"

        fun newInstance(content: String): Fragment {
            val fragmet = ContentFragment()
            val bundle = Bundle()
            bundle.putString(KEY, content)
            fragmet.arguments = bundle
            return fragmet
        }
    }
}