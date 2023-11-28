package com.springapps.jpaexamples.shop.dtos;

public class WishlistRequestDTO {

    private Long productId;
    private Long userId;

    public WishlistRequestDTO(Long productId, Long userId) {
        this.productId = productId;
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
