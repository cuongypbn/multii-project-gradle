CREATE TABLE account
(
    id           serial,
    userId       VARCHAR(128) NOT NULL,
    name         VARCHAR(128) NOT NULL,
    firstName    VARCHAR(128),
    lastName     VARCHAR(128),
    email        VARCHAR(128) NOT NULL,
    password     VARCHAR(128) NOT NULL,
    enabled      BOOLEAN      NOT NULL,
    tokenExpired BOOLEAN,
    PRIMARY KEY (id, userId)
);
CREATE TABLE roleUser
(
    id     serial ,
    roleId VARCHAR(128) NOT NULL ,
    name   VARCHAR(128) NOT NULL,
    PRIMARY KEY (id, roleId)

);
