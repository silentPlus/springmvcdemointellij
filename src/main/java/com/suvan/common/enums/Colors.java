package com.suvan.common.enums;

import com.suvan.service.ColorService;

/**
 * Created by suvan on 2017/7/11.
 */
public enum Colors implements ColorService {
    red("red") {
        public String getColor() {
            return this.color;
        }
    },
    black("black") {
        public String getColor() {
            return "white";
        }
    };

    private String color;

    Colors(String color) {
        this.color = color;
    }
}
