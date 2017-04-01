package com.example.springboot.repository.converter;

import com.example.springboot.enums.SerializableEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.Serializable;
import java.util.EnumSet;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/4/1 14:38
 * *****************************************
 */
//@Converter
public class SerializableEnumConverter<E extends Enum<E> & SerializableEnum,T extends Comparable & Serializable> implements AttributeConverter<E,T> {
    private Class<E> clazz;
    public SerializableEnumConverter(Class<E> enumType){
        if (enumType == null)
            throw new IllegalArgumentException("Type argument cannot be null");

        this.clazz = enumType;
    }
    @Override
    public T convertToDatabaseColumn(E e) {
        return (T) e.getCode();
    }

    @Override
    public E convertToEntityAttribute(T t) {
        EnumSet<E> enumSet = EnumSet.allOf(clazz);
        for(SerializableEnum enumObject:enumSet){
            if(enumObject.getCode().equals(t)){
                return (E) enumObject;
            }
        }
        return null;
    }
}
