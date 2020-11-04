package com.zisad.eproxykotlin.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.sasikanth.epoxysample.data.Message;
import dev.sasikanth.epoxysample.data.Profile;

public class DataContainer {
    private String[] title = new String[]{"Nachos", "Fries", "Cheese Balls", "Pizza"};
    private String[] sub_title = new String[]{"Title_1", "Title_2", "Title_3", "Title_4"};

    private String getTitle(){
        int pos = new Random().nextInt(4);
        return title[pos];
    }

    private String getSubTitle(){
        int pos = new Random().nextInt(4);
        return sub_title[pos];
    }

    public List<TestClass> getData(int count){
        ArrayList data = new ArrayList();
        for(int i=0; i<count; i++){
            data.add(new TestClass(i, getTitle(), getSubTitle()));
        }
        return data;
    }

    public List<Message> getMessageData(int count){
        ArrayList data = new ArrayList();
        for(int i=0; i<count; i++){
//            data.add(new Message(i, getTitle(), getSubTitle()));
            data.add(new Message(i, ""+i, ""+i));
        }
        return data;
    }

}
