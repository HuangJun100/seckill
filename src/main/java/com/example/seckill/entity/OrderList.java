package com.example.seckill.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2021-03-16
 */
@Data
public class OrderList implements Serializable {
    @TableId
    private Long Id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 订单id
     */
    private Long orderId;


}
