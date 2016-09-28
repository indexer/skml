package indexer.skml.components

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import indexer.skml.R
import indexer.skml.extenstions.AnkoViewCompat
import org.jetbrains.anko.*

/**
 * Created by indexer on 9/27/16.
 */
class AddPeopleComponent : AnkoComponent<ViewGroup> {

  companion object {
    val AddButton_ID = AnkoViewCompat.generateViewId()
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

        button {
          id = AddButton_ID
          width = matchParent
          height = wrapContent
          text = resources.getString(R.string.add_people)
          textSize = 16f
          backgroundColor = R.color.primary
          lparams {
            padding = 8
          }
        }

      }
    }
  }
}