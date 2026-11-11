package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.dto.ProductCatalogCardDTO;
import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select new com.devsuperior.dscatalog.dto.ProductCatalogCardDTO(" +
            "obj.id, obj.imgUrl, obj.name, obj.price) " +
            "from Product obj")
    Page<ProductCatalogCardDTO> searchAllImgNamePrice(Pageable pageable);

    @Query("SELECT DISTINCT new com.devsuperior.dscatalog.dto.ProductCatalogCardDTO(prod.id, " +
            "prod.imgUrl, prod.name, prod.price) " +
            "FROM Product prod " +
            "JOIN prod.categories cat " +
            "WHERE UPPER(:categoryName) IS NULL OR UPPER(cat.name) = UPPER(:categoryName)")
    Page<ProductCatalogCardDTO> searchAllProductsByCategory(String categoryName,
                                                            Pageable pageable);
}
