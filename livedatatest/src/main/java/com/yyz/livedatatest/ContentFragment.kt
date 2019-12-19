package com.yyz.livedatatest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * @author yyz (杨云召)
 * @date   2019/12/19
 * time   17:39
 * description
 */
class ContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_content, container, false)
        view.findViewById<TextView>(R.id.textView).apply {
            text = arguments?.getString(KEY)

        }
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