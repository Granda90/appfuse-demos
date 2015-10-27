create table person (person_id bigint not null auto_increment, first_name varchar(50), last_name varchar(50), primary key (person_id)) Engine=InnoDB;

create table person_email (person_email_id bigint not null auto_increment, person_id bigint not null, email varchar(50), email_type varchar(50), primary key (person_email_id)) Engine=InnoDB;

create table student (student_id bigint not null auto_increment, name varchar(50), count bigint, primary key (student_id)) Engine=InnoDB;