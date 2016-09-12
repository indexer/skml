package indexer.skml

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import indexer.skml.ui.MainActivityUi
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    MainActivityUi().setContentView(this)
  }
}
