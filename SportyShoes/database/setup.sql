use newdb;


select * from admin;
select * from product;
select * from catogory;
select * from user;

drop table product;
drop table category;
drop table user;

delete from user where email="manoj@gmail.com"