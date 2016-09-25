package indexer.skml.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import indexer.skml.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI

/**
 * Created by indexer on 9/25/16.
 */
class MainFragment : Fragment() {
  lateinit var user_name: TextView
  val request_code = 111

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

    val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
    intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
    startActivityForResult(intent, request_code)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    if (requestCode == request_code) {
      val contactUri = data.data
      val contextResolver = activity.contentResolver
      val projection = arrayOf(ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER)
      val cursor = contextResolver.query(contactUri, projection, null, null, null)
      cursor.moveToFirst()
      val column_display_name = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
      val column_display_phone = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
      val user_display_name = cursor.getString(column_display_name)
      val user_phone = cursor.getString(column_display_phone)
      cursor.close()
      user_name.text = user_display_name + user_phone
    }

  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    return UI {
      relativeLayout {
        gravity = Gravity.CENTER_VERTICAL
        lparams {
          width = matchParent
          height = matchParent
        }
        setBackgroundColor(resources.getColor(R.color.primary))

        user_name = textView {
          gravity = Gravity.CENTER_HORIZONTAL
          text = "Send an alert"
          textSize = 26F
          textColor = resources.getColor(R.color.primary_text)
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