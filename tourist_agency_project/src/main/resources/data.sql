


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


INSERT INTO Traveler(id) VALUES (4000);
INSERT INTO Traveler(id) VALUES (5000);
INSERT INTO Traveler(id) VALUES (6000);
INSERT INTO Traveler(id) VALUES (7000);


INSERT INTO Category(id, category_name) VALUES (1000, 'Summer');
INSERT INTO Category(id, category_name) VALUES (2000, 'Cruise');
INSERT INTO Category(id, category_name) VALUES (3000, 'European cities');
INSERT INTO Category(id, category_name) VALUES (4000, 'Winter');
INSERT INTO Category(id, category_name) VALUES (5000, 'Distant destinations');


INSERT INTO Category(id, category_name, parent_category_id) VALUES (1001, 'Greece', 1000);
INSERT INTO Category(id, category_name, parent_category_id) VALUES (1002, 'Italy', 1000);
INSERT INTO Category(id, category_name, parent_category_id) VALUES (1003, 'Montenegro', 1000);
INSERT INTO Category(id, category_name, parent_category_id) VALUES (2001, 'Mediterranean cruise', 2000);


INSERT INTO Destination(id, destination_name, destination_description, destination_country, hotel_name )
    VALUES (1000, 'Montecatini', 'Montecatini terme', 'Italy', 'Hotel Le Fonti 4*');
INSERT INTO Destination(id, destination_name, destination_description, destination_country, hotel_name )
    VALUES (2000, 'Athens', 'Athens – The capital of Greece and the center of the ancient world, Athens is the perfect place for your next adventure. With its rich history, ancient ruins, incredible food, and quintessential Mediterranean charm, it''s hard not to fall in love with Athens.',
            'Greece', 'Hotel Lido 2*');
INSERT INTO Destination(id, destination_name, destination_description, destination_country, hotel_name )
    VALUES (3000, 'Osaka', 'It is the capital of and most populous city in Osaka Prefecture, and the third-most populous city in Japan, following the special wards of Tokyo and Yokohama.',
            'Japan', 'Hotel The One Shinimamiya');


INSERT INTO  hotel_pictures(destination_id, hotel_picture)
    VALUES
        (1000, 'hp1'),
        (1000, 'hp2'),
        (1000, 'hp3');
INSERT INTO  hotel_pictures(destination_id, hotel_picture)
VALUES
    (2000, 'hp1'),
    (2000, 'hp2'),
    (2000, 'hp3');
INSERT INTO  hotel_pictures(destination_id, hotel_picture)
VALUES
    (3000, 'hp1'),
    (3000, 'hp2'),
    (3000, 'hp3');



INSERT INTO tourist_package(id, package_name, package_description, time, date_off_departure, return_date, package_price, capacity,
                            schedule, price_includes, price_does_not_include,travel_notes, category_id, organizer_id, destination_id)
    VALUES (1000, 'Toscana', 'Discover the Charm of Tuscany- Tuscany, a region in central Italy, is a dream destination for travelers seeking a blend of history, culture  and breathtaking landscapes. With its rolling hills, vineyards, and historic cities, Tuscany offers a unique experience that captures the essence of Italy.',
            6, '2024-10-20', '2024-10-26', 150, 80, '1.  departure   2. FLORENCE - MONTECATINI TERME   3. MONTECATINI - SIENA - S. ĐIMINJANO   4. MONTECATINI TERME – LUCCA - PISA   5. MONTECATINI - CINQUE TERRE   6. returning to Serbia '
           , 'Tourist tax, international health insurance'
           , 'Optional excursion','With breakfast', 1002,2000, 1000);


INSERT INTO tourist_package(id, package_name, package_description, time, date_off_departure, return_date, package_price, capacity,
                            schedule, price_includes, price_does_not_include, category_id, organizer_id, destination_id)
VALUES (2000, 'Athens', 'Athens – The capital of Greece and the center of the ancient world, Athens is the perfect place for your next adventure. With its rich history, ancient ruins, incredible food, and quintessential Mediterranean charm, it''s hard not to fall in love with Athens. From the Acropolis to the countless narrow streets of Monastiraki, where you can find all kinds of trinkets and souvenirs, and even pieces of history, to the ruins of Hadrian''s Library and the ancient Agora, you''ll never be bored in Athens. Considering that the Aegean Sea is just about 20 minutes away by car, and beaches like Glyfada are breathtaking, there''s no better expedition!',
        3, '2024-10-20', '2024-10-26', 200, 40, '1.departure   2.,3.,4.,5.,   6. - returning to Serbia '
       , 'Tourist tax, international health insurance'
       , 'Optional excursion', 1001,2000, 2000);


INSERT INTO tourist_package(id, package_name, package_description, time, date_off_departure, return_date, package_price, capacity,
                            schedule, price_includes, price_does_not_include, category_id, organizer_id, destination_id)
VALUES (3000, 'Japan','Japan offers a fascinating blend of traditional and modern culture. Visit Tokyo, a vibrant metropolis with dazzling neon lights and impressive temples like Senso-ji. Experience tranquility in Kyoto, home to ancient Buddhist temples and beautiful Zen gardens. Don’t miss the natural beauty of Mount Fuji and lush tea plantations.' ,
        12, '2024-9-14', '2024-9-26', 1000, 20,'1st DAY - Departure; 2nd DAY - Arrival in Tokyo; explore Asakusa and Senso-ji Temple; 3rd DAY - Tokyo; visit Shibuya and Shinjuku; 4th DAY - Tokyo; explore Akihabara and Ueno Park; 5th DAY - Tokyo; day trip to Odaiba; 6th DAY - Travel to Kyoto; visit Fushimi Inari Taisha Shrine; 7th DAY - Kyoto; explore Kinkaku-ji and Ryoan-ji; 8th DAY - Kyoto; visit Gion district and Kiyomizu-dera; 9th DAY - Travel to Osaka; visit Osaka Castle; 10th DAY - Osaka; explore Dotonbori and Shinsaibashi; 11th DAY - Day trip to Himeji; visit Himeji Castle; 12th DAY - Return home.'
       , 'Tourist tax, international health insurance'
       , 'Optional excursion', 5000, 3000,3000);


INSERT INTO pictures_of_the_destination(package_id, destination_picture)
VALUES
    (1000, 'ds1'),
    (1000, 'ds2'),
    (1000, 'ds3');
INSERT INTO pictures_of_the_destination(package_id, destination_picture)
VALUES
    (2000, 'ds1'),
    (2000, 'ds2'),
    (2000, 'ds3');
INSERT INTO pictures_of_the_destination(package_id, destination_picture)
VALUES
    (3000, 'ds1'),
    (3000, 'ds2'),
    (3000, 'ds3');


INSERT INTO traveler_tourist_package(traveler_id, tourist_package_id) VALUES (4000, 1000);
INSERT INTO traveler_tourist_package(traveler_id, tourist_package_id) VALUES (5000, 3000);
INSERT INTO traveler_tourist_package(traveler_id, tourist_package_id) VALUES (7000, 3000);


INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                     place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id, tourist_package_id )
    VALUES (1000, 3 , '2024-07-28',  'ON_HOLD', 150, 'Mirko', 'Mirkovic', 'mire@example.com', '06591482111', '182435142445', 'Beograd'
       , 'Beograd', 'PAYMENT_SLIP', 4000,1000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                     place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id, tourist_package_id  )
    VALUES (2000, 3, '2024-08-10',  'CONFIRMED', 150, 'Mirko', 'Mirkovic', 'mire@example.com', '06591482111', '182435142445', 'Beograd'
       , 'Beograd', 'PAYMENT_SLIP', 4000, 1000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                    , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence,
                    place_of_entry_into_the_bus, payment, user_who_made_the_reservation_id, tourist_package_id  )
    VALUES (3000, 3 , '2024-07-28',  'REJECTED', 200, 'Aleksa', 'Aleksic', 'aleksa@example.com', '065914823', '182435142555', 'Sombor'
       , 'Novi Sad', 'PAYMENT_CARD', 6000,2000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                    , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence
                    , payment, user_who_made_the_reservation_id, tourist_package_id  )
    VALUES (4000, 4 , '2024-07-20',  'CONFIRMED', 1000, 'Maja', 'Maric', 'maja@example.com', '0659148211', '180235142445', 'Jagodina'
       , 'PAYMENT_SLIP', 7000, 3000);
INSERT INTO Reservation(id, number_of_people, date_of_reservation, reservation_status, reservation_price, passenger_name
                     , passenger_last_name, passenger_email, passenger_number, passenger_jmbg, place_of_residence
                    , payment, user_who_made_the_reservation_id, tourist_package_id )
    VALUES (5000, 6 , '2024-07-18',  'CONFIRMED', 1000, 'Petar', 'Pekic', 'petar@example.com', '0659148244', '182435133445', 'Beograd'
       , 'PAYMENT_SLIP', 5000, 3000);


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


INSERT INTO trip(id, trip_name, trip_description, trip_price, tourist_package_id)
    VALUES (1000, 'Florence', 'Santa Maria del Fiore Cathedral (Duomo), Uffizi Gallery, Ponte Vecchio, Palazzo Pitti and Boboli Gardens
            Galleria dell Accademia...', 30, 1000 );
INSERT INTO trip(id, trip_name, trip_description, trip_price, tourist_package_id)
    VALUES (2000, 'Siena', 'Piazza del Campo, Siena Cathedral, Torre del Mangia, Palazzo Pubblico, Basilica of San Domenico...', 30, 1000 );
INSERT INTO trip(id, trip_name, trip_description, trip_price, tourist_package_id)
    VALUES (3000, 'Lucca-Pisa', 'Leaning Tower of Pisa, Piazza dei Miracoli, Pisa Cathedral...', 35, 1000 );
INSERT INTO trip(id, trip_name, trip_description, trip_price, tourist_package_id)
    VALUES (4000, 'Cinque terre', 'Monterosso al Mare, Vernazza, Riomaggiore...', 40, 1000 );
INSERT INTO trip(id, trip_name, trip_description, trip_price, tourist_package_id)
    VALUES (5000, 'Acropolis of Athens', 'The Acropolis is an ancient citadel in Athens renowned for its historic ruins, including the Parthenon, and its significant role in classical Greek culture...'
           , 20, 2000 );

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
