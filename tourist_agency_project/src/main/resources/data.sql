


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

INSERT INTO Organizer(id) VALUES (2000);
INSERT INTO Organizer(id) VALUES (3000);

INSERT INTO Category(id, category_name) VALUES (1000, 'Summer');
INSERT INTO Category(id, category_name) VALUES (2000, 'Cruise');
INSERT INTO Category(id, category_name) VALUES (3000, 'European cities');
INSERT INTO Category(id, category_name) VALUES (4000, 'Winter');
INSERT INTO Category(id, category_name) VALUES (5000, 'Distant destinations');


INSERT INTO Category(id, category_name, parent_category_id) VALUES (1001, 'Greece', 1000);
INSERT INTO Category(id, category_name, parent_category_id) VALUES (1002, 'Italy', 1000);
INSERT INTO Category(id, category_name, parent_category_id) VALUES (1003, 'Montenegro', 1000);
INSERT INTO Category(id, category_name, parent_category_id) VALUES (2001, 'Mediterranean cruise', 2000);


INSERT INTO Tourist_package(id, package_name, package_description, time, date_off_departure, return_date, package_price, capacity,
                            schedule, price_includes, price_does_not_include, category_id, organizer_id)
    VALUES (1000, 'Toscana', 'Discover the Charm of Tuscany- Tuscany, a region in central Italy, is a dream destination for travelers seeking a blend of history, culture  and breathtaking landscapes. With its rolling hills, vineyards, and historic cities, Tuscany offers a unique experience that captures the essence of Italy.',
            6, '2024-10-20', '2024-10-26', 15000, 80, '1. DAN - polazak   2. DAN. - FIRENCA - MONTECATINI TERME   3. DAN. - MONTECATINI - SIENA - S. ĐIMINJANO   4. DAN. - MONTECATINI TERME – LUCA - PIZA   5. DAN. - MONTECATINI - CINQUE TERRE   6. DAN - vracanje u Srbiju '
           , 'Turisticka taksa, medjunarodno zdravstveno osiguranje'
           , 'Fakultativni izleti', 1002,2000);


INSERT INTO pictures_of_the_destination(package_id, destination_picture)
VALUES
    (1000, 'ds1'),
    (1000, 'ds2'),
    (1000, 'ds3');


INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                     place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (1000, 3 , '2024-07-28',  'ON_HOLD', 15000, 'Mirko', 'Mirkovic', 'mire@example.com', '06591482111', '182435142445', 'Beograd'
       , 'Beograd', 'PAYMENT_SLIP', 4000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                     place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (2000, 3, '2024-08-10',  'CONFIRMED', 15000, 'Mirko', 'Mirkovic', 'mire@example.com', '06591482111', '182435142445', 'Beograd'
       , 'Beograd', 'PAYMENT_SLIP', 4000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                    , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                    place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (3000, 3 , '2024-07-28',  'REJECTED', 20000, 'Aleksa', 'Aleksic', 'aleksa@example.com', '065914823', '182435142555', 'Sombor'
       , 'Novi Sad', 'PAYMENT_CARD', 6000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                    , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                    place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (4000, 4 , '2024-07-20',  'CONFIRMED', 100000, 'Maja', 'Maric', 'maja@example.com', '0659148211', '180235142445', 'Jagodina'
       , 'Beograd', 'PAYMENT_SLIP', 7000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                    place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id )
    VALUES (5000, 6 , '2024-07-18',  'CONFIRMED', 100000, 'Petar', 'Pekic', 'petar@example.com', '0659148244', '182435133445', 'Beograd'
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
        (4000, 'anastasia13@example.com'),
        (4000, 'peric@example.com');
INSERT INTO other_emails(reservation_id, email)
    VALUES
        (5000, 'stojke@example.com'),
        (5000, 'darko@example.com'),
        (5000, 'naruto@example.com'),
        (5000, 'vasilije@example.com'),
        (5000, 'davor@example.com'),
        (5000, 'mile@example.com');

/*
INSERT INTO Category(id, category_name)
    VALUES (1000, 'Summer');
INSERT INTO Category(id, category_name)
    VALUES (2000, 'Cruise');
INSERT INTO Category(id, category_name)
    VALUES (3000, 'European cities');
INSERT INTO Category(id, category_name)
    VALUES (4000, 'Winter');
INSERT INTO Category(id, category_name)
    VALUES (5000, 'Distant destinations');
*/
