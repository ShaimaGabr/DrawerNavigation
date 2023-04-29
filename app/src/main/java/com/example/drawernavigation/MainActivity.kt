package com.example.drawernavigation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var bottomNav : BottomNavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var go:ImageView
    lateinit var toolbar:Toolbar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         toolbar = findViewById(R.id.toolbar)
         go = findViewById(R.id.go)
        bottomNav = findViewById(R.id.bottomNav)

        drawernav()
        bottomview()



    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
 fun drawernav(){
     // using toolbar as ActionBar
     setSupportActionBar(toolbar)
     // drawer layout instance to toggle the menu icon to open
     // drawer and back button to close drawer
     drawerLayout = findViewById(R.id.my_drawer_layout)
     actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

     // pass the Open and Close toggle for the drawer layout listener
     // to toggle the button
     drawerLayout.addDrawerListener(actionBarDrawerToggle)
     actionBarDrawerToggle.syncState()

     // to make the Navigation drawer icon always appear on the action bar
     //  supportActionBar?.setDisplayHomeAsUpEnabled(true)

     go.setOnClickListener {
         drawerLayout.openDrawer(GravityCompat.START)
     }
 }
    fun bottomview(){
        loadFragment(firstFragment())
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(firstFragment())
                    true
                }
                R.id.message -> {
                    loadFragment(secondFragment())
                    true
                }
                R.id.settings -> {
                    loadFragment(thirdFragment())
                    true
                }
                else -> {
                    Toast.makeText(this,"",Toast.LENGTH_SHORT).show()
                    false


                }}
        }
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}