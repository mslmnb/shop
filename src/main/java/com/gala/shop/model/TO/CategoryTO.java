package com.gala.shop.model.TO;

import com.gala.shop.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder never use!
public class CategoryTO extends BaseEntity{
        private String name;

    @Builder
    public CategoryTO(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
