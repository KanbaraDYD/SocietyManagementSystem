package com.societymanagementsystem.back.service;

import com.societymanagementsystem.back.entity.Manage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kanbara
 * @since 2023-11-29
 */
public interface IManageService extends IService<Manage>
{
    List<Manage> getPageVisited();
}
