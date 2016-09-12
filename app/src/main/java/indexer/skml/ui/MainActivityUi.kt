package indexer.skml.ui

import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import indexer.skml.MainActivity
import indexer.skml.R
import org.jetbrains.anko.*

/**
 * Created by indexer on 9/12/16.
 */
class MainActivityUi : AnkoComponent<MainActivity> {
  override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
    verticalLayout {
      gravity = Gravity.CENTER_VERTICAL
      backgroundColor = R.color.colorAccent
      padding = dip(resources.getDimension(R.dimen.activity_horizontal_margin))

      val userName = editText {
        hintResource = R.string.app_name
        textResource = R.string.app_name
      }


      val userPassword = editText {
        hintResource = R.string.password
        inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
      }

      val loginButton = button {
        textResource = R.string.login
        lparams {
          width = matchParent
          height = wrapContent
        }
        onClick {
          toast("Hello,${userName.text}")
        }
      }
    }

  }
}

