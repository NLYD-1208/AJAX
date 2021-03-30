package com.AJAX.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.naming.Name;

public class TestJson {
    public static void main(String[] args) throws JsonProcessingException {
        name  n = new name();
        n.setId(1);
        n.setName("123");
        n.setSex("a");
        //使用json 把 name  转为json
        ObjectMapper om = new ObjectMapper();
        //writeValueAsString：把参数java对象转化为json格式的字符串
        String json = om.writeValueAsString(n);
        System.out.println("转化为"+json);


    }
}
