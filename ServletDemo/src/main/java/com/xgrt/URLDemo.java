package com.xgrt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name="张三";
        //URL编码
        String encode = URLEncoder.encode(name, "UTF-8");
        System.out.println(encode);//结果：%E5%BC%A0%E4%B8%89

        //URL解码
        String decode = URLDecoder.decode(encode, "UTF-8");
        System.out.println(decode);//结果：张三

        //URL错误解码
        String decode2 = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decode2);//结果：å¼ ä¸

        //转为字节数据
        byte []bytes=decode2.getBytes("ISO-8859-1");
        for (byte b:bytes)
        {
            System.out.print(b+" ");//-27 -68 -96 -28 -72 -119
        }
        System.out.println();

        //将字节数组转为字符串
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
