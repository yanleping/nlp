package com.nlp.datapro;

import com.nlp.app.datapro.DataGet;
import com.nlp.app.util.SpringBeanUtil;
import com.nlp.config.Application;
import org.springframework.boot.SpringApplication;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataGetTest {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        DataGet getDate = (DataGet)SpringBeanUtil.getBean("dataGet");

        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);


        for(int i=1;i<1000;i++) {

            date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
            try {
                //Date endDate = dft.parse(dft.format(date.getTime()));
                //System.out.println(dft.format(date.getTime()));
                Date time = date.getTime();
                String url = "https://interface.meiriyiwen.com/article/day?dev=1&date=" + dft.format(date.getTime());
                getDate.save(url,time);

            }catch(Exception e){
                e.printStackTrace();
            }


        }

    }
}
