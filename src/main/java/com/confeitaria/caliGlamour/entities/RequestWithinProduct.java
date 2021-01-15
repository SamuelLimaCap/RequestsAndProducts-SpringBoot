package com.confeitaria.caliGlamour.entities;


public class RequestWithinProduct {

    private Long productId;
    private Product product;
    private Integer quantity;
    private String username;

    public RequestWithinProduct(Long productId, Integer quantity, String username) {
        this.productId = productId;
        this.quantity = quantity;
        this.username = username;
    }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}
