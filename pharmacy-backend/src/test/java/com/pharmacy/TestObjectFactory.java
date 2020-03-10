package com.pharmacy;

import com.pharmacy.inventory.InventoryItem;
import com.pharmacy.product.Product;
import com.pharmacy.user.User;
import com.pharmacy.user.role.Role;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class TestObjectFactory {

    public static Product newEmptyProduct() {
        Product product = new Product();
        product.setId(1L);
        return product;
    }

    public static Product newProduct(Long id, String name) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        return product;
    }

    private static User newNormalUser(Long id) {
        Role role = new Role();
        role.setId(2L);
        role.setName("USER_ROLE");

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User dummyUser = new User();
        dummyUser.setId(id);
        dummyUser.setUsername("dummy");
        dummyUser.setRoles(roles);
        dummyUser.setPassword("dummy");
        dummyUser.setActive(1);

        return dummyUser;
    }

    private static InventoryItem newInventoryForProduct(Long productId) {
        InventoryItem item = new InventoryItem();
        item.getProduct().setId(productId);
        item.setStock((int)(10.0 * Math.random()));
        float salePrice = round((float)(10.0 * Math.random()), 2);
        item.setSalePrice(salePrice);
        //TODO: the Date type is pretty much deprecated
        item.setExpirationDate(between(new Date(), new Date(2014, 02, 11)));
        return item;
    }






    // ----------------------- Helper methods -----------------------------

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }

}
