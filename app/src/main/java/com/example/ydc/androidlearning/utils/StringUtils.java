package com.example.ydc.androidlearning.utils;

/**
 * Created by ydc on 16-10-11.
 */
public class StringUtils {


    public static boolean isEmpty(String str) {
        if (str == null || str.trim().equals("")) {
            return true;
        }
        return false;
    }


}
