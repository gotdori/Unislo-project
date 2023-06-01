package com.miniproject.unislo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.miniproject.unislo.dto.CartDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CART_TABLE")
@NoArgsConstructor
public class CartEntity implements Serializable{

    @Id
    @Column(name = "CART_NO")
    private String cartNo;

    @ManyToOne
    @JoinColumn(name = "PROD_ID")
    private ProductEntity productEntity;// 제품식별코드

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;// 사용자아이디(이메일)

    @Column(name = "CART_PROD_QTY")
    private String cartProdQty;// 장바구니 상품 개수

    public static CartEntity toCartEntity(CartDto cartDto) {

        CartEntity cartEntity = new CartEntity();
        UserEntity userEntity = new UserEntity();
        ProductEntity productEntity = new ProductEntity();

        cartEntity.setCartNo(cartDto.getCartNo());
        productEntity.setProdId(cartDto.getProdId());
        userEntity.setUserId(cartDto.getUserId());
        cartEntity.setCartProdQty(cartDto.getCartProdQty());

        return cartEntity;

    }
}
