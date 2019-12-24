package com.yyz.demo_navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (!arguments?.getString("key").isNullOrBlank()) {
            view?.findViewById<TextView>(R.id.textView2)?.text = arguments?.getString("key")
        }
        view?.findViewById<Button>(R.id.button)
            ?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_homeFragment))
    }
}
