package indexer.skml.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import indexer.skml.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI

/**
 * Created by indexer on 9/25/16.
 */
class MainFragment : Fragment() {
  lateinit var user_name: TextView
  lateinit var user_message: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    /* val thread = Thread(Runnable {
       // put code to execute send SMS here

       try {
         val smsManager = SmsManager.getDefault()
         val msgArray = smsManager.divideMessage("Hello")

         smsManager.sendMultipartTextMessage("+959974847629", null, msgArray, null, null)
         // and make delay 5 second
         Thread.sleep(5000)
       } catch (e: InterruptedException) {
         e.printStackTrace()
       }
     })

     // execute thread
     thread.start()*/


  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    return UI {
      relativeLayout {
        gravity = Gravity.CENTER_VERTICAL
        lparams {
          width = matchParent
          height = matchParent
        }

        user_name = textView {
          text = "Send an alert"
          textSize = 26F
          textColor = resources.getColor(R.color.primary_text)
          lparams {
            width = matchParent
            height = wrapContent
            minHeight = 48
          }
        }

        user_message = editText {
          gravity = Gravity.CENTER_HORIZONTAL
          hint = "Alert message"
          setText("Type your message to send")
          lparams {
            below(user_name)
          }
        }

      }
    }.view
  }
}