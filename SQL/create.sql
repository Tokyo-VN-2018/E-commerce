CREATE DATABASE ECOMMERCE;
GO
USE ECOMMERCE;
CREATE TABLE USERS(
	USERNAME VARCHAR(50) NOT NULL,
	FULLNAME NVARCHAR(50),
	PASSWORD VARCHAR(50) NOT NULL,
	DATEOFBIRTH DATE,
	PHONE VARCHAR(15),
	EMAIL VARCHAR(75),
	ADDRESS NVARCHAR(150),
	TYPE BIT DEFAULT 1,
	CONSTRAINT USERS_KEY PRIMARY KEY (USERNAME)
)
CREATE TABLE CATEGORIES(
	CATEGORY_ID CHAR(3) NOT NULL,
	CATEGORY_NAME VARCHAR(20) NOT NULL,
	BIG_GROUP VARCHAR(15) DEFAULT 'Other',
	CONSTRAINT CATEGORIES_KEY PRIMARY KEY (CATEGORY_ID)
)
GO
CREATE TABLE PRODUCTS(
	PRODUCT_ID VARCHAR(10) NOT NULL,
	CATEGORY_ID CHAR(3) NOT NULL,
	PRODUCT_NAME VARCHAR(30),
	BRAND VARCHAR(20),
	DESCRIPTION VARCHAR(100),
	QUANTITY INT DEFAULT 0,
	PRICE INT,
	CONSTRAINT PRODUCTS_KEY PRIMARY KEY (PRODUCT_ID),
	CONSTRAINT PRODUCTS_FK_C FOREIGN KEY (CATEGORY_ID)
	REFERENCES CATEGORIES(CATEGORY_ID)
	ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE TABLE CARTITEMS(
	CART_ITEM_ID INT NOT NULL,
	USERNAME VARCHAR(50) NOT NULL,
	PRODUCT_ID VARCHAR(10) NOT NULL,
	QUANTITY INT NOT NULL,
	CONSTRAINT CARTITEMS_KEY PRIMARY KEY (CART_ITEM_ID),
	CONSTRAINT CARTITEMS_FK_U FOREIGN KEY (USERNAME)
	REFERENCES USERS(USERNAME)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT CARTITEMS_FK_P FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCTS(PRODUCT_ID)
	ON UPDATE CASCADE ON DELETE CASCADE
)
CREATE TABLE ORDERS(
	ORDER_ID INT NOT NULL,
	USERNAME VARCHAR(50) NOT NULL,
	FULLNAME NVARCHAR(50),
	ORDER_DATE DATE,
	PHONE VARCHAR(15),
	ADDRESS NVARCHAR(150),
	AMOUNT INT NOT NULL,
	STATUS BIT DEFAULT 0,
	CONSTRAINT ORDERS_KEY PRIMARY KEY (ORDER_ID),
	CONSTRAINT ORDERS_FK_U FOREIGN KEY (USERNAME)
	REFERENCES USERS(USERNAME)
	ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE TABLE ORDERITEMS(
	ORDER_ITEM_ID INT NOT NULL,
	ORDER_ID INT NOT NULL,
	PRODUCT_ID VARCHAR(10) NOT NULL,
	QUANTITY INT NOT NULL,
	CONSTRAINT ORDERITEMS_KEY PRIMARY KEY (ORDER_ITEM_ID),
	CONSTRAINT ORDERITEMS_FK_U FOREIGN KEY (ORDER_ID)
	REFERENCES ORDERS(ORDER_ID)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT ORDERITEMS_FK_P FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCTS(PRODUCT_ID)
	ON UPDATE CASCADE ON DELETE CASCADE
)
