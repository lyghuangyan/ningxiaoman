package com.tom.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface SelfMapper
{
    
    @Select("select staff_no,name,dept from attendance GROUP BY staff_no,name,dept ")
    public List<Map<String, Object>> getStaffNo();
}
