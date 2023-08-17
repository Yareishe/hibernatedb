INSERT INTO client (name) VALUES
                              ('John Doe'),
                              ('Jane Smith'),
                              ('Michael Johnson'),
                              ('Emily Williams'),
                              ('David Brown'),
                              ('Sarah Davis'),
                              ('Robert Wilson'),
                              ('Olivia Moore'),
                              ('William Taylor'),
                              ('Sophia Anderson');


INSERT INTO planet (id, name) VALUES
                                  ('MARS', 'Mars'),
                                  ('VEN', 'Venus'),
                                  ('JUP', 'Jupiter'),
                                  ('SAT', 'Saturn'),
                                  ('NEP', 'Neptune');


INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                             ('2023-08-10 08:00:00', 1, 'MARS', 'VEN'),
                                                                             ('2023-08-11 10:30:00', 2, 'VEN', 'MARS'),
                                                                             ('2023-08-12 12:15:00', 3, 'JUP', 'SAT'),
                                                                             ('2023-08-13 15:45:00', 4, 'MARS', 'JUP'),
                                                                             ('2023-08-14 17:20:00', 5, 'NEP', 'SAT'),
                                                                             ('2023-08-15 09:30:00', 6, 'SAT', 'VEN'),
                                                                             ('2023-08-16 11:45:00', 7, 'JUP', 'NEP'),
                                                                             ('2023-08-17 13:30:00', 8, 'VEN', 'MARS'),
                                                                             ('2023-08-18 14:15:00', 9, 'SAT', 'NEP'),
                                                                             ('2023-08-19 16:00:00', 10, 'MARS', 'JUP');