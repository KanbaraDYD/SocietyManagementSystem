package com.societymanagementsystem.back.mapper;

import com.societymanagementsystem.back.entity.Manage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kanbara
 * @since 2023-11-29
 */
@Mapper
public interface ManageMapper extends BaseMapper<Manage>
{
    @Select(value = "SELECT * from `page-visited`")
    List<Manage> getPageVisited();
}
