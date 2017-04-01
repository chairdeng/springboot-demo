package com.example.springboot.mapper.typehandler;

import com.example.springboot.enums.SerializableEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 19:51
 * *****************************************
 */
public class SerializableEnumTypeHandler<E extends Enum<E> & SerializableEnum> extends BaseTypeHandler<SerializableEnum<?>> {

    private Class<E> clazz;
    public SerializableEnumTypeHandler(Class<E> enumType){
        if (enumType == null)
            throw new IllegalArgumentException("Type argument cannot be null");

        this.clazz = enumType;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SerializableEnum<?> serializableEnum, JdbcType jdbcType) throws SQLException {
        serializableEnum.getCode();
        preparedStatement.setObject(i,serializableEnum.getCode(),jdbcType.TYPE_CODE);

    }

    @Override
    public SerializableEnum<?> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        EnumSet<E> enumSet = EnumSet.allOf(clazz);
        Object o = resultSet.getObject(s);
        for(SerializableEnum enumObject:enumSet){
            if(enumObject.getCode().equals(o)){
                return enumObject;
            }
        }
        return null;
    }

    @Override
    public SerializableEnum<?> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        EnumSet<E> enumSet = EnumSet.allOf(clazz);
        Object o = resultSet.getObject(i);
        for(SerializableEnum enumObject:enumSet){
            if(enumObject.getCode().equals(o)){
                return enumObject;
            }
        }
        return null;
    }

    @Override
    public SerializableEnum<?> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        EnumSet<E> enumSet = EnumSet.allOf(clazz);
        Object o = callableStatement.getObject(i);
        for(SerializableEnum enumObject:enumSet){
            if(enumObject.getCode().equals(o)){
                return enumObject;
            }
        }
        return null;
    }
}
