package indexer.skml.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import indexer.skml.PeopleContact
import indexer.skml.components.AddPeopleComponent
import indexer.skml.components.PeopleItemUI
import indexer.skml.view.AddPeopleItemViewHolder
import indexer.skml.view.PeopleItemViewHolder
import org.jetbrains.anko.AnkoContext


class PeopleAdapter(var contacts_list: List<PeopleContact>)
: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  val plus_one = 1

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
    if (position == 0) {
    } else {
      val contacts_people = contacts_list[position - plus_one]
      (holder as PeopleItemViewHolder).bind(contacts_people)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
    if (viewType == item_type.added_user.ordinal) {
      return PeopleItemViewHolder(parent)
    } else {
      return AddPeopleViewHolder(parent)
    }
  }

  fun PeopleItemViewHolder(parent: ViewGroup?): PeopleItemViewHolder? {
    return PeopleItemViewHolder(PeopleItemUI().createView(AnkoContext.create(parent!!.context,
        parent)))
  }

  fun AddPeopleViewHolder(parent: ViewGroup?): AddPeopleItemViewHolder? {
    return AddPeopleItemViewHolder(AddPeopleComponent().createView(AnkoContext.create(parent!!.context,
        parent)))
  }

  override fun getItemViewType(position: Int): Int {
    if (position == 0) {
      return item_type.add_new_user_button.ordinal
    } else {
      return item_type.added_user.ordinal
    }
  }

  override fun getItemCount(): Int {
    if (contacts_list.size > 0) return contacts_list.size + plus_one
    else return plus_one
  }

  enum class item_type {
    add_new_user_button, added_user
  }
}



