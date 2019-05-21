--/create table in database in postgresql in this format.
 
create table registered_users("id" varchar(100) not null default '0000' primary key,
"first_name" varchar(200) not null,
"last_name" varchar(200) not null,
"email_id" varchar(2000) not null unique,
"password" varchar(2000) not null,
"status" varchar(100) default 'active' not null,
"false_login" integer default 0 not null,
"address" varchar(3000) not null,
"phone_number" integer ,
"gender" varchar(100));