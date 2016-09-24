package indexer.skml.components

import android.graphics.Color
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import indexer.skml.HomeActivity
import indexer.skml.MainActivity
import indexer.skml.R
import org.jetbrains.anko.*


class MainActivityUi : AnkoComponent<MainActivity> {
  override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
    verticalLayout {
      gravity = Gravity.CENTER_VERTICAL
      padding = dip(resources.getDimension(R.dimen.activity_horizontal_margin))

      val userName = editText {
        hintResource = R.string.app_name
      }

      val userPassword = editText {
        hintResource = R.string.password
        inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
      }

      val loginButton = button {

        textResource = R.string.login
        backgroundColor = Color.parseColor("#388E3C")
        textColor = Color.parseColor("#ebebeb")
        lparams {
          width = matchParent
          height = wrapContent
          minHeight = 48
        }
        onClick {
          toast("${userName.text} +${userPassword.text}")
          startActivity<HomeActivity>()
        }
      }
    }

  }
}


