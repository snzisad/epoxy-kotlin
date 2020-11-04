package com.zisad.eproxykotlin

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.zisad.eproxykotlin.data.TestClass
import dev.sasikanth.epoxysample.data.Message

@EpoxyModelClass(layout = R.layout.layout_test)
abstract class TestItemModel(@EpoxyAttribute var item: TestClass) : EpoxyModelWithHolder<TestItemModel.Holder>() {

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(item) {
            holder.tv_title.text = title
            holder.tv_sub_title.text = sub_title
        }
    }

    class Holder : EpoxyHolder() {
        lateinit var tv_title: AppCompatTextView
        lateinit var tv_sub_title: AppCompatTextView

        override fun bindView(itemView: View) {
            tv_title = itemView.findViewById(R.id.tv_title)
            tv_sub_title = itemView.findViewById(R.id.tv_sub_title)
        }
    }
}