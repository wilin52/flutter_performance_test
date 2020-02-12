import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wilin.flutter_performance_test.R

const val VIEW_TYPE_HEADER = 0 /// 为了和flutter显示一致，增加一个头部
const val VIEW_TYPE_CONTENT = 1

class NativeListAdapter(val count: Int) : RecyclerView.Adapter<NativeViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NativeViewHolder {
    return if (viewType == VIEW_TYPE_HEADER) {
      NativeHeaderViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.native_list_item_header, parent, false))
    } else {
      NativeContentViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.native_list_item, parent, false))
    }
  }

  override fun onBindViewHolder(holder: NativeViewHolder, position: Int) {
    if (holder is NativeContentViewHolder) {
//      holder.textView.text = "${position - 1}"
    }
  }

  override fun getItemCount(): Int {
    return count
  }

  override fun getItemViewType(position: Int): Int {
    return if (position == 0) {
      VIEW_TYPE_HEADER
    } else {
      VIEW_TYPE_CONTENT
    }
  }
}

open class NativeViewHolder(view: View) : RecyclerView.ViewHolder(view)

class NativeHeaderViewHolder(view: View) : NativeViewHolder(view)

class NativeContentViewHolder(view: View) : NativeViewHolder(view) {
//  val textView: TextView = view.findViewById(R.id.item_text)
}