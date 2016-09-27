package indexer.skml.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import indexer.skml.PeopleContact
import indexer.skml.components.PeopleItemUI
import indexer.skml.view.PeopleItemViewHolder
import org.jetbrains.anko.AnkoContext


class PeopleAdapter(var contacts_list: List<PeopleContact>)
: RecyclerView.Adapter<PeopleItemViewHolder>() {

  val plus_one = 1

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PeopleItemViewHolder? {
    return PeopleItemViewHolder(PeopleItemUI().createView(AnkoContext.create(parent!!.context,
        parent)))
  }

  override fun onBindViewHolder(holder: PeopleItemViewHolder?, position: Int) {
    if (position == 0) {

    } else {
      val contacts_people = contacts_list[position - plus_one]
      holder!!.bind(contacts_people)
    }
  }

  override fun getItemCount(): Int {
    if (contacts_list.size > 0) return contacts_list.size + plus_one
    else return plus_one
  }
}



