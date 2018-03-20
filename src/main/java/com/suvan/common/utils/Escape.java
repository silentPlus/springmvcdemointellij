package com.suvan.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by suvan on 2017/6/4.
 */
public class Escape {

    // 错误的定义，可以修改数组内的值
    public static final String[] VALUES = {"1","2","3"};

    // 修正方法1：
    private static final String[] PRIVATE_VALUES1 = {"1","2","3"};
    public static final List<String> VALUES1 = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES1));

    // 修正方法2：
    private static final String[] PRIVATE_VALUES2 = {"1","2","3"};
    public static final String[] values() {
        return PRIVATE_VALUES2.clone();
    }


    public static void main(String[] args) {
        PRIVATE_VALUES1[2] = "afsd";
    }
}
