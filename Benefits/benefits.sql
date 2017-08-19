create database benefits;

create table companyprofile (id int not null auto_increment, establisheddate date, status varchar(50),corporationtype varchar(50), primary key(id));

create table company(id int not null auto_increment, name varchar(255), statusid int, type varchar(255), ein varchar(50), companyprofileid int, primary key(id), foreign key(companyprofileid) references company(id));

create table userprofile(id int not null auto_increment, dob date, doh date, maritalstatus varchar(50),sex varchar(50),ssn varchar(50),weight varchar(50), height varchar(50),employmentstatus varchar(50), terminationdate date, primary key(id));

create table user(id int not null auto_increment, createdate date, email varchar(255),firstname varchar(255), middlename varchar(255), lastname varchar(255),username varchar(100),jobtitle varchar(255),password_hash text,enabled tinyint(4), userprofileid int, primary key(id), foreign key(userprofileid) references userprofile(id));

create table role(id int not null auto_increment, role varchar(255), primary key(id));

create table user_role(user_id int not null, role_id int not null, primary key(user_id, role_id));