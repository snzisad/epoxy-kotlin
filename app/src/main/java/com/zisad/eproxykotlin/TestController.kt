package com.zisad.eproxykotlin

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel
import com.zisad.eproxykotlin.data.TestClass
import dev.sasikanth.epoxysample.data.Message
import dev.sasikanth.epoxysample.data.Profile

class TestController : AsyncEpoxyController() {

    var data: List<TestClass> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }


    override fun buildModels() {
        data.forEach {
//            testItem {
//                id(it.id)
//                item(it)
//            }
            TestItemModel_(it).id(it.id).addTo(this)
        }
    }
}