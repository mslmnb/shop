package com.gala.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "storage")
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder never use!
public class StorageItem extends BaseEntity{

    @NotNull
    @Column(name = "cost")
    private Double cost;
    @NotNull
    @Column(name = "count")
    private Integer count;

    @Column(name = "available")
    private Boolean available;

    @Embedded
    private Goods goods;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @Builder
    public StorageItem(Integer id, Double cost, Integer count, Boolean available,
                       String goodsName, String goodsDescription, Integer categoryId) {
        super(id);
        this.cost = cost;
        this.count = count;
        this.available = available;
        this.goods = Goods.builder().name(goodsName).description(goodsDescription).build();
        this.category = Category.builder().id(categoryId).build();
    }
}
