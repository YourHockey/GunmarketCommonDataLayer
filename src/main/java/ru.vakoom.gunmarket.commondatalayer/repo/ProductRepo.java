package ru.vakoom.gunmarket.commondatalayer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.vakoom.gunmarket.commondatalayer.model.Brand;
import ru.vakoom.gunmarket.commondatalayer.model.Product;
import ru.vakoom.gunmarket.commondatalayer.model.Type;
import ru.vakoom.querybuilder.FilterAndSortingRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long>, FilterAndSortingRepository<Product> {

    Optional<Product> findByProductId(Long productId);

    @Query(
            value = "SELECT max(product_id) FROM product",
            nativeQuery = true)
    Long findMaxId();

    default void saveOrUpdate(Product product) {
        if (product.getName().isBlank()) return;
        findByBrandAndNameAndType(product.getBrand(), product.getName(), product.getType())
                .ifPresentOrElse(
                        p -> save(product.setProductId(p.getProductId())),
                        () -> save(product)
                );
    }

    Optional<Product> findByBrandAndNameAndType(Brand brand, String name, Type type);
}
