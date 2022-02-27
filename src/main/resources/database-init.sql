use mailorderpharmacy;

create table if not exists drug (
   drug_id varchar(255) not null,
	drug_name varchar(255),
	exp_date datetime(6),
	manufacturer varchar(255),
	mnf_date datetime(6),
	primary key (drug_id)
) engine=InnoDB;

create table if not exists location_quantity (
   drug_id varchar(255) not null,
	location varchar(255) not null,
	location_id bigint not null,
	quantity integer not null,
	primary key (drug_id, location)
) engine=InnoDB;

create table if not exists subscription (
   subscription_id bigint not null auto_increment,
	course_duration integer not null,
	definition varchar(255),
	doctor_name varchar(255),
	drug_id varchar(255),
	drug_name varchar(255),
	insurance_provider varchar(255),
	location varchar(255),
	policy_number bigint not null,
	prescription_date datetime(6),
	quantity integer not null,
	refill_cycle integer not null,
	status bit not null,
	subscription_date datetime(6),
	email_id varchar(255),
	primary key (subscription_id)
) engine=InnoDB;

create table if not exists user (
	email_id varchar(25) not null,
    password varchar(255),
    phone_number varchar(255),
	first_name varchar(25),
	last_name varchar(25),
	primary key (email_id)
) engine=InnoDB;
 
INSERT INTO drug(drug_id, exp_date, mnf_date, drug_name ,manufacturer)
VALUES
('DRZG2LO', '2022-05-25', '2021-03-12', 'Crocin', 'Cipla'),
('DR9WO0A', '2023-07-16', '2020-08-14', 'Synthroid', 'Ranbaxy'),
('DR02S0P', '2024-06-02', '2021-01-11', 'Crestor', 'Dr. Reddy\'s Laboratories'),
('DR1TEDM', '2021-08-11', '2020-12-03', 'Ventolin HFA', 'GlaxoSmithKline Pharmaceuticals'),
('DRJET13', '2023-12-08', '2021-05-28', 'Nexium', 'Nicholas Piramal India'),
('DR7RPO0', '2022-01-29', '2021-04-30', 'Advair Diskus', 'Lupin'),
('DROQHHD', '2022-05-25', '2020-09-19', 'Lantus Solostar', 'Cipla'),
('DR2QQHW', '2021-10-07', '2020-10-02', 'Vyvanse', 'Cadila Healthcare'),
('DR3GROD', '2022-02-01', '2021-02-22', 'Lyrica', 'Cipla'),
('DRCRZ3Q', '2021-12-01', '2021-05-16', 'Spiriva', 'Cipla');

INSERT INTO location_quantity(drug_id, location_id, location, quantity)
VALUES
('DRZG2LO', 0 , 'Bengaluru, R.T Nagar', 650),
('DR9WO0A', 1 ,'Bengaluru, Sultan Palya',  412),
('DR02S0P', 2 , 'Bengaluru, Hennur',  615),
('DR1TEDM', 3 , 'Bengaluru, Boopasandara',  378),
('DRJET13', 4 , 'Bengaluru, Malleshwaram',  589),
('DR7RPO0', 5 , 'Bengaluru, Yelahanka',  430),
('DROQHHD', 6 ,'Bengaluru, Hebbal',  299),
('DR2QQHW', 7 , 'Bengaluru, Bannerghatta', 340),
('DR3GROD', 8 , 'Bengaluru, M.G Road',  288),
('DRZG2LO', 9 ,'Agra, R.T Nagar', 650),
('DR9WO0A', 10 , 'Agra, Sultan Palya',  412),
('DRZG2LO', 11 ,'Mandya, R.T Nagar', 650),
('DR9WO0A', 12 , 'Mandya, Sultan Palya',  412),
('DRCRZ3Q', 13 ,'Bengaluru, Cox Town', 465);

INSERT INTO user(email_id, password, first_name, last_name, phone_number)
VALUES
('vvijayk1999@github.io', '$2y$10$LkhUTunvrcN5jfBV/R1b5O14Z0i6.6wpSkLE0uvLl4heGP8X7ZVAW','', '', '');