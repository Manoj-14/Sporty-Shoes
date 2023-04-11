use newdb;


select * from admin;
select * from shoe;
select * from category;
select * from user;
select * from purchase;

--drop table product;
--drop table category;
drop table user;
--drop table shoe;
drop table purchase;

delete from Category;

delete from user where email="manoj@gmail.com"