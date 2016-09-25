package indexer.skml.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import indexer.skml.PeopleContact
import indexer.skml.extenstions.AnkoViewCompat
import org.jetbrains.anko.*


class PeopleAdapter(var contacts_list: List<PeopleContact>)
: RecyclerView.Adapter<PeopleItemViewHolder>() {


  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PeopleItemViewHolder? {
    return PeopleItemViewHolder(PeopleItemUI().createView(AnkoContext.create(parent!!.context,
        parent)))
  }

  override fun onBindViewHolder(holder: PeopleItemViewHolder?, position: Int) {
    val contacts_people = contacts_list[position]
    holder!!.bind(contacts_people)
  }

  override fun getItemCount(): Int {
    return contacts_list.size
  }
}

class PeopleItemUI : AnkoComponent<ViewGroup> {
  companion object {
    val user_name = AnkoViewCompat.generateViewId()
  }

  override fun createView(ui: AnkoContext<ViewGroup>): View {
    return with(ui) {
      linearLayout {
        lparams(width = matchParent, height = dip(48))
        orientation = LinearLayout.HORIZONTAL
        textView {
          id = 1
          textSize = 16f
        }
      }
    }
  }
}

class PeopleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val name: TextView = itemView.find(1)

  fun bind(contacts_list: PeopleContact) {
    name.text = contacts_list.name
  }
}

