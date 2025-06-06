-- ===Table===

create table user(
user_id bigint primary key,
email varchar(100) not null,
password varchar(255) unique,
first_name varchar(50) not null,
last_name varchar(50) not null,
country varchar(100) not null,
phone varchar(20) not null
);

create table airport(
airport_id bigint primary key,
code varchar(10) not null,
name varchar(100) not null,
city varchar(100) not null
);

create table company(
company_id varchar(10) primary key,
name_en varchar(100) not null default '',
name_cn varchar(100) not null default ''
);

create table flight(
flight_id bigint primary key,
flight_number varchar(10) not null,
company_id varchar(10) not null,
departure_airport_id bigint,
destination_airport_id bigint,
departure_date date not null,
departure_time time not null,
destination_date date not null,
destination_time time not null,
stop_over varchar(200) not null default '',
price decimal(10,2) not null,
foreign key (departure_airport_id) references airport(airport_id),
foreign key (destination_airport_id) references airport(airport_id),
foreign key (company_id) references company(company_id)
);

create table booking(
booking_id bigint primary key,
user_id bigint,
flight_id bigint,
reference varchar(20) not null,
status varchar(20) not null,
booking_time timestamp not null,
total_price decimal(10,2) not null,
foreign key (user_id) references user(user_id),
foreign key (flight_id) references flight(flight_id)
);

create table passenger(
passenger_id bigint primary key,
booking_id bigint,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(100) not null,
foreign key (booking_id) references booking(booking_id)
);

-- ===view===

create view v_flight as
SELECT A.flight_id flight_id,A.flight_number,A.company_id,A.departure_airport_id,A.destination_airport_id,
A.departure_date,A.departure_time,A.destination_date,A.destination_time,A.stop_over,A.price,
B.code dep_code,B.name dep_name,B.city dep_city,
C.code des_code,C.name des_name,C.city des_city,
D.name_en,D.name_cn
FROM flight A
INNER JOIN airport B
ON A.departure_airport_id=B.airport_id
INNER JOIN airport C
ON A.destination_airport_id=C.airport_id
INNER JOIN company D
ON A.company_id=D.company_id;

-- ===clean===

--alter table flight drop foreign key flight_ibfk_1;
--alter table flight drop foreign key flight_ibfk_2;
--alter table flight drop foreign key flight_ibfk_3;
--alter table booking drop foreign key booking_ibfk_1;
--alter table booking drop foreign key booking_ibfk_2;
--alter table passenger drop foreign key passenger_ibfk_1;
--drop table passenger,booking,flight,airport,company,user;
--drop view v_flight;
