package com.gala.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    @Column(name = "goods")
    private String goods;

    @NotBlank
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @Builder

    public StorageItem(Integer id, Double cost, Integer count, Boolean available,
                       String goods, String description, Integer categoryId) {
        super(id);
        this.cost = cost;
        this.count = count;
        this.available = available;
        this.goods = goods;
        this.description = description;
        this.category = Category.builder().id(categoryId).build();
    }
}
