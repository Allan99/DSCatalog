package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT obj FROM Category obj " +
            "JOIN FETCH obj.products " +
            "WHERE UPPER(obj.name) = UPPER(:name)")
    Optional<Category> searchByName(String name);
}
