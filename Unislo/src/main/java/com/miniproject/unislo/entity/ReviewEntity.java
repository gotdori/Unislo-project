package com.miniproject.unislo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.miniproject.unislo.dto.ReviewDto;

import lombok.Data;

@Data
@Table(name = "REVIEW_TABLE")
@Entity
public class ReviewEntity {

    @Id
    @Column(name = "REVIEW_NO")
    private String reviewNo; // 리뷰 식별번호

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity; // 사용자아이디(이메일)

    @ManyToOne
    @JoinColumn(name = "PROD_ID")
    private ProductEntity productEntity; // 제품식별코드

    @Column(name = "REVIEW_CONTENTS")
    private String reviewContents; // 리뷰 내용

    public static ReviewEntity toReviewEntity(ReviewDto reviewDto) {

        ReviewEntity reviewEntity = new ReviewEntity();
        UserEntity userEntity = new UserEntity();
        ProductEntity productEntity = new ProductEntity();

        reviewEntity.setReviewNo(reviewDto.getReviewNo());
        userEntity.setUserId(reviewDto.getUserId());
        productEntity.setProdId(reviewDto.getProdId());
        reviewEntity.setReviewContents(reviewDto.getReviewContents());

        return reviewEntity;

    }
}
