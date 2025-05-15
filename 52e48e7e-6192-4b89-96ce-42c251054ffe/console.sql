create database Session09;
use Session09;
create table Customer
(
    id       int auto_increment primary key,
    username varchar(255) not null,
    phone    varchar(12)  not null unique,
    address  varchar(255) not null,
    gender   bit,
    email    varchar(255) not null unique,
    password varchar(255) not null
);
delimiter \\
create procedure get_all_customer()
begin
    select *from Customer;
end \\
delimiter \\;
CALL get_all_customer();
create table Movies
(
    id          int auto_increment primary key,
    title       varchar(255) not null,
    director    varchar(255) not null,
    genre       varchar(255) not null,
    description varchar(255) not null,
    duration    int          not null,
    language    varchar(255) not null
);
INSERT INTO Movies (title, director, genre, description, duration, language)
VALUES ('Inception', 'Christopher Nolan', 'Science Fiction', 'A thief enters dreams to steal secrets.', 148, 'English'),
       ('Parasite', 'Bong Joon Ho', 'Thriller', 'A poor family schemes to work for a wealthy family.', 132, 'Korean'),
       ('The Dark Knight', 'Christopher Nolan', 'Action', 'Batman faces the Joker in Gotham.', 152, 'English'),
       ('Spirited Away', 'Hayao Miyazaki', 'Animation', 'A girl enters a magical world.', 125, 'Japanese'),
       ('The Godfather', 'Francis Ford Coppola', 'Crime',
        'The aging patriarch of an organized crime dynasty transfers control.', 175, 'English'),
       ('Your Name', 'Makoto Shinkai', 'Romance', 'Two teenagers swap bodies mysteriously.', 112, 'Japanese'),
       ('Interstellar', 'Christopher Nolan', 'Science Fiction', 'A team travels through a wormhole to save humanity.',
        169, 'English'),
       ('Avengers: Endgame', 'Anthony Russo, Joe Russo', 'Superhero', 'The Avengers unite to reverse the snap.', 181,
        'English'),
       ('La La Land', 'Damien Chazelle', 'Musical', 'A musician and an actress pursue their dreams.', 128, 'English'),
       ('The Shawshank Redemption', 'Frank Darabont', 'Drama', 'Two imprisoned men bond over years.', 142, 'English');
delimiter \\
create procedure get_all_movies()
begin
    select *from Movies;
end \\
create procedure get_detail_movie(id_in int)
begin
    select *from Movies where id = id_in;
end \\
delimiter \\;

create table screenroom
(
    id             bigint primary key auto_increment,
    screenroomname varchar(255) not null,
    totalseat      int          not null
);

create table schedule
(
    id             bigint primary key auto_increment,
    movietitle     varchar(255) not null,
    showtime       datetime     not null,
    screenroomid   bigint       not null,
    availableseats int          not null,
    format         varchar(10)  not null,
    constraint fk_screenroom
        foreign key (screenroomid) references screenroom (id)
            on delete cascade
            on update cascade
);
insert into screenroom (screenroomname, totalseat)
values ('Phòng chiếu 1', 100),
       ('Phòng chiếu 2', 80),
       ('Phòng chiếu 3', 120),
       ('Phòng chiếu 4', 150),
       ('Phòng chiếu 5', 90);
insert into schedule (movietitle, showtime, screenroomid, availableseats, format)
values ('Avengers: Endgame', '2025-05-20 18:30:00', 1, 100, '2D'),
       ('Spiderman: No Way Home', '2025-05-20 20:00:00', 2, 80, '3D'),
       ('Inception', '2025-05-21 19:00:00', 3, 120, '2D'),
       ('The Batman', '2025-05-22 21:00:00', 1, 100, '3D'),
       ('Interstellar', '2025-05-23 18:00:00', 4, 150, '2D'),
       ('Joker', '2025-05-24 20:30:00', 5, 90, '2D'),
       ('Tenet', '2025-05-25 19:15:00', 2, 80, '3D'),
       ('Dune', '2025-05-26 21:00:00', 3, 120, '3D'),
       ('Black Widow', '2025-05-27 17:00:00', 4, 150, '2D'),
       ('The Matrix Resurrections', '2025-05-28 19:30:00', 5, 90, '3D'),
       ('Doctor Strange', '2025-05-29 20:00:00', 1, 100, '3D'),
       ('Guardians of the Galaxy', '2025-05-30 18:45:00', 2, 80, '2D'),
       ('Thor: Ragnarok', '2025-05-31 21:15:00', 3, 120, '3D');
