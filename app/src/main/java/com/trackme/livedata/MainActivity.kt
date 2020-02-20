package com.trackme.livedata

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val model: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mTextView: TextView = findViewById(R.id.textView)
//        MainActivityDataGenerator myData = new MainActivityDataGenerator();
        //        MainActivityDataGenerator myData = new MainActivityDataGenerator();

        var mynum=Observer<String> {myRandomNumber->
            mTextView.text = myRandomNumber.toString()

        }
        model.getNumber()!!.observe(this, mynum)
        button.setOnClickListener {   model.createNumber() }



    }


}
