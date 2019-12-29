package com.yyz.demo_room

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.yyz.demo_room.data.User
import com.yyz.demo_room.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels {
        InjectorUtils.provideUserViewModelFactory(this)
    }
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        userViewModel.users.observe(this, Observer { list ->
            val builder = StringBuilder()
            list.forEach() {
                builder.append("${it.uid} ${it.firstName} ${it.lastName} \n")
            }
            textView.text = builder.toString()
        })
    }

    fun insert(view: View) {
        userViewModel.insert(User("Kobe", "Bryant"))
    }

    fun delete(view: View) {
        val all = userViewModel.users.value
        if (!all.isNullOrEmpty()) {
            val last = all.last()
            userViewModel.delete(last)
        }
    }
}
