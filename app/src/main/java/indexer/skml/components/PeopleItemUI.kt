package indexer.skml.components

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import indexer.skml.extenstions.AnkoViewCompat
import org.jetbrains.anko.*

/**
 * Created by indexer on 9/27/16.
 */
class PeopleItemUI : AnkoComponent<ViewGroup> {

  companion object {
    val UserName_ID = AnkoViewCompat.generateViewId()
    val UserPhone_ID = AnkoViewCompat.generateViewId()
  }

  override fun createView(ui: AnkoContext<ViewGroup>): View {
    return with(ui) {
      linearLayout {
        lparams {
          width = matchParent
          height = wrapContent
          margin = 16
        }
        orientation = LinearLayout.VERTICAL

        textView {
          id = UserName_ID
          textSize = 16f
          lparams {
            padding = 8
          }
        }

        textView {
          id = UserPhone_ID
          textSize = 16f
          lparams {
            padding = 8
          }
        }
      }
    }
  }
}
