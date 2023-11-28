package com.societymanagementsystem.back.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kanbara
 * @since 2023-11-29
 */
@Getter
@Setter
public class Manage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 访问次数
     */
    private Integer visits;

    /**
     * 注册用户数
     */
    private String users;

    /**
     * 运行时间
     */
    private LocalDateTime uptime;

    /**
     * 菜单点击
     */
    private String clicks;
}
