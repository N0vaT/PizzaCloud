DROP TABLE IF EXISTS taco_ingredients;
DROP TABLE IF EXISTS Taco;
DROP TABLE IF EXISTS Taco_Order;
DROP TABLE IF EXISTS taco_user;
DROP TABLE IF EXISTS Ingredient;

CREATE TABLE IF NOT EXISTS Ingredient(
    id varchar(4) not null,
    name varchar(50) not null,
    type varchar(50) not null,
    PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS taco_user(
    id serial,
    user_name varchar(50) not null,
    user_password varchar(250) not null,
    user_full_name varchar(50) not null,
    user_street varchar(50) not null,
    user_city varchar(50) not null,
    user_state varchar(50) not null,
    user_zip varchar(50) not null,
    user_phone varchar(50) not null,
    PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS Taco_Order(
    id serial,
    delivery_name varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city varchar(50) not null,
    delivery_state varchar(50) not null,
    delivery_zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_CVV varchar(3) not null,
    placed_At timestamp not null,
    user_id integer,
    PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES taco_user (id)
    );
CREATE TABLE IF NOT EXISTS Taco(
    id serial,
    name varchar(50) not null,
    created_at timestamp not null,
    order_id integer,
    PRIMARY KEY (id),
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES taco_user (id)
    );
CREATE TABLE IF NOT EXISTS taco_ingredients
(
    taco_id integer not null,
    ingredients_id varchar(4) not null,
    PRIMARY KeY (taco_id, ingredients_id),
    CONSTRAINT fk_taco FOREIGN KEY (taco_id) REFERENCES Taco (id),
    CONSTRAINT fk_ingredient FOREIGN KEY (ingredients_id) REFERENCES Ingredient (id)
    );