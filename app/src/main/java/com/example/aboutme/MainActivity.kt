package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import java.nio.file.attribute.AttributeView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var myName:MyName = MyName("Tanapat Tansara")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply{
            doneButton.setOnClickListener{
                addNickname(it)
            }
            nicknameText.setOnClickListener {
                updateNickname(it)
            }
            this.myName = this@MainActivity.myName
        }


        //setContentView(R.layout.activity_main)

    }
    private fun updateNickname(view: View){
        binding.apply{
            nicknameEdit.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE


            doneButton.visibility = View.VISIBLE

            nicknameEdit.requestFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit,0)
        }



    }


    private fun addNickname(view: View) {

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE


            doneButton.visibility = View.GONE
            invalidateAll()
            //Hide Keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }



    }
}
