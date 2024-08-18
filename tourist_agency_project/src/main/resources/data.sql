


INSERT INTO App_user(id, name, last_name, username, email, phone_number, password, date_of_birth, user_photo, role)
    VALUES (1000, 'Ema', 'Milic', 'emma', 'ema@example.com', '0659148291', 'ema123', '1986-03-28', 'slika1.jpg', 'ADMIN');
INSERT INTO App_user(id, name, last_name, username, email, phone_number, password, date_of_birth, user_photo, role)
    VALUES (2000, 'Mia', 'Micic', 'mia01', 'mia01@example.com', '0659148212', 'mia123', '2001-03-28', 'slika2.jpg', 'ORGANIZER');
INSERT INTO App_user(id, name, last_name, username, email, phone_number, password, date_of_birth, user_photo, role)
    VALUES (3000, 'Sasa', 'Sasic', 'sale', 'sasa@example.com', '0659143391', 'sasa123', '2003-03-28', 'slika3.jpg', 'ORGANIZER');
INSERT INTO App_user(id, name, last_name, username, email, phone_number, password, date_of_birth, user_photo, role)
    VALUES (4000, 'Mirko', 'Mirkovic', 'mirkom', 'mire@example.com', '06591482111', 'mire123', '2000-03-28', 'slika4.jpg', 'TRAVELER');
INSERT INTO App_user(id, name, last_name, username, email, phone_number, password, date_of_birth, user_photo, role)
    VALUES (5000, 'Petar', 'Pekic', 'peka', 'petar@example.com', '0659148244', 'peka123', '2002-03-28', 'slika5.jpg', 'TRAVELER');
INSERT INTO App_user(id, name, last_name, username, email, phone_number, password, date_of_birth, user_photo, role)
    VALUES (6000, 'Aleksa', 'Aleksic', 'aleksa', 'aleksa@example.com', '0659148555', 'aleksa123', '2005-03-28', 'slika6.jpg', 'TRAVELER');
INSERT INTO App_user(id, name, last_name, username, email, phone_number, password, date_of_birth, user_photo, role)
    VALUES (7000, 'Maja', 'Maric', 'maki', 'maja@example.com', '0659148211', 'maja123', '2001-03-28', 'slika7.jpg', 'TRAVELER');


INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                     place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (1000, 40 , '2024-07-28',  'ON_HOLD', 15000, 'Mirko', 'Mirkovic', 'mire@example.com', '06591482111', '182435142445', 'Beograd'
       , 'Beograd', 'PAYMENT_SLIP', 4000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                     place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (2000, 80 , '2024-08-10',  'CONFIRMED', 15000, 'Mirko', 'Mirkovic', 'mire@example.com', '06591482111', '182435142445', 'Beograd'
       , 'Beograd', 'PAYMENT_SLIP', 4000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                    , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                    place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (3000, 40 , '2024-07-28',  'REJECTED', 20000, 'Aleksa', 'Aleksic', 'aleksa@example.com', '065914823', '182435142555', 'Sombor'
       , 'Novi Sad', 'PAYMENT_CARD', 6000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                    , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                    place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (4000, 10 , '2024-07-20',  'CONFIRMED', 100000, 'Maja', 'Maric', 'maja@example.com', '0659148211', '180235142445', 'Jagodina'
       , 'Beograd', 'PAYMENT_SLIP', 7000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                    place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (5000, 10 , '2024-07-18',  'CONFIRMED', 100000, 'Petar', 'Pekic', 'petar@example.com', '0659148244', '182435133445', 'Beograd'
       , 'Beograd', 'PAYMENT_SLIP', 5000);

INSERT INTO other_emails(reservation_id, email)
    VALUES
        (1000, 'misa@example.com'),
        (1000, 'pera@example.com'),
        (1000, 'stojkovic@example.com');
INSERT INTO other_emails(reservation_id, email)
VALUES
    (2000, 'milica@example.com'),
    (2000, 'tamara@example.com'),
    (2000, 'stefan@example.com');
INSERT INTO other_emails(reservation_id, email)
VALUES
    (3000, 'misa@example.com'),
    (3000, 'pera@example.com'),
    (3000, 'stojkovic@example.com');
INSERT INTO other_emails(reservation_id, email)
VALUES
    (4000, 'marina@example.com'),
    (4000, 'anastasia@example.com'),
    (4000, 'peric@example.com');
INSERT INTO other_emails(reservation_id, email)
VALUES
    (4000, 'stojke@example.com'),
    (4000, 'darko@example.com'),
    (4000, 'mile@example.com');
