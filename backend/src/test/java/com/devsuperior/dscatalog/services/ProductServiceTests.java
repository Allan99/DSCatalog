package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.ProductCatalogCardDTO;
import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.repositories.ProductRepository;
import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dscatalog.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private PageImpl<ProductCatalogCardDTO> pageCard;
    private ProductCatalogCardDTO productCard;
    private Product product;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);

        existingId = 1L;
        nonExistingId = 2L;
        dependentId = 3L;
        productCard = Factory.createProductCatalogCardDTO();
        product = Factory.createProduct();
        pageCard = new PageImpl<>(List.of(productCard));
        productDTO = Factory.createProductDTO();

        Mockito.when(repository.searchAllImgNamePrice((Pageable) ArgumentMatchers.any()))
                .thenReturn(pageCard);
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(product);
        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(product));
        Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
        Mockito.when(repository.getReferenceById(existingId)).thenReturn(product);

        Mockito.doThrow(ResourceNotFoundException.class)
                .when(repository)
                .getReferenceById(nonExistingId);

        Mockito.doNothing().when(repository).deleteById(existingId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository)
                .deleteById(dependentId);

        Mockito.when(repository.existsById(existingId)).thenReturn(true);
        Mockito.when(repository.existsById(nonExistingId)).thenReturn(false);
        Mockito.when(repository.existsById(dependentId)).thenReturn(true);
    }
    
    @Test
    public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.update(nonExistingId, productDTO);
        });
    }

    @Test
    public void updateShouldReturnProductDTOWhenIdExists(){
        ProductDTO dto = service.update(existingId, productDTO);
        Assertions.assertNotNull(dto);
    }

    @Test
    public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingId);
        });
    }

    @Test
    public void findByIdShouldReturnProductDTOWhenIdExists(){
        ProductDTO dto = service.findById(existingId);
        Assertions.assertNotNull(dto);
    }

    @Test
    public void findAllShouldReturnPage(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<ProductCatalogCardDTO> result = service.findAll(pageable);
        Assertions.assertNotNull(result);
        Mockito.verify(repository, Mockito.times(1))
                .searchAllImgNamePrice(pageable);
    }

    @Test
    public void deleteShouldThrowDatabaseExceptionWhenDependentId(){

        Assertions.assertThrows(DatabaseException.class, () -> {
            service.delete(dependentId);
        });
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists(){

        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });

        Mockito.verify(repository, Mockito.times(1))
                .deleteById(existingId);
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.delete(nonExistingId);
        });
    }

}
