package indexer.skml.components

import android.support.design.widget.NavigationView
import android.view.Gravity.BOTTOM
import android.view.Gravity.START
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout.VERTICAL
import com.squareup.picasso.RequestCreator
import indexer.skml.R
import indexer.skml.utils.picasso
import org.jetbrains.anko.*

class NavHeaderComponent : AnkoComponent<NavigationView> {
  override fun createView(ui: AnkoContext<NavigationView>): View = with(ui) {
    linearLayout() {
      orientation = VERTICAL
      gravity = BOTTOM

      verticalPadding = dimen(R.dimen.activity_vertical_margin)
      horizontalPadding = dimen(R.dimen.activity_horizontal_margin)

      backgroundResource = R.drawable.side_nav_bar

      val image_view =
          imageView(android.R.drawable.sym_def_app_icon) {
            setImageResource(R.mipmap.ic_launcher)
            scaleType = ImageView.ScaleType.CENTER_CROP
            topPadding = dimen(R.dimen.nav_header_vertical_spacing)
          }.lparams {
            gravity = START
          }

      image_view.load("https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150")
      { request -> request.centerCrop().resize(200, 200) }


      textView("Android Studio") {
        topPadding = dimen(R.dimen.nav_header_vertical_spacing)
      }

    }
  }

  fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator) {
    request(getContext().picasso.load(path)).into(this)
  }
}
