package com.example.drawernavigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class SearchActivity : AppCompatActivity() {

    var countries = arrayOf(
        "India", "Australia", "West indies", "indonesia", "Indiana",
        "South Africa", "England", "Bangladesh", "Srilanka", "singapore"
    )
   lateinit var textView:AutoCompleteTextView
   lateinit var search:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
         textView = findViewById(R.id.txtcountries)
         search=findViewById(R.id.sear)



        searchAuto()


    }
    fun searchAuto(){
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, countries)

        textView.threshold = 3

        textView.setAdapter(adapter)
        textView.addTextChangedListener (object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if( textView.length()>=1){
                    search.visibility=View.VISIBLE
                }else{
                    search.visibility=View.INVISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })




    }


}