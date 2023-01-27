DROP TABLE IF EXISTS MAXUSER;
create table MAXUSER(
    userid int,
    name varchar(75) NOT NULL,
    type varchar(15) NOT NULL,
    password varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    role varchar(10) NOT NULL
);

DROP TABLE IF EXISTS LOGINTRACKING;

create table LOGINTRACKING(
    userid varchar(15),
    Attemptdate timestamp NOT NULL,
    attempttype varchar(6) NOT NULL
);
