package com.wilin.flutter_performance_test

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.WindowManager
import com.wilin.flutter_performance_test.nativeList.NativeListFragment
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.view.FlutterView

class MainActivity : NewFlutterActivity() {
  private lateinit var flutterDemoView: ViewGroup
  private val matchParent = WindowManager.LayoutParams(-1, -1)

  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(R.layout.main_activity)
    flutterDemoView = findViewById(R.id.flutter_view)
    super.onCreate(savedInstanceState)
    GeneratedPluginRegistrant.registerWith(this)

    addNativeListFragment()
  }

  private fun addNativeListFragment() {
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.add(R.id.native_view, NativeListFragment()).commit()
  }

  override fun createFlutterView(context: Context): FlutterView? {
    val nativeView = createFlutterNativeView()
    val flutterView = FlutterView(this, null as AttributeSet?, nativeView)
    flutterView.layoutParams = matchParent
    this.flutterDemoView.removeAllViews()
    this.flutterDemoView.addView(flutterView)
    return flutterView
  }
}
