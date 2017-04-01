package com.example.springboot.enums;

import java.io.Serializable;

/**
 * *****************************************
 * 序列化枚举接口
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 18:28
 * *****************************************
 */
public interface SerializableEnum<T extends Comparable & Serializable> {
    T getCode();
}
