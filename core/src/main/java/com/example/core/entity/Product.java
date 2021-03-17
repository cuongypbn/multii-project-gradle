package com.example.core.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    // mã vạch
    @Column(name = "barcode")
    private Long barcode;

    private String nameProduct;

    private String groupProduct;

    //Thương hiệu
    private String trademarkProduct;

    //Vi tri cua san pham
    private String locationProduct;

    //tiền vốn
    private Long capitalProduct;

    //giá bán
    private Long priceProduct;

    //số lượng tồn kho
    private Long inventory;

    //số lượng tồn kho
    private Long weight;

    private boolean statusProduct;



}
