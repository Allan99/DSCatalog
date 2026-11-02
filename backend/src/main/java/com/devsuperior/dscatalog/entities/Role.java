package com.devsuperior.dscatalog.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"authority"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
}
