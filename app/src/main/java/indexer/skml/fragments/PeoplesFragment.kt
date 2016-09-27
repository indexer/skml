package indexer.skml.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import indexer.skml.PeopleContact
import indexer.skml.R
import indexer.skml.adapter.PeopleAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import java.util.*


class PeoplesFragment : Fragment() {
  lateinit var people_list: RecyclerView
  val contacts_list: ArrayList<PeopleContact> = ArrayList()
  val request_code = 111

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)


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

      contacts_list.add(PeopleContact(user_display_name, user_phone))
      people_list.adapter.notifyDataSetChanged()
      cursor.close()
    }

  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    return UI {
      verticalLayout {
        lparams {
          margin = dimen(R.dimen.activity_horizontal_margin)
          width = matchParent
          height = matchParent
        }
        textView {
          textResource = R.string.alert
          textSize = 18F
          textColor = R.color.primary_text
          lparams {
            margin = dimen(R.dimen.activity_horizontal_margin)
            padding = 8
            width = matchParent
            height = wrapContent
            minHeight = 48
          }
        }
        view {
          backgroundColor = R.color.divider
          lparams {
            margin = dimen(R.dimen.activity_horizontal_margin)
            width = matchParent
            height = 1
          }
        }
        people_list = recyclerView {
          layoutManager = LinearLayoutManager(activity)
          adapter = PeopleAdapter(contacts_list)
          lparams {
            margin = dimen(R.dimen.activity_horizontal_margin)
            width = matchParent
            height = wrapContent
          }
        }
        button {
          backgroundColor = R.color.accent
          text = "Add New People"
          lparams {
            width = matchParent
            height = wrapContent
            margin = 16
            padding = 8
          }
          onClick {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            startActivityForResult(intent, request_code)
          }
        }
      }
    }.view
  }
}