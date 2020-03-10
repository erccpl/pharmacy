package com.pharmacy;

import com.pharmacy.category.Category;
import com.pharmacy.category.CategoryName;
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

    public static Product newProduct(Long id, String name, CategoryName categoryName) {
        Product product = new Product();
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);
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

        User user = new User();
        user.setId(id);
        user.setUsername("dummy");
        user.setRoles(roles);
        user.setPassword("dummy");
        user.setActive(1);

        return user;
    }

    private static User newAdminlUser(Long id) {
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN_ROLE");

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setId(id);
        user.setUsername("dummy");
        user.setRoles(roles);
        user.setPassword("dummy");
        user.setActive(1);

        return user;
    }

    public static InventoryItem newInventoryItemForProduct(Long productId) {
        InventoryItem item = new InventoryItem();
        item.setProduct(newProduct(productId, "test", CategoryName.AEROSOL));
        item.setStock((int)(10.0 * Math.random()));
        float salePrice = round((float)(10.0 * Math.random()), 2);
        item.setSalePrice(salePrice);
        //TODO: the Date type is pretty much deprecated
        //TODO: dont think this works
        item.setExpirationDate(between(new Date(2020, 03, 20), new Date(2022, 02, 11)));
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
