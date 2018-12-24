package com.aibyd.apps.db.mybatis;

import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * <ColumnOverride column="urls" javaType="java.lang.String[]" typeHandler=
 * "Json2StringArrayTypeHandler" />
 */
public class Json2StringArrayTypeHandler extends BaseTypeHandler<String[]> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, toJson(parameter));
    }

    @Override
    public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return this.toObject(rs.getString(columnName));
    }

    @Override
    public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return this.toObject(rs.getString(columnIndex));
    }

    @Override
    public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return this.toObject(cs.getString(columnIndex));
    }

    private String toJson(String[] params) {
        try {
            return mapper.writeValueAsString(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "[]";
    }

    private String[] toObject(String content) {
        if (content != null && !content.isEmpty()) {
            try {
                return (String[]) mapper.readValue(content, String[].class);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        } else {
            return null;
        }
    }

}