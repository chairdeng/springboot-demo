package com.example.springboot.enums;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 17:54
 * *****************************************
 */

public enum SexEnum implements SerializableEnum<Integer> {
    FEMALE(0,"女"),MALE(1,"男");
    private int code;
    private String name;
    SexEnum(int code,String name) {
        this.code = code;
        this.name = name;
    }
    @Override
    public Integer getCode() {
        return this.code;
    }
    public String getName() {
        return name;
    }
}
