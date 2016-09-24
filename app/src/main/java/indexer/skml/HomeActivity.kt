package indexer.skml

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
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

open class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, AnkoLogger {

  lateinit var drawer: DrawerLayout
  lateinit var toolbar: Toolbar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    NavDrawerComponent().setContentView(this)

    drawer = find<DrawerLayout>(DRAWER_ID)
    toolbar = find<Toolbar>(TOOLBAR_ID)

    setSupportActionBar(toolbar)

    val toggle = ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
    drawer.addDrawerListener(toggle)

    toggle.syncState()
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
        debug("-> gallery")
        supportFragmentManager.beginTransaction()
            .replace(FRAME_ID, MainFragment())
            .commit()
      }

      R.id.nav_slideshow -> {
        debug("-> slideshow")
        supportFragmentManager.beginTransaction()
            .replace(FRAME_ID, MainFragment())
            .commit()
      }

      R.id.nav_manage -> {
        debug("-> manage")
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