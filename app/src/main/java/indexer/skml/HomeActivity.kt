package indexer.skml

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import indexer.skml.components.NavDrawerComponent
import indexer.skml.components.NavDrawerComponent.Companion.DRAWER_ID
import indexer.skml.components.NavDrawerComponent.Companion.TOOLBAR_ID
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

  lateinit var drawer: DrawerLayout
  lateinit var toolbar: Toolbar

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {

    }
    drawer.closeDrawer(GravityCompat.START)
    return true
  }

  override fun onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
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

    toggle.syncState()
  }
}
