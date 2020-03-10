package com.pharmacy;

import com.pharmacy.product.Product;
import com.pharmacy.user.User;
import com.pharmacy.user.role.Role;

import java.util.HashSet;
import java.util.Set;

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

}
