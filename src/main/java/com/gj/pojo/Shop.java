package com.gj.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "tb_shop")
@Entity
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Integer shopId;
    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "shop_address")
    private String shopAddress;
    @Column(name = "shop_phone")
    private String shopPhone;

}