delimiter \\
CREATE PROCEDURE find_all_schedulebyMovie()
BEGIN
    SELECT schedule.id,
           schedule.movietitle,
           schedule.showtime,
           s.screenroomname,
           schedule.availableseats,
           schedule.format
    FROM schedule
             JOIN screenroom s ON s.id = schedule.screenroomid
    WHERE showtime >= NOW()
    ORDER BY showtime;
END \\
create procedure show_movie_details(
    input_movie_title varchar(255)
)
begin
    select id,
           movieTitle,
           showtime,
           screenroomid,
           availableseats,
           format
    from schedule
    where movieTitle = input_movie_title
      and showtime >= now()
    order by showtime;
end \\
delimiter \\;
drop procedure find_all_schedulebyMovie;
drop procedure show_movie_details;
CALL find_all_schedulebyMovie();
DELIMITER $$

CREATE PROCEDURE find_schedule_by_id(IN schedule_id BIGINT)
BEGIN
    SELECT s.id,
           s.movietitle,
           s.showtime,
           s.availableseats,
           s.format,
           r.screenroomname
    FROM schedule s
             JOIN screenroom r ON s.screenroomid = r.id
    WHERE s.id = schedule_id;
END $$
DELIMITER ;
drop table schedule;
drop table screenroom;

create table seats
(
    id           bigint primary key auto_increment,
    screenroomid bigint      not null,
    seat_number  varchar(10) not null,
    price        double      default 50000,
    status       varchar(20) default 'available',
    foreign key (screenroomid) references screenroom (id)
        on delete cascade
        on update cascade
);

create table tickets
(
    id         bigint primary key auto_increment,
    customerid bigint not null,
    scheduleid bigint not null,
    totalmoney double not null,
    created_at datetime default current_timestamp,
    foreign key (scheduleid) references schedule (id)
        on delete cascade
        on update cascade
);

create table ticket_seats
(
    ticket_id bigint,
    seat_id   bigint,
    primary key (ticket_id, seat_id),
    foreign key (ticket_id) references tickets (id)
        on delete cascade,
    foreign key (seat_id) references seats (id)
        on delete cascade
);
DELIMITER $$

CREATE PROCEDURE add_ticket_with_seats(
    IN p_customer_id BIGINT,
    IN p_schedule_id BIGINT,
    IN p_total_money DOUBLE
)
BEGIN
    INSERT INTO tickets (customerid, scheduleid, totalmoney)
    VALUES (p_customer_id, p_schedule_id, p_total_money);
END $$

DELIMITER ;
delimiter \\
CREATE PROCEDURE add_ticket (
    IN p_customer_id BIGINT,
    IN p_schedule_id BIGINT,
    IN p_total_money DOUBLE
)
BEGIN
    INSERT INTO tickets (customerid, scheduleid, totalmoney)
    VALUES (p_customer_id, p_schedule_id, p_total_money);
END;
CREATE PROCEDURE get_last_ticket_id()
BEGIN
    SELECT LAST_INSERT_ID() AS ticket_id;
END;
CREATE PROCEDURE add_ticket_seat (
    IN p_ticket_id BIGINT,
    IN p_seat_id BIGINT
)
BEGIN
    INSERT INTO ticket_seats (ticket_id, seat_id)
    VALUES (p_ticket_id, p_seat_id);
END;
CREATE PROCEDURE update_seat_status (
    IN p_seat_id BIGINT,
    IN p_status VARCHAR(20)
)
BEGIN
    UPDATE seats SET status = p_status WHERE id = p_seat_id;
END;
CREATE PROCEDURE update_available_seats (
    IN p_schedule_id BIGINT,
    IN p_seat_count INT
)
BEGIN
    UPDATE schedule
    SET availableseats = availableseats - p_seat_count
    WHERE id = p_schedule_id;
END;
delimiter \\;
