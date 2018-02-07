package com.nlp.datapro;

import com.nlp.app.datapro.DataGet;

public class DataGetTest {

    public static void main(String[] args){
        DataGet getDate = new DataGet();
        String url = "https://interface.meiriyiwen.com/article/today?dev=1";
        getDate.save(url);
    }
}
