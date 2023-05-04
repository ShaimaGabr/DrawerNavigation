package com.example.drawernavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast

class SearchTwo : AppCompatActivity() {
    lateinit var programmingLanguagesLV: ListView

    // creating array adapter for listview
    lateinit var listAdapter: ArrayAdapter<String>

    // creating array list for listview
    lateinit var programmingLanguagesList: ArrayList<String>;

    // creating variable for searchview
    lateinit var searchView: SearchView
    lateinit var  searchButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_two)
        programmingLanguagesLV = findViewById(R.id.idLVProgrammingLanguages)
        searchView = findViewById(R.id.idSV)
        searchButton=findViewById(R.id.searchbutton)

        // initializing list and adding data to list
        programmingLanguagesList = ArrayList()
        programmingLanguagesList.add("C")
        programmingLanguagesList.add("C#")
        programmingLanguagesList.add("Java")
        programmingLanguagesList.add("Javascript")
        programmingLanguagesList.add("Python")
        programmingLanguagesList.add("Dart")
        programmingLanguagesList.add("Kotlin")
        programmingLanguagesList.add("Typescript")


        // for each list view item and adding array list to it.
        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            programmingLanguagesList
        )

        // on below line setting list
        // adapter to our list view.
        programmingLanguagesLV.adapter = listAdapter

        // on below line we are adding on query
        // listener for our search view.
//        searchView.setOnQueryTextFocusChangeListener(object : View.OnFocusChangeListener{
//            override fun onFocusChange(p0: View?, p1: Boolean) {
//               searchView.setBackgroundResource(R.drawable.bg_focuse)
//            }
//        })-
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (programmingLanguagesList.contains(query)) {
                    // if query exist within list we

                    // are filtering our list adapter.
                    listAdapter.filter.filter(query)
                } else {
                    // if query is not present we are displaying
                    // a toast message as no  data found..
                    Toast.makeText(this@SearchTwo, "No Language found..", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                if(newText!!.length>=1){
                    programmingLanguagesLV.visibility=View.VISIBLE
                    searchButton.visibility=View.VISIBLE
                }
                else{
                    programmingLanguagesLV.visibility=View.INVISIBLE
                    searchButton.visibility=View.INVISIBLE
                }
                listAdapter.filter.filter(newText)
                return false
            }
        })
    }
}