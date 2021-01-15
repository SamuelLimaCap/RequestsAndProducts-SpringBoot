package com.confeitaria.caliGlamour.entities;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    @JoinColumn(name = "username")
    private String username;

    public Request() {

    }

    public Request(Long id, Product product, Integer quantity, String username) {
        this.quantity = quantity;
        this.product = product;
        this.username = username;
    }


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    @Override
    public String toString() {
        return "Request{" +
            "id=" + id +
            ", product=" + product +
            ", quantity=" + quantity +
            ", user=" + username +
            '}';
    }
}
