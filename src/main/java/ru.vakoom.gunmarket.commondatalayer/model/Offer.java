package ru.vakoom.gunmarket.commondatalayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;

import static ru.vakoom.gunmarket.commondatalayer.model.Product.PRODUCT_ID;
import static ru.vakoom.gunmarket.commondatalayer.model.Shop.SHOP_ID;

@Data
@Entity
@Table(name = Offer.OFFER_TABLE)
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Offer {
    public static final String OFFER_ID = "offerId";
    public static final String OFFER_TABLE = "offer";

    @Id
    @Column(name = OFFER_ID, nullable = false)
    private String productInShopId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = PRODUCT_ID, nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = SHOP_ID, nullable = false)
    private Shop shop;

    @Min(value = 0, message = "Offer price cannot be lower than 0")
    private double price;
    private boolean inStock;
    private String link;
}
