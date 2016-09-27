package indexer.skml.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import indexer.skml.PeopleContact
import indexer.skml.components.PeopleItemUI
import indexer.skml.view.PeopleItemViewHolder
import org.jetbrains.anko.AnkoContext


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



