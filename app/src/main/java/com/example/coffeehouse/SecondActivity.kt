package com.example.coffeehouse

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class SecondActivity : AppCompatActivity() {
lateinit var drawerLayout:DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    lateinit var navigationView:NavigationView
    var previousMenuItem:MenuItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        drawerLayout=findViewById(R.id.drawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        toolbar=findViewById(R.id.toolbar)
        navigationView=findViewById(R.id.navigationView)
        setUpToolbar()
        val acitonbarDrawerToggle=ActionBarDrawerToggle(this@SecondActivity,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(acitonbarDrawerToggle)
        acitonbarDrawerToggle.syncState()
openDashboard()



        navigationView.setNavigationItemSelectedListener  {
            if (previousMenuItem!=null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem= it
            when(it.itemId) {

                R.id.Account -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,AccountFragment())
                        .addToBackStack("Account")
                        .commit()
                    supportActionBar?.title="Account"
                    drawerLayout.closeDrawers()

                }
                R.id.Menu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,Menu1Fragment())
                        .addToBackStack("Menu")
                        .commit()
                    supportActionBar?.title="Menu"
                    drawerLayout.closeDrawers()
                }
                R.id.cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,CartFragment())
                        .addToBackStack("Cart")
                        .commit()
                    supportActionBar?.title="Cart"
                    drawerLayout.closeDrawers()
                }
                R.id.Receipts -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,ReceiptsFragment())
                        .addToBackStack("Receipts")
                        .commit()
                    supportActionBar?.title="Receipts"
                    drawerLayout.closeDrawers()
                }
                R.id.Settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,SettingsFragment())
                        .addToBackStack("Settings")
                        .commit()
                    supportActionBar?.title="Settings"
                    drawerLayout.closeDrawers()
                }

            }
            return@setNavigationItemSelectedListener false
        }
    }

      fun setUpToolbar(){
          setSupportActionBar(toolbar)
          supportActionBar?.title="Coffee House"
          supportActionBar?.setHomeButtonEnabled(true)
          supportActionBar?.setDisplayHomeAsUpEnabled(true)
      }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    fun openDashboard(){
        val Fragment= Menu1Fragment()
        val transaction =    supportFragmentManager.beginTransaction()
           transaction .replace(R.id.frame,Menu1Fragment())
            transaction.addToBackStack("Menu")
            transaction.commit()
        supportActionBar?.title="Menu"
        navigationView.setCheckedItem(R.id.Menu)
    }

    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frame)
        when(frag){
            !is Menu1Fragment->openDashboard()
            else->super.onBackPressed()

        }
    }
}
