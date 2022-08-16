CREATE TABLE users
(
    id          INT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(15) NOT NULL,
    surname     VARCHAR(15) NOT NULL,
    username    VARCHAR(15) NOT NULL,
    email       VARCHAR(100) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role        VARCHAR(100) NOT NULL
);

CREATE TABLE user_roles
(
    user_id  INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    UNIQUE (user_id, role_id)

);

# password: 100
INSERT INTO users (name, surname, username, email, password) VALUE ('Anton','Parfenov', 'admin123', 'test1@yandex.ru','$2y$12$XE6kgDS9WSUl1N35s2/bgeyQv9lsU3sNviF5830Ksk.G6zdYByiwa');
INSERT INTO users (name, surname, username, email, password) VALUE ('Ivan','Petrov', 'user123', 'test2@yandex.ru', '$2y$12$XE6kgDS9WSUl1N35s2/bgeyQv9lsU3sNviF5830Ksk.G6zdYByiwa');
INSERT INTO users (name, surname, username, email, password) VALUE ('Alexandr','Ivanov', 'alex777', 'test3@yandex.ru', '$2y$12$XE6kgDS9WSUl1N35s2/bgeyQv9lsU3sNviF5830Ksk.G6zdYByiwa');

INSERT INTO roles (role) VALUE ('ROLE_ADMIN');
INSERT INTO roles (role) VALUE ('ROLE_USER');

INSERT INTO user_roles values (1,1);
INSERT INTO user_roles values (2,2);
INSERT INTO user_roles values (3,2);
