package indexer.skml.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import indexer.skml.PeopleContact
import indexer.skml.components.PeopleItemUI.Companion.UserName_ID
import indexer.skml.components.PeopleItemUI.Companion.UserPhone_ID
import org.jetbrains.anko.find


/**
 * Created by indexer on 9/27/16.
 */
class PeopleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


  lateinit var name: TextView
  lateinit var phone: TextView

  fun bind(contacts_list: PeopleContact) {
    name = itemView.find<TextView>(UserName_ID)
    phone = itemView.find<TextView>(UserPhone_ID)

    name.text = contacts_list.name
    phone.text = contacts_list.phone
  }
}