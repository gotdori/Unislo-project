package com.miniproject.unislo.dto;

import com.miniproject.unislo.entity.ReviewEntity;

import lombok.Data;

@Data
public class ReviewDto {
    private String reviewNo; // 리뷰 식별번호
    private String userId; // 사용자아이디(이메일)
    private String prodId; // 제품식별코드
    private String reviewContents; // 리뷰 내용

    public static ReviewDto toReviewDto(ReviewEntity reviewEntity) {

        ReviewDto reviewDto = new ReviewDto();
        UserDto userDto = new UserDto();
        ProductDto productDto = new ProductDto();

        reviewDto.setReviewNo(reviewEntity.getReviewNo());
        userDto.setUserId(reviewEntity.getUserEntity().getUserId());
        productDto.setProdId(reviewEntity.getProductEntity().getProdId());
        reviewDto.setReviewContents(reviewEntity.getReviewContents());

        return reviewDto;

    }
}
