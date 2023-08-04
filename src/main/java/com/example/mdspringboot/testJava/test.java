package com.example.mdspringboot.testJava;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/8/3 20:03
 */
public class test {
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        for(Integer num : map.keySet()){
            System.out.println(map.get(num));
        }
    }
}
