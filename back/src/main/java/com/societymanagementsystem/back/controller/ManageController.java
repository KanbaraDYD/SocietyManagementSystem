package com.societymanagementsystem.back.controller;

import com.societymanagementsystem.back.entity.Manage;
import com.societymanagementsystem.back.service.IManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kanbara
 * @since 2023-11-29
 */
@RestController
@RequestMapping("/manage")
public class ManageController
{
    @Autowired
    IManageService service;

    @CrossOrigin
    @GetMapping("/getPageVisited")
    public List<Manage> getPageVisited()
    {
        return service.getPageVisited();
    }
}
