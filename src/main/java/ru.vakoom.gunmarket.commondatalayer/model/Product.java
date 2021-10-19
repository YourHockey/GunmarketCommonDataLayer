package ru.vakoom.gunmarket.commondatalayer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.vakoom.querybuilder.BasicEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

import static ru.vakoom.gunmarket.commondatalayer.model.Product.PRODUCT_TABLE;

@Entity
@Table(name = PRODUCT_TABLE)
@Accessors(chain = true)
@Getter
@Setter
@ToString(exclude = "offer")
public class Product implements BasicEntity {
    public static final String PRODUCT_TABLE = "product";
    public static final String PRODUCT_ID = "productId";
    public static final String PRODUCT_MIN_PRICE = "minPrice";

    @Id
    @Column(name = PRODUCT_ID, length = 8, nullable = false)
    private Long productId;

    private String name;

    private String extendedName;
    private String srcImageUrl;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = Brand.BRAND_ID, nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = Type.TYPE_ID, nullable = false)
    private Type type;

    @OneToMany(mappedBy = PRODUCT_TABLE)
    private Set<Offer> offer = new HashSet<>();

    @ManyToMany
    private Set<Product> compatibleProduct;

    @Min(value = 0, message = "Product minPrice cannot be lower than 0")
    private Double minPrice;
    private Double maxPrice;
}