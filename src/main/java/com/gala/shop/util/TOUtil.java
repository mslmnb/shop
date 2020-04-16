package com.gala.shop.util;

import com.gala.shop.model.Role;
import com.gala.shop.model.StorageItem;
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
                .goodsName(storageItemTO.getGoodsName())
                .goodsDescription(storageItemTO.getGoodsDescription())
                .categoryId(storageItemTO.getCategoryId())
                .cost(storageItemTO.getCost())
                .count(storageItemTO.getCount())
                .build();
    }

    public static StorageItemTO asTO(StorageItem storageItem) {
        return StorageItemTO.builder()
                .id(storageItem.getId())
                .available(storageItem.getAvailable())
                .goodsName(storageItem.getGoods().getName())
                .goodsDescription(storageItem.getGoods().getDescription())
                .categoryId(storageItem.getCategory().getId())
                .cost(storageItem.getCost())
                .count(storageItem.getCount())
                .build();
    }
}
