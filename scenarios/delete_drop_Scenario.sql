use Flyway;
alter table user_role drop foreign key FK143BF46AE389685A;

delete from app_user;

alter table user_role drop foreign key FK143BF46A3E5EA47A;


alter table role drop column id;
