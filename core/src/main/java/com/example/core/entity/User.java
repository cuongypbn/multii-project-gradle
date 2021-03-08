package com.example.core.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Table(name = "account")
@RequiredArgsConstructor
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "acc_id_seq",
            sequenceName = "acc_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "acc_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", unique = true)
    private String userId;
    private String firstName;
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;
    private String password;
    private String passwordRepeat;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "role_id"))
    private Collection<RoleUser> roles;
}
