package com.gala.shop.model.TO;

import com.gala.shop.model.BaseEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder never use!
public class StorageItemTO extends BaseEntity {
    @NotNull
    private Double cost;
    @NotNull
    private Integer count;
    private Boolean available;
    @NotNull
    private String goods;
    private String description;
    private Integer categoryId;

    @Builder
    public StorageItemTO(Integer id, Double cost, Integer count, Boolean available, String goods,
                         String description, Integer categoryId) {
        super(id);
        this.cost = cost;
        this.count = count;
        this.available = available;
        this.goods = goods;
        this.description = description;
        this.categoryId = categoryId;
    }
}
