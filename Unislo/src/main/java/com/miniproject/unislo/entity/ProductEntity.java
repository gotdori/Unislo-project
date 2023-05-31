package com.miniproject.unislo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.miniproject.unislo.dto.ProductDto;

import lombok.Data;

@Data
@Table(name = "PROD_TABLE")
@Entity
public class ProductEntity {

    @Id
    @Column(name = "PROD_ID")
    private String prodId; // 제품식별코드
    @Column(name = "PROD_NM")
    private String prodNm; // 제품명
    @Column(name = "PROD_PRICE")
    private String prodPrice; // 제품가격
    @Column(name = "PROD_INFO")
    private String prodInfo; // 제품 정보
    @Column(name = "PROD_SALES")
    private String prodSales; // 제품 판매량
    @Column(name = "PROD_CATEGORY")
    private String prodCategory; // 제품 카테고리
    @Column(name = "PROD_SIZE")
    private String prodSize; // 제품 사이즈
    @Column(name = "PROD_STOCK")
    private String prodStock; // 제품 재고량
    @Column(name = "PROD_COLOR")
    private String prodColor; // 제품 색상

    public static ProductEntity toProductEntity(ProductDto productDto) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProdId(productDto.getProdId());
        productEntity.setProdNm(productDto.getProdNm());
        productEntity.setProdPrice(productDto.getProdPrice());
        productEntity.setProdInfo(productDto.getProdInfo());
        productEntity.setProdSales(productDto.getProdSales());
        productEntity.setProdCategory(productDto.getProdCategory());
        productEntity.setProdSize(productDto.getProdSize());
        productEntity.setProdStock(productDto.getProdStock());
        productEntity.setProdColor(productDto.getProdColor());

        return productEntity;

    }

}
