package com.gala.shop.util;

import com.gala.shop.model.Category;
import com.gala.shop.model.Role;
import com.gala.shop.model.StorageItem;
import com.gala.shop.model.TO.CategoryTO;
import com.gala.shop.model.TO.StorageItemTO;
import com.gala.shop.model.TO.UserTO;
import com.gala.shop.model.User;

public class TOUtil {
    public static User createFrom(UserTO userTO, Integer id, Role role) {
        return User.builder()
                        .id(id)
                        .name(userTO.getName())
                        .address(userTO.getAddress())
                        .fullName(userTO.getFullName())
                        .password(userTO.getPassword())
                        .role(role)
                        .build();
    }

    public static UserTO asTO(User user) {
        return UserTO.builder()
                .id(user.getId())
                .name(user.getName())
                .fullName(user.getFullName())
                .address(user.getAddress())
                .build();
    }

    public static StorageItem createFrom(StorageItemTO storageItemTO) {
        return StorageItem.builder()
                .id(storageItemTO.getId())
                .available(storageItemTO.getAvailable())
                .goods(storageItemTO.getGoods())
                .description(storageItemTO.getDescription())
                .categoryId(storageItemTO.getCategoryId())
                .cost(storageItemTO.getCost())
                .count(storageItemTO.getCount())
                .build();
    }

    public static StorageItemTO asTO(StorageItem storageItem) {
        return StorageItemTO.builder()
                .id(storageItem.getId())
                .available(storageItem.getAvailable())
                .goods(storageItem.getGoods())
                .description(storageItem.getDescription())
                .categoryId(storageItem.getCategory().getId())
                .cost(storageItem.getCost())
                .count(storageItem.getCount())
                .build();
    }

    public static CategoryTO asTO(Category category) {
        return CategoryTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
