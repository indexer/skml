package indexer.skml.utils

import android.content.Context
import com.squareup.picasso.Picasso

/**
 * Created by indexer on 9/29/16.
 */
val Context.picasso: Picasso
  get() = Picasso.with(this)
