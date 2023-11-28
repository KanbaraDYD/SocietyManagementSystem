package com.societymanagementsystem.back.service.impl;

import com.societymanagementsystem.back.entity.Manage;
import com.societymanagementsystem.back.mapper.ManageMapper;
import com.societymanagementsystem.back.service.IManageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kanbara
 * @since 2023-11-29
 */
@Service
public class ManageServiceImpl extends ServiceImpl<ManageMapper, Manage> implements IManageService
{
    @Autowired
    ManageMapper mapper;

    @Override
    public List<Manage> getPageVisited()
    {
        return mapper.getPageVisited();
    }
}
