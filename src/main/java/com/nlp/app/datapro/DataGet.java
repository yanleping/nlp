package com.nlp.app.datapro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nlp.app.dao.ArticleDetailMapper;
import com.nlp.app.pojo.ArticleDetail;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class DataGet {
    private static Logger logger = LoggerFactory.getLogger(DataGet.class);

    @Autowired
    private ArticleDetailMapper articleDetailMapper;


    public void save(String url){
        //根据ID从每日一读API中读取文章数据
        String unicodeStr = this.getText(url);
        //将文章数据保存到数据库
        this.saveData(unicodeStr);
    }

    /** 从每日一读的API接口中获取文本数据 */
    public String getText(String urlStr){

        /** 网络的url地址 */
        URL url = null;

        /** http连接 */
        HttpURLConnection httpConn = null;

        /** 输入流 */
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try{
            url = new URL(urlStr);
            in = new BufferedReader( new InputStreamReader(url.openStream(),"UTF-8") );
            String str = null;
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally{
            try{
                if(in!=null) {
                    in.close();
                }
            }catch(IOException ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
        String result =sb.toString();
        System.out.println(result);
        return result;

    }

    /** unicode编码转中文 */
    public String unicode2String(String unicode){
        if(StringUtils.isBlank(unicode))return null;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while((i=unicode.indexOf("\\u", pos)) != -1){
            sb.append(unicode.substring(pos, i));
            if(i+5 < unicode.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(unicode.substring(i+2, i+6), 16));
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    /** 将数据分解保存到对象中，进而保存到数据库
     *
     */
    public void saveData(String aticle){
        ArticleDetail aticleDetail = new ArticleDetail();

        JSONObject jsonObject = JSON.parseObject(aticle);
        String str = jsonObject.getString("data");

        JSONObject jsonObject1 = JSON.parseObject(str);

        aticleDetail.setAuthor(jsonObject1.getString("author"));
        aticleDetail.setContent(jsonObject1.getString("content"));
        aticleDetail.setTitle(jsonObject1.getString("title"));
        aticleDetail.setWordcount(jsonObject1.getInteger("wc"));
        aticleDetail.setDigest(jsonObject1.getString("digest"));

        articleDetailMapper.insertSelective(aticleDetail);

    }

}
