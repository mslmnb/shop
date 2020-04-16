package com.gala.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder never use!
public class User extends BaseEntity {

    @Builder
    public User(Integer id, String name, String password, String address, String fullName, Role role) {
        super(id);
        this.name = name;
        this.password = password;
        this.address = address;
        this.fullName = fullName;
        this.role = role;
    }

    @NotBlank(message = "Username cannot be empty, you should use email as username")
    @Column(name = "name", nullable = false)
    private String name;
    @NotBlank(message = "Password cannot be empty")
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @NotBlank
    @Column(name = "full_name")
    private String fullName;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
