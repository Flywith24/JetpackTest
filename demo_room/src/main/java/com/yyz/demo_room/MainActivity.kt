package com.yyz.demo_room

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yyz.demo_room.entity.User

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        db = AppDatabase.getInstance(this)
    }

    fun insert(view: View) {
        db.userDao().insertAll(User("Kobe", "Bryant"))
        updateView()
    }

    fun delete(view: View) {
        val all = db.userDao().getAll()
        if (!all.isNullOrEmpty()) {
            val last = all.last()
            db.userDao().delete(last)
            updateView()
        }
    }

    private fun updateView() {
        val list = db.userDao().getAll()
        val builder = StringBuilder()
        list.forEach() {
            builder.append("${it.uid} ${it.firstName} ${it.lastName} \n")
        }
        textView.text = builder.toString()
    }
}
