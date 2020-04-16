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
    private String goodsName;
    private String goodsDescription;
    private Integer categoryId;

    @Builder
    public StorageItemTO(Integer id, Double cost, Integer count, Boolean available, String goodsName,
                         String goodsDescription, Integer categoryId) {
        super(id);
        this.cost = cost;
        this.count = count;
        this.available = available;
        this.goodsName = goodsName;
        this.goodsDescription = goodsDescription;
        this.categoryId = categoryId;
    }
}
