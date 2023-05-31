INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','KORISNIK');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','KORISNIK');

INSERT INTO team (id, name, code) values (1, 'Argentina', 'ARG');
INSERT INTO team (id, name, code) values (2, 'Serbia', 'SRB');
INSERT INTO team (id, name, code) values (3, 'Portugal', 'POR');

INSERT INTO player (id, name, last_name, goals, team_id) values (1, 'Dusan', 'Vlahovic', 5, 2);
INSERT INTO player (id, name, last_name, goals, team_id) values (2, 'Cristiano', 'Ronaldo', 7, 3);
INSERT INTO player (id, name, last_name, goals, team_id) values (3, 'Lionel', 'Messi', 10, 1);
INSERT INTO player (id, name, last_name, goals, team_id) values (4, 'Aleksandar', 'Mitrovic', 10, 2);
INSERT INTO player (id, name, last_name, goals, team_id) values (5, 'Sergio', 'Aguero', 4, 1);
INSERT INTO player (id, name, last_name, goals, team_id) values (6, 'Bruno', 'Fernandes', 1, 3);

INSERT INTO game (id, team_a_id, team_b_id, goals_a, goals_b) values (1, 2, 1, 0, 3);
INSERT INTO game (id, team_a_id, team_b_id, goals_a, goals_b) values (2, 1, 3, 4, 1);
INSERT INTO game (id, team_a_id, team_b_id, goals_a, goals_b) values (3, 3, 2, 2, 1);