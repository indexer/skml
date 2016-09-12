package indexer.skml.ui

import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import indexer.skml.MainActivity
import indexer.skml.R
import org.jetbrains.anko.*

/**
 * Created by indexer on 9/12/16.
 */
class MainActivityUi : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            padding = dip(resources.getDimension(R.dimen.activity_horizontal_margin))

            val name = editText {
                hintResource = R.string.app_name
            }

            val password = editText {
                hintResource = R.string.password
                inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }
}
