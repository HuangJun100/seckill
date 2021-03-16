package com.example.seckill.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author HuangJun
 * @since 2021-03-16
 */
@Data
@TableName("t_user")
public class User implements Serializable {

    @TableId
    private Long id;

    private String nickname;

    /**
     * md5(md5(pass明文+固定salt)+salt)
     */
    private String password;

    private String slat;

    /**
     * 头像
     */
    private String head;

    /**
     * 注册时间
     */
    private LocalDateTime registerDate;

    /**
     * 最后一次登陆时间
     */
    private LocalDateTime lastLoginDate;

    /**
     * 登陆时间
     */
    private Integer loginCount;


}
