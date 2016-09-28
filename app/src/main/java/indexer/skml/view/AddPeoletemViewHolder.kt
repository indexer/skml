package indexer.skml.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import indexer.skml.components.AddPeopleComponent
import indexer.skml.interfaces.AddPeople
import org.jetbrains.anko.find
import org.jetbrains.anko.onClick

/**
 * Created by indexer on 9/27/16.
 */
class AddPeopleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  var add_people: AddPeople? = null
  lateinit var add_button: Button

  fun bind(add_people: AddPeople) {
    this.add_people = add_people
    add_button = itemView.find<Button>(AddPeopleComponent.AddButton_ID)
    add_button.onClick { add_people.addUser() }
  }
}