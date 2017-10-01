create table USER (
   ID varchar(50) not null,
   USER_NAME varchar(50) not null,
   PASSWORD varchar(50) not null,
   TYPE varchar(20) not null,
   FIRST_NAME varchar(100),
   LAST_NAME varchar(100),
   DOB date,
   EMAIL varchar(100),
   MOBILE varchar(15),
   ADDRESS varchar(255),
);


insert into USER (ID, USER_NAME, PASSWORD, TYPE, FIRST_NAME, LAST_NAME, DOB, EMAIL, MOBILE, ADDRESS) values ('appuser1', 'appuser1', 'appuser1', 'appuser1', 'appuser1 First Name', 'appuser1 Last Name', null, 'appuser1@gmail.com', '09876543211', 'appuser1 Address');
insert into USER (ID, USER_NAME, PASSWORD, TYPE, FIRST_NAME, LAST_NAME, DOB, EMAIL, MOBILE, ADDRESS) values ('appuser2', 'appuser2', 'appuser2', 'appuser2', 'appuser2 First Name', 'appuser2 Last Name', null, 'appuser2gmail.com', '09876543211', 'appuser2 Address');

insert into USER (ID, USER_NAME, PASSWORD, TYPE, FIRST_NAME, LAST_NAME, DOB, EMAIL, MOBILE, ADDRESS) values ('appadmin1', 'appadmin1', 'appadmin1', 'appadmin1', 'appadmin1 First Name', 'appadmin1 Last Name', null, 'appadmin1gmail.com', '09876543211', 'appadmin1 Address');
