-- ===tables===

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
booking_id bigint auto_increment primary key,
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

-- ===views===

create view v_flight as
SELECT A.flight_id,A.flight_number,A.company_id,A.departure_airport_id,A.destination_airport_id,
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

create view v_booking as
select a.booking_id,a.user_id,a.reference,a.status,a.booking_time,a.total_price,
b.flight_id,b.flight_number,b.company_id,b.departure_airport_id,b.destination_airport_id,
b.departure_date,b.departure_time,b.destination_date,b.destination_time,b.stop_over,b.price,
b.dep_code,b.dep_name,b.dep_city,
b.des_code,b.des_name,b.des_city,
b.name_en,b.name_cn
from booking a
inner join v_flight b
on a.flight_id = b.flight_id;
