ALTER TABLE app_user ADD COLUMN surname varchar (50);

UPDATE app_user SET surname=last_name;

ALTER TABLE app_user DROP COLUMN last_name;
