package indexer.skml.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import indexer.skml.R

/**
 * Created by indexer on 9/25/16.
 */
class MainFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?,
                            savedInstanceState: Bundle?): View {
    val v = inflater.inflate(R.layout.fragment_main, parent, false)
    return v
  }
}