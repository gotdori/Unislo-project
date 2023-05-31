package com.miniproject.unislo.dto;

import com.miniproject.unislo.entity.CartEntity;

import lombok.Data;

@Data
public class CartDto {
    private String cartNo;
    private String prodId;// 제품식별코드
    private String userId;// 사용자아이디(이메일)
    private String cartProdQty;// 장바구니 상품 개수

    public static CartDto toCartDto(CartEntity cartEntity) {

        CartDto cartDto = new CartDto();
        UserDto userDto = new UserDto();
        ProductDto productDto = new ProductDto();

        cartDto.setCartNo(cartEntity.getCartNo());
        productDto.setProdId(cartEntity.getProductEntity().getProdId());
        userDto.setUserId(cartEntity.getUserEntity().getUserId());
        cartDto.setCartProdQty(cartEntity.getCartProdQty());

        return cartDto;

    }
}
