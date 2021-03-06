package indexer.skml

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import indexer.skml.components.NavDrawerComponent
import indexer.skml.components.NavDrawerComponent.Companion.DRAWER_ID
import indexer.skml.components.NavDrawerComponent.Companion.FRAME_ID
import indexer.skml.components.NavDrawerComponent.Companion.TOOLBAR_ID
import indexer.skml.fragments.MainFragment
import indexer.skml.fragments.PeoplesFragment
import indexer.skml.utils.givenPermission
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

open class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, AnkoLogger {

  lateinit var drawer: DrawerLayout
  lateinit var toolbar: Toolbar

  companion object {
    const val PERMISSIONS_REQUEST_SMS_READCONTACTS = 1001
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    NavDrawerComponent().setContentView(this)

    drawer = find<DrawerLayout>(DRAWER_ID)
    toolbar = find<Toolbar>(TOOLBAR_ID)

    setSupportActionBar(toolbar)

    val toggle = ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
    drawer.addDrawerListener(toggle)

    //ToDO check permission from resume or on activity
    givenPermission(arrayOf(Manifest.permission.SEND_SMS,
        Manifest.permission.READ_CONTACTS), PERMISSIONS_REQUEST_SMS_READCONTACTS, {})


    toggle.syncState()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    super.onActivityResult(requestCode, resultCode, data)
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.nav_camera -> {
        supportActionBar?.title = "Home"
        supportFragmentManager.beginTransaction()
            .replace(FRAME_ID, MainFragment())
            .commit()
      }

      R.id.nav_gallery -> {
        supportFragmentManager.beginTransaction()
            .replace(FRAME_ID, PeoplesFragment())
            .commit()
      }

      R.id.nav_slideshow -> {
        debug("-> slideshow")
        supportFragmentManager.beginTransaction()
            .replace(FRAME_ID, MainFragment())
            .commit()
      }

      R.id.nav_share -> {
        debug("-> share")
        supportFragmentManager.beginTransaction()
            .replace(FRAME_ID, MainFragment())
            .commit()
      }

      R.id.nav_send -> {
        debug("-> send")
        supportFragmentManager.beginTransaction()
            .replace(FRAME_ID, MainFragment())
            .commit()
      }
    }

    drawer.closeDrawer(GravityCompat.START)
    return true
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.home, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return if (item.itemId == R.id.action_settings) {
      true
    } else {
      super.onOptionsItemSelected(item)
    }
  }

  override fun onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

}