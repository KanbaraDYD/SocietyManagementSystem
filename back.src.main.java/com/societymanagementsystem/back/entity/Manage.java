package com/societymanagementsystem/back.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kanbara
 * @since 2023-11-29
 */
@Schema(name = "Manage", description = "$!{table.comment}")
public class Manage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "访问次数")
    private Integer visits;

    @Schema(description = "注册用户数")
    private String users;

    @Schema(description = "运行时间")
    private LocalDateTime uptime;

    @Schema(description = "菜单点击")
    private String clicks;

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public LocalDateTime getUptime() {
        return uptime;
    }

    public void setUptime(LocalDateTime uptime) {
        this.uptime = uptime;
    }

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

    @Override
    public String toString() {
        return "Manage{" +
            "visits = " + visits +
            ", users = " + users +
            ", uptime = " + uptime +
            ", clicks = " + clicks +
        "}";
    }
}
