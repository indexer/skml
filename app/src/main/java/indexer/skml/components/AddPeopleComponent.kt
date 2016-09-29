package indexer.skml.components

import android.graphics.Color
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
        }
        orientation = LinearLayout.VERTICAL

        button {
          id = AddButton_ID
          textColor = Color.parseColor("#ebebeb")
          backgroundColor = Color.parseColor("#FF9800")
          textColor = R.color.primary_text
          text = resources.getString(R.string.add_people)
          textSize = 13f
          lparams {
            width = matchParent
            height = matchParent
            margin = 8
          }

        }

      }
    }
  }
}