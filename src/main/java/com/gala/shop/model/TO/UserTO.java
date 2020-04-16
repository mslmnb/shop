package com.gala.shop.model.TO;

import com.gala.shop.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder never use!
public class UserTO extends BaseEntity {
    @NotBlank
    private String name;
    private String password;
    @NotBlank
    private String address;
    @NotBlank
    private String fullName;

    @Builder
    public UserTO(Integer id, String name, String address, String fullName) {
        super(id);
        this.name = name;
        this.address = address;
        this.fullName = fullName;
    }
}
