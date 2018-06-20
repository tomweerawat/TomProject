package com.example.hotumit.tomproject

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import butterknife.BindView
import com.example.hotumit.tomproject.adapter.ContentAdapter
import com.example.hotumit.monthlyincome.manager.singleton.HttpManager
import com.example.hotumit.tomproject.R.id.recyclerView
import com.example.hotumit.tomproject.activity.FragmentMain
import com.example.hotumit.tomproject.adapter.pageradapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.hotumit.tomproject.dao.*
import com.example.hotumit.tomproject.fragment.CartFragment
import com.example.hotumit.tomproject.fragment.GiftsFragment
import com.example.hotumit.tomproject.utility.helper.BottomNavigationBehavior
import info.androidhive.bottomnavigation.fragment.ProfileFragment
import kotlinx.android.synthetic.main.bottom_navigation.*

import kotlinx.android.synthetic.main.bottom_sheet.*


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ContentAdapter
    internal lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    internal lateinit var toolbar: Toolbar
    private var viewPager: ViewPager? = null
    val post : MutableList<Post> = ArrayList()

    private lateinit var sheetBehavior: BottomSheetBehavior<*>
    private var layoutBottomSheet: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInstances()
    }

    private fun initInstances() {
        /*  viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        setupViewPager(viewPager)*/
        toolbar = findViewById(R.id.toolBarr)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)

        actionBarDrawerToggle = ActionBarDrawerToggle(
                this@MainActivity,
                drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // attaching bottom sheet behaviour - hide / show on scroll
        val layoutParams = navigation.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationBehavior()
        loadFragment(FragmentMain())


    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        actionBarDrawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }


    fun setupViewPager(upViewPager: ViewPager?) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentMain(), "")
        viewPager!!.adapter = adapter
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragment: Fragment
        when (item.itemId) {
            R.id.navigation_shop -> {
                toolbar!!.title = "Shop"
                fragment = FragmentMain()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_gifts -> {
                toolbar!!.title = "My Gifts"
                fragment = GiftsFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cart -> {
                toolbar!!.title = "Cart"
                fragment = CartFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar!!.title = "Profile"
                fragment = ProfileFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
