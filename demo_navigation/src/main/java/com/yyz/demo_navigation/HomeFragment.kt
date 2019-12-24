package com.yyz.demo_navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.findViewById<Button>(R.id.button)
            ?.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_homeFragment_to_detailFragment,
                    Bundle().apply {
                        putString(
                            "key",
                            view?.findViewById<EditText>(R.id.etContent)?.text.toString().trim()
                        )
                    }
                )
            }
    }
}
