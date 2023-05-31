package com.miniproject.unislo.dto;

import com.miniproject.unislo.entity.ProductEntity;

import lombok.Data;

@Data
public class ProductDto {
    private String prodId; // 제품식별코드
    private String prodNm; // 제품명
    private String prodPrice; // 제품가격
    private String prodInfo; // 제품 정보
    private String prodSales; // 제품 판매량
    private String prodCategory; // 제품 카테고리
    private String prodSize; // 제품 사이즈
    private String prodStock; // 제품 재고량
    private String prodColor; // 제품 색상

    public static ProductDto toProductDto(ProductEntity productEntity) {

        ProductDto productDto = new ProductDto();

        productDto.setProdId(productEntity.getProdId());
        productDto.setProdNm(productEntity.getProdNm());
        productDto.setProdPrice(productEntity.getProdPrice());
        productDto.setProdInfo(productEntity.getProdInfo());
        productDto.setProdSales(productEntity.getProdSales());
        productDto.setProdCategory(productEntity.getProdCategory());
        productDto.setProdSize(productEntity.getProdSize());
        productDto.setProdStock(productEntity.getProdStock());
        productDto.setProdColor(productEntity.getProdColor());

        return productDto;

    }
}
