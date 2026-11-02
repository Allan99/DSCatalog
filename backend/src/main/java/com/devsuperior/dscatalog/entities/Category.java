package com.devsuperior.dscatalog.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Setter(AccessLevel.NONE)
    private Instant created_At;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Setter(AccessLevel.NONE)
    private Instant updated_At;

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
        created_At = Instant.now();
    }

    @PrePersist
    public void prePersist(){
        created_At = Instant.now();
    }

    @PreUpdate
    public void preUpdate(){
        updated_At = Instant.now();
    }
}
