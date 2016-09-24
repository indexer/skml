package indexer.skml.extenstions

import android.content.Context
import android.os.Build
import android.support.annotation.AttrRes
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.ctx
import org.jetbrains.anko.wrapContent

fun collapseModePin(): CollapsingToolbarLayout.LayoutParams.() -> Unit = {collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN }

fun Context.snackbar(view: View, text: CharSequence, length: Int = Snackbar.LENGTH_SHORT, snackbar: Snackbar.() -> Unit) = Snackbar.make(view, text, length).apply { snackbar() }.show()
fun View.snackbar(text:  CharSequence, length: Int = Snackbar.LENGTH_SHORT, snackbar: Snackbar.() -> Unit) = context.snackbar(this, text, length, snackbar)
fun Fragment.snackbar(view: View, text: CharSequence, length: Int = Snackbar.LENGTH_SHORT, snackbar: Snackbar.() -> Unit) = activity.snackbar(view, text, length, snackbar)

fun Context.attr(@AttrRes attribute: Int): TypedValue {
        var typed = TypedValue()
        ctx.theme.resolveAttribute(attribute, typed, true)
        return typed
    }

//returns px
fun Context.dimenAttr(@AttrRes attribute: Int): Int = TypedValue.complexToDimensionPixelSize(attr(attribute).data, resources.displayMetrics)

//returns color
fun Context.colorAttr(@AttrRes attribute: Int): Int {
    return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            resources.getColor(attr(attribute).resourceId, ctx.theme)
        } else {
            @Suppress("DEPRECATION")
            resources.getColor(attr(attribute).resourceId)
        }
}

fun AnkoContext<*>.dimenAttr(@AttrRes attribute: Int): Int = ctx.dimenAttr(attribute)
fun AnkoContext<*>.colorAttr(@AttrRes attribute: Int): Int = ctx.colorAttr(attribute)
fun AnkoContext<*>.attribute(@AttrRes attribute: Int): TypedValue = ctx.attr(attribute)

fun View.dimenAttr(@AttrRes attribute: Int): Int = context.dimenAttr(attribute)
fun View.colorAttr(@AttrRes attribute: Int): Int = context.colorAttr(attribute)
fun View.attr(@AttrRes attribute: Int): TypedValue = context.attr(attribute)

fun Fragment.dimenAttr(@AttrRes attribute: Int): Int = activity.dimenAttr(attribute)
fun Fragment.colorAttr(@AttrRes attribute: Int): Int = activity.colorAttr(attribute)
fun Fragment.attr(@AttrRes attribute: Int): TypedValue = activity.attr(attribute)


object FrameLayout {
    fun <T : View> T.lparams(
        width: Int = wrapContent, height: Int = wrapContent,
        init: FrameLayout.LayoutParams.() -> Unit = {}): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }
}

object CollapsingToolbar {
    fun <T : View> T.lparams(
        width: Int = wrapContent, height: Int = wrapContent,
        init: CollapsingToolbarLayout.LayoutParams.() -> Unit = {}): T {
        val layoutParams = CollapsingToolbarLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }
}
