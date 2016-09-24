package indexer.skml.extenstions

import android.os.Build
import android.view.View
import java.util.concurrent.atomic.AtomicInteger

object AnkoViewCompat {
  private val nextGeneratedId = AtomicInteger(1)

  /**
   * Generate a value suitable for use in {@link #View.setId(int)}.
   * This value will not collide with ID values generated at build time by aapt for R.id.
   *
   * @return a generated ID value
   */
  fun generateViewId(): Int {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      return View.generateViewId()
    } else {
      while (true) {
        val result = nextGeneratedId.get();
        // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
        var newValue = result + 1
        if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
        if (nextGeneratedId.compareAndSet(result, newValue)) {
          return result
        }
      }
    }
  }
}