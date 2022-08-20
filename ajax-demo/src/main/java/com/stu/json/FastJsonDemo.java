package com.stu.json;

import com.alibaba.fastjson.JSON;

/**
 * Created by e1hax on 2022-08-20.
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        //1. java对象转换为json
        User user = new User();
        user.setId(1);
        user.setUsername("jack");
        user.setPassword("123");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);//{"id":1,"password":"123","username":"jack"}

        //2. json转换为java对象

        User u = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"jack\"}", User.class);
        System.out.println(u);

    }
}
