package com.zisad.eproxykotlin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.zisad.eproxykotlin.data.DataContainer
import dev.sasikanth.epoxysample.data.Data
import dev.sasikanth.epoxysample.data.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = HomeController()
        messagesView.setController(controller)

//        controller.allMessages = Data.messages
        controller.allMessages = DataContainer().getMessageData(20)
        controller.recentlyActive = Data.recentlyActive

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            messagesView.setOnScrollChangeListener { view, i, i2, i3, i4 ->
                if(!messagesView.canScrollVertically(1)){
                    val data: ArrayList<Message> = controller.allMessages as ArrayList<Message>
                    val message = data.get(data.size-1) as Message
                    val test = message.username+" - "+message.content
                    Log.e("Scrol", test)
                    Toast.makeText(this@MainActivity, test, Toast.LENGTH_SHORT).show()
                    data.addAll(DataContainer().getMessageData(20))
                    controller.allMessages = data
                }
            }
        }

//        messagesView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                var i5 = 0
//                val i4: Int = staggeredGridLayoutManager.getChildCount()
//                val i3: Int = staggeredGridLayoutManager.getItemCount()
//                val findFirstVisibleItemPositions: IntArray = staggeredGridLayoutManager.findFirstVisibleItemPositions(null as IntArray?)
//                if (findFirstVisibleItemPositions != null && findFirstVisibleItemPositions.size > 0) {
//                    i5 = findFirstVisibleItemPositions[0]
//                }
//                if (i4 + i5 >= i3 && i5 > 0) {
//                    Toast.makeText(this@TestActivity, "Loading", Toast.LENGTH_SHORT).show()
//                }
//            }
//        })

//        val controller = TestController()
//        messagesView.setController(controller)
//
//        controller.data = DataContainer().getData(50)
    }
}