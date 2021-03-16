package com.example.seckill.entity;

import java.math.BigDecimal;
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
public class GoodsList implements Serializable {
    @TableId
    private Long id;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片地址
     */
    private String goodsImg;

    /**
     * 商品图片
     */
    private String discription;

    /**
     * 商品价格
     */
    private BigDecimal price;


}
