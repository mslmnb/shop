SET DATABASE SQL SYNTAX ORA TRUE;

DROP TABLE order_details;
DROP TABLE orders;
DROP TABLE storage;
DROP TABLE categories;
DROP TABLE users;
DROP SEQUENCE GLOBAL_SEQ;

CREATE SEQUENCE PUBLIC.GLOBAL_SEQ AS INTEGER START WITH 100000;

create table users
(
  ID              NUMBER(20) DEFAULT global_seq.NEXTVAL,
  NAME            VARCHAR2(50)   NOT NULL UNIQUE,
  PASSWORD        VARCHAR2(1024),
  ADDRESS         VARCHAR2(256),
  FULL_NAME       VARCHAR2(256),
  ROLE            VARCHAR2(50)   NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY (ID)
);

create table categories
(
  ID   NUMBER(20) DEFAULT global_seq.NEXTVAL,
  NAME VARCHAR2(50) NOT NULL UNIQUE,
  CONSTRAINT categories_pk PRIMARY KEY (ID)
);

create table storage
(
    ID          NUMBER(20) DEFAULT global_seq.NEXTVAL,
    CATEGORY_ID NUMBER(20) NOT NULL,
    GOODS       VARCHAR2(128)  NOT NULL,
    DESCRIPTION VARCHAR2(1024) NOT NULL,
    COST        NUMBER(10, 2)  NOT NULL,
    COUNT       NUMBER(5)      NOT NULL,
    AVAILABLE   NUMBER(1)  DEFAULT 0 NOT NULL check (AVAILABLE in (0, 1)),
    CONSTRAINT storage_pk PRIMARY KEY (ID),
    FOREIGN KEY (CATEGORY_ID) REFERENCES categories (ID) ON DELETE CASCADE
);

create table orders
(
    ID          NUMBER(20) DEFAULT global_seq.NEXTVAL,
    USER_ID     NUMBER(20) NOT NULL,
    COMPLITED   NUMBER(1)  DEFAULT 0 NOT NULL check (COMPLITED in (0, 1)),
    CONSTRAINT order_pk PRIMARY KEY (ID),
    FOREIGN KEY (USER_ID) REFERENCES users (ID) ON DELETE CASCADE
);

create table order_details
(
    ID          NUMBER(20) DEFAULT global_seq.NEXTVAL,
    ORDER_ID    NUMBER(20) NOT NULL,
    STORAGE_ID  NUMBER(20) NOT NULL,
    COUNT       NUMBER(5),
    COST        NUMBER(10, 2)  NOT NULL,
    FOREIGN KEY (ORDER_ID) REFERENCES orders (ID) ON DELETE CASCADE,
    FOREIGN KEY (STORAGE_ID) REFERENCES storage (ID) ON DELETE CASCADE
);

-- users --
INSERT INTO users (NAME, PASSWORD, ADDRESS, FULL_NAME, ROLE)                    -- 100 000
VALUES ('Admin', 'password', 'г.Караганда ул.Гоголя д.40 кв.104', 'Петров ИИ', 'ROLE_ADMIN' );                                                             -- 100 000

INSERT INTO users (NAME, PASSWORD, ADDRESS, FULL_NAME, ROLE)                    -- 100 001
VALUES ('User', 'password', 'г.Алматы ул.Кунаева д.4240 кв.14', 'Ахметов ИИ', 'ROLE_USER' );

-- categories --
INSERT INTO categories (NAME)
VALUES('Детский мир');                                                               -- 100 002

INSERT INTO categories (NAME)
VALUES('Книги');                                                                     -- 100 003

INSERT INTO categories (NAME)
VALUES('Красота и здоровье');                                                        -- 100 004

INSERT INTO categories (NAME)
VALUES('Категория А');                                                              -- 100 005

INSERT INTO categories (NAME)
VALUES('Категория Б');                                                              -- 100 006

INSERT INTO categories (NAME)
VALUES('Квтегория В');                                                              -- 100 007

INSERT INTO categories (NAME)
VALUES('Категория Г');                                                              -- 100 008

INSERT INTO categories (NAME)
VALUES('Категория Д');                                                              -- 100 009

-- storage --
INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)                           -- 100 010
VALUES (100002, 1500.00, 25, 'кубики', 'коробка 30х20, разноцветные, 12 штук', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)
VALUES (100002, 2700.00, 55, 'пазл Нью-Йорк', 'коробка 35х40, 1500 деталей', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)
VALUES (100002, 3700.00, 55, 'пазл Москва', 'коробка 35х40, 2500 деталей', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)
VALUES (100002, 5500.00, 105, 'кукла Барби', 'упаковка 50х20', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)
VALUES (100002, 5500.00, 125, 'кукла Кен', 'упаковка 50х20', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)
VALUES (100003, 1500.00, 125, 'книга А', 'упаковка 50х20', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)
VALUES (100003, 2500.00, 125, 'книга Б', 'упаковка 50х20', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)
VALUES (100003, 500.00, 125, 'книга В', 'упаковка 50х20', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)
VALUES (100004, 5500.00, 125, 'красота А', 'упаковка 50х20', 1);

INSERT INTO storage (CATEGORY_ID, COST, COUNT, GOODS, DESCRIPTION, AVAILABLE)                             -- 100 019
VALUES (100004, 5500.00, 125, 'красота Б', 'упаковка 50х20', 1);

-- orders --
INSERT INTO orders (USER_ID, COMPLITED)
VALUES (100001, 0);                                          -- 100 020

INSERT INTO orders (USER_ID, COMPLITED)
VALUES (100001, 1);                                          -- 100 021

INSERT INTO orders (USER_ID, COMPLITED)
VALUES (100001, 1);                                         -- 100 022

-- order_details --
INSERT INTO order_details (ORDER_ID, STORAGE_ID, COUNT, COST)
VALUES (100020, 100010, 1, 1450.00);

INSERT INTO order_details (ORDER_ID, STORAGE_ID, COUNT, COST)
VALUES (100020, 100011, 1, 2500.00);

INSERT INTO order_details (ORDER_ID, STORAGE_ID, COUNT, COST)
VALUES (100020, 100013, 1, 5500.00);

INSERT INTO order_details (ORDER_ID, STORAGE_ID, COUNT, COST)
VALUES (100021, 100012, 1, 3700.00);

INSERT INTO order_details (ORDER_ID, STORAGE_ID, COUNT, COST)
VALUES (100021, 100016, 1, 2500.00);

INSERT INTO order_details (ORDER_ID, STORAGE_ID, COUNT, COST)
VALUES (100022, 100017, 1, 500.00);

INSERT INTO order_details (ORDER_ID, STORAGE_ID, COUNT, COST)
VALUES (100022, 100018, 1, 5500.00);

commit ;