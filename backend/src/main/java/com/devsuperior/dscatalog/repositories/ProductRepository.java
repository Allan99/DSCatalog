package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.dto.ProductCatalogCardDTO;
import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select new com.devsuperior.dscatalog.dto.ProductCatalogCardDTO(obj.imgUrl, obj.name, obj.price) from Product obj")
    Page<ProductCatalogCardDTO> searchAllImgNamePrice(Pageable pageable);
}
