package com.example.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "role_user")
public class RoleUser implements Serializable {
    @Id
    @SequenceGenerator(name = "role_id_seq",
            sequenceName = "role_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "role_id", unique = true)
    private String roleId;

    @Column(name = "name")
    private String name;
}
