package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<ProductDTO> products = repository.searchAllWithCategory(pageable);
        return products;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.getReferenceById(id);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setImgUrl(dto.getImgUrl());
        product.setPrice(dto.getPrice());
        product.setDate(dto.getDate());
        product.setDescription(dto.getDescription());
        for(CategoryDTO catDTO: dto.getCategories()){
            Category cat = new Category(catDTO.getId(), catDTO.getName());
            product.getCategories().add(cat);
        }
        product = repository.save(product);
        return new ProductDTO(product);
    }
}
