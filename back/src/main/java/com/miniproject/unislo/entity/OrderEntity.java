package com.miniproject.unislo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.miniproject.unislo.dto.OrderDto;

import lombok.Data;

@Data
@Table(name = "ORD_TABLE")
@Entity
public class OrderEntity {

    @Id
    @Column(name = "ORD_NO")
    private String OrdNo; // 주문번호

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity; // 회원아이디(이메일)

    @Column(name = "ORD_AMOUNT")
    private String ordAmount; // 주문 총결제금액

    @Column(name = "ORD_DATE")
    private String ordDate; // 주문날짜

    @Column(name = "ORD_CARD")
    private String ordCard; // 결제카드회사

    @Column(name = "ORD_STATE")
    private String ordState; // 주문현황

    @Column(name = "ORD_REF_REASON")
    private String ordRefReason; // 환불사유

    @Column(name = "ORD_RECIPEINT")
    private String ordRecipeint; // 받는분 성함

    @Column(name = "ORD_ZIPCODE")
    private String ordZipcode; // 우편번호

    @Column(name = "ORD_ADDR")
    private String ordAddr; // 받는분 주소

    @Column(name = "ORD_DETAIL_ADDR")
    private String ordDetailAddr; // 상세 주소

    @Column(name = "ORD_TELNO")
    private String ordTelno; // 받는분 전화번호

    @Column(name = "ORD_REQ")
    private String ordReq; // 배송요청사항
    
    @Column(name = "ORD_PROD_QTY")
    private String ordProdQty; // 주문상품개수

    public static OrderEntity toOrderEntity(OrderDto orderDto) {

        OrderEntity orderEntity = new OrderEntity();
        UserEntity userEntity = new UserEntity();

        orderEntity.setOrdNo(orderDto.getOrdNo());
        userEntity.setUserId(orderDto.getUserId());
        orderEntity.setOrdAmount(orderDto.getOrdAmount());
        orderEntity.setOrdDate(orderDto.getOrdDate());
        orderEntity.setOrdCard(orderDto.getOrdCard());
        orderEntity.setOrdState(orderDto.getOrdState());
        orderEntity.setOrdRefReason(orderDto.getOrdRefReason());
        orderEntity.setOrdRecipeint(orderDto.getOrdRecipeint());
        orderEntity.setOrdZipcode(orderDto.getOrdZipcode());
        orderEntity.setOrdAddr(orderDto.getOrdAddr());
        orderEntity.setOrdDetailAddr(orderDto.getOrdDetailAddr());
        orderEntity.setOrdTelno(orderDto.getOrdTelno());
        orderEntity.setOrdReq(orderDto.getOrdReq());
        orderEntity.setOrdProdQty(orderDto.getOrdProdQty());

        return orderEntity;

    }

}
