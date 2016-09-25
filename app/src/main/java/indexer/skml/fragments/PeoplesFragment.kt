package indexer.skml.fragments

import android.os.Bundle
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

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    return UI {
      verticalLayout {
        lparams {
          margin = dimen(R.dimen.activity_horizontal_margin)
          width = matchParent
          height = matchParent
        }
        setBackgroundColor(resources.getColor(R.color.form_color))
        textView {
          text = "Choose people are your emeergency" +
              " contacts and will be alreted " +
              "when you're in danger or just feeling unsafe"
          textSize = 18F
          textColor = resources.getColor(R.color.primary_text)
          lparams {
            margin = dimen(R.dimen.activity_horizontal_margin)
            padding = 8
            width = matchParent
            height = wrapContent
            minHeight = 48
          }
        }
        view {
          setBackgroundColor(resources.getColor(R.color.primary))
          lparams {
            margin = dimen(R.dimen.activity_horizontal_margin)
            width = matchParent
            height = 1
          }
        }
        people_list = recyclerView {
          layoutManager = LinearLayoutManager(activity)
          lparams {
            margin = dimen(R.dimen.activity_horizontal_margin)
            width = matchParent
            height = 300
          }
        }
        val contacts_list: ArrayList<PeopleContact> = ArrayList()
        contacts_list.add(PeopleContact("Aung Aung", 1234455))
        people_list.adapter = PeopleAdapter(contacts_list)

      }
    }.view
  }
}