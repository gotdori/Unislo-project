package com.miniproject.unislo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.miniproject.unislo.dto.OrderDetailDto;

import lombok.Data;

@Data
@Table(name = "ORD_DETAIL_TABLE")
@Entity
public class OrderDetailEntity {

    @Id
    @Column(name = "ORD_DET_NO")
    private String ordDetNo; // 주문상세번호
    
    @ManyToOne
    @JoinColumn(name = "ORD_NO")
    private OrderEntity orderEntity; // 주문번호

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "PROD_ID", referencedColumnName= "PROD_ID")
        ,@JoinColumn(name = "PROD_PRICE", referencedColumnName = "PROD_PRICE")
    })
    private ProductEntity productEntity; // 제품식별코드

    @Column(name = "ORD_DET_PROD_QTY")
    private String ordDetProdQty; // 제품 개수

    public static OrderDetailEntity toOrderDetailEntity(OrderDetailDto orderDetailDto) {

        OrderEntity orderEntity = new OrderEntity();
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        ProductEntity productEntity = new ProductEntity();

        orderDetailEntity.setOrdDetNo(orderDetailDto.getOrdDetNo());
        orderEntity.setOrdNo(orderDetailDto.getOrdNo());
        productEntity.setProdId(orderDetailDto.getProdId());
        productEntity.setProdPrice(orderDetailDto.getProdPrice());
        orderDetailEntity.setOrdDetProdQty(orderDetailDto.getOrdDetProdQty());

        return orderDetailEntity;

    }

}
