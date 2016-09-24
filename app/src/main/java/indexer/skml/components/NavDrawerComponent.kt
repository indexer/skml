package indexer.skml.components

import android.support.design.widget.AppBarLayout
import android.support.v4.view.GravityCompat
import android.view.View
import indexer.skml.HomeActivity
import indexer.skml.R
import indexer.skml.R.style.AppTheme_PopupOverlay
import indexer.skml.extenstions.AnkoViewCompat.generateViewId
import indexer.skml.extenstions.colorAttr
import indexer.skml.extenstions.dimenAttr
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

class NavDrawerComponent : AnkoComponent<HomeActivity>, AnkoLogger {

  companion object {
    val TOOLBAR_ID = generateViewId()
    val DRAWER_ID = generateViewId()
    val FRAME_ID = generateViewId()
  }

  override fun createView(ui: AnkoContext<HomeActivity>): View = with(ui) {
    drawerLayout {
      id = DRAWER_ID
      fitsSystemWindows = true

      coordinatorLayout {
        fitsSystemWindows = true

        appBarLayout(R.style.AppTheme_AppBarOverlay) {
          toolbar {
            id = TOOLBAR_ID
            backgroundColor = colorAttr(R.attr.colorPrimary)
            popupTheme = AppTheme_PopupOverlay
          }.lparams(width = matchParent, height = dimenAttr(R.attr.actionBarSize))
        }.lparams(width = matchParent)

        frameLayout() {
          id = FRAME_ID
          horizontalPadding = dimen(R.dimen.activity_horizontal_margin)
          verticalPadding = dimen(R.dimen.activity_vertical_margin)

        }.lparams(width = matchParent, height = matchParent) {
          behavior = AppBarLayout.ScrollingViewBehavior()
        }

      }

      navigationView {
        fitsSystemWindows = true
        val headerContext = AnkoContext.create(ctx, this)
        val headerView = NavHeaderComponent()
            .createView(headerContext)
            .lparams(width = matchParent, height = dimen(R.dimen.nav_header_height))
        addHeaderView(headerView)
        inflateMenu(R.menu.activity_home_drawer)
        if (!isInEditMode) {
          setNavigationItemSelectedListener(ui.owner)
        }
      }.lparams(height = matchParent) {
        gravity = GravityCompat.START
      }

      if (isInEditMode) {
        openDrawer(GravityCompat.START)
      }

    }
  }
}
