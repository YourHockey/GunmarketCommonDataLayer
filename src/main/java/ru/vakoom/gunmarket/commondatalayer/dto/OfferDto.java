package ru.vakoom.gunmarket.commondatalayer.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;

@Data
@Accessors(chain = true)
public class OfferDto {

    private String productId;
    private String shopName;
    private String name;
    private Double price;
    private Boolean inStock;
    @Column(length = 1023)
    private String link;

}
