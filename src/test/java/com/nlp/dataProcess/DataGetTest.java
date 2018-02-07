package com.nlp.dataProcess;

public class DataGetTest {

    public static void main(String[] args){
        DataGet getDate = new DataGet();
        String url = "https://interface.meiriyiwen.com/article/today?dev=1";
        getDate.save(url);
//        getDate.unicode2String("\\u82cf\\u4e1c\\u5761\\u4f20\\u5e8f");
    }
}
