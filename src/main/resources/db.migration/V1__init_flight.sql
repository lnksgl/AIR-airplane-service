create table model (
    id serial not null primary key,
    name varchar(255) not null
);

create table airplane (
    id serial primary key,
    capacity smallint not null,
    model_id int not null,
    constraint airplane_model_id_fk foreign key (model_id) references model (id)
);

create table route_cities (
    id serial primary key,
    name varchar(255) not null
);

create table route (
    id serial primary key,
    airplane_id int not null,
    route_cities_id int not null,
    date timestamp not null,
    constraint route_airplane_id_fk foreign key (airplane_id) references airplane (id),
    constraint route_route_cities_fk foreign key (route_cities_id) references route_cities (id)
);

create table flight (
    id serial primary key,
    name varchar(255) not null,
    date timestamp not null,
    place varchar(4) not null,
    price decimal not null,
    user_id int,
    route_id int not null,
    constraint flight_route_id_fk foreign key (route_id) references route (id)
);