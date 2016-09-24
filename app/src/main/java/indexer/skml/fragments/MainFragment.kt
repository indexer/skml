package indexer.skml.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import indexer.skml.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI

/**
 * Created by indexer on 9/25/16.
 */
class MainFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    return UI {
      relativeLayout {
        gravity = Gravity.CENTER_VERTICAL
        lparams {
          width = matchParent
          height = matchParent
        }
        setBackgroundColor(resources.getColor(R.color.colorPrimary))

        textView {
          gravity = Gravity.CENTER_HORIZONTAL
          text = "ALERT"
          textSize = 26F
          textColor = resources.getColor(R.color.background)
          lparams {
            width = matchParent
            height = wrapContent
            minHeight = 48
          }
        }
      }
    }.view
  }
}