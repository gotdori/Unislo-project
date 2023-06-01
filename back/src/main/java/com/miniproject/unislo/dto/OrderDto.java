package com.miniproject.unislo.dto;

import com.miniproject.unislo.entity.OrderEntity;

import lombok.Data;

@Data
public class OrderDto {
    private String ordNo; // 주문번호
    private String userId; // 회원아이디(이메일)
    private String ordAmount; // 주문 총결제금액
    private String ordDate; // 주문날짜
    private String ordCard; // 결제카드회사
    private String ordState; // 주문현황
    private String ordRefReason; // 환불사유
    private String ordRecipeint; // 받는분 성함
    private String ordZipcode; // 우편번호
    private String ordAddr; // 받는분 주소
    private String ordDetailAddr; // 상세 주소
    private String ordTelno; // 받는분 전화번호
    private String ordReq; // 배송요청사항
    private String ordProdQty; // 주문상품개수

    public static OrderDto tOrderDto(OrderEntity orderEntity) {

        OrderDto orderDto = new OrderDto();
        UserDto userDto = new UserDto();

        orderDto.setOrdNo(orderEntity.getOrdNo());
        userDto.setUserId(orderEntity.getUserEntity().getUserId());
        orderDto.setOrdAmount(orderEntity.getOrdAmount());
        orderDto.setOrdDate(orderEntity.getOrdDate());
        orderDto.setOrdCard(orderEntity.getOrdCard());
        orderDto.setOrdState(orderEntity.getOrdState());
        orderDto.setOrdRefReason(orderEntity.getOrdRefReason());
        orderDto.setOrdRecipeint(orderEntity.getOrdRecipeint());
        orderDto.setOrdZipcode(orderEntity.getOrdZipcode());
        orderDto.setOrdAddr(orderEntity.getOrdAddr());
        orderDto.setOrdDetailAddr(orderEntity.getOrdDetailAddr());
        orderDto.setOrdTelno(orderEntity.getOrdTelno());
        orderDto.setOrdReq(orderEntity.getOrdReq());
        orderDto.setOrdProdQty(orderEntity.getOrdProdQty());

        return orderDto;

    }
}
