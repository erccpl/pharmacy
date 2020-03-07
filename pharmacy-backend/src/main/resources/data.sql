
-- Roles
insert into roles(name) values ('ROLE_ADMIN');
insert into roles(name) values ('ROLE_USER');

-- Users
insert into users(username, password, active) values ('admin', 'admin', 1);
insert into users(username, password, active) values ('a', 'a', 1);

-- User-role
insert into user_role(user_id, role_id) values (1, 1);
insert into user_role(user_id, role_id) values (2, 2);

-- Suppliers
insert into suppliers(id, name) values(1, 'Supplier1');
insert into suppliers(id, name) values(2, 'Supplier2');
insert into suppliers(id, name) values(3, 'Supplier3');
insert into suppliers(id, name) values(4, 'Supplier4');

-- Categories
insert into categories(name) values('OINTMENT');
insert into categories(name) values('AEROSOL');
insert into categories(name) values('INTRAVENOUS');
insert into categories(name) values('EYEDROPS');
insert into categories(name) values('ORAL');
insert into categories(name) values('SPRAY');


-- Products
insert into products (name, category_id, unit, quantity, retail_price, description) values ('Visionix', 5, 'PILLS', 40, 39.99, 'Lutein-based pills for eyes');
insert into products (name, category_id, unit, quantity, retail_price, description) values ('MuscleRelief', 1, 'MILLIGRAMS', 100, 29.99, 'High-density balm for sore muscles');
insert into products (name, category_id, unit, quantity, retail_price, description) values ('NosePro', 6, 'MILLILITERS', 50, 13.99, 'Nose spray for spring (boot) allergies');
insert into products (name, category_id, unit, quantity, retail_price, description) values ('AsthmaInhaler', 2, 'MILLIGRAMS', 180, 45.99, 'Contingency inhaler for sudden asthma attacks');


-- Product-supplier
insert into product_supplier values(1,1);
insert into product_supplier values(1,2);
insert into product_supplier values(2,1);
insert into product_supplier values(2,3);
insert into product_supplier values(3,2);
insert into product_supplier values(3,3);
insert into product_supplier values(4,1);


-- Inventory Items
insert into inventory(product_id, stock, sale_price, expiration_date) values (1, 12, 69.99, '2020-03-20');
insert into inventory(product_id, stock, sale_price, expiration_date) values (1, 35, 69.99, '2020-08-22');
insert into inventory(product_id, stock, sale_price, expiration_date) values (2, 3, 41.99, '2021-04-12');
insert into inventory(product_id, stock, sale_price, expiration_date) values (2, 18, 41.99, '2020-03-21');
insert into inventory(product_id, stock, sale_price, expiration_date) values (3, 1, 20.99, '2022-01-18');