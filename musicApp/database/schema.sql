DROP TABLE IF EXISTS Login CASCADE;
DROP TABLE IF EXISTS UserAccount CASCADE;
DROP TABLE IF EXISTS song_genres CASCADE;
DROP TABLE IF EXISTS Song CASCADE;
DROP TABLE IF EXISTS Album CASCADE;
DROP TABLE IF EXISTS Artist CASCADE;
DROP TABLE IF EXISTS Genre CASCADE;

-- UserAccount table with roles
CREATE TABLE UserAccount (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    role VARCHAR(20) CHECK (role IN ('ADMIN', 'USER', 'VIEWER'))
);

CREATE TABLE Login(
    user_id INT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES UserAccount(id) ON DELETE SET NULL
);

CREATE TABLE Artist (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    bio VARCHAR(500)
);

CREATE TABLE Album (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    artist_id INT,
    cover VARCHAR(255),
    songs INT[],
    FOREIGN KEY(artist_id) REFERENCES Artist(id) ON DELETE SET NULL
);

CREATE TABLE Genre (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Song (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    runtime INT NOT NULL,
    cover VARCHAR(255),
    artist_id INT,
    genre_id INT,
    FOREIGN KEY(artist_id) REFERENCES Artist(id) ON DELETE SET NULL,
    FOREIGN KEY(genre_id) REFERENCES Genre(id) ON DELETE SET NULL
);

CREATE TABLE song_genres (
    song_id INT NOT NULL REFERENCES Song(id) ON DELETE CASCADE,
    genre_id INT NOT NULL REFERENCES Genre(id) ON DELETE CASCADE,
    PRIMARY KEY (song_id, genre_id)
);

INSERT INTO Artist VALUES
(DEFAULT,'Artist1','Bio for Artist1'),
(DEFAULT,'Artist2','Bio for Artist2'),
(DEFAULT,'Artist3','Bio for Artist3');

INSERT INTO Album VALUES
(DEFAULT,'Album1',1,'https://example.com/cover1.jpg',ARRAY[1,2]),
(DEFAULT,'Album2',2,'https://example.com/cover2.jpg',ARRAY[3,4]),
(DEFAULT,'Album3',3,'https://example.com/cover3.jpg',ARRAY[5,6]);

INSERT INTO Genre VALUES
(DEFAULT,'Rock'),
(DEFAULT,'Pop'),
(DEFAULT,'Jazz');

INSERT INTO Song VALUES
(DEFAULT,'Song1',100,'https://example.com/cover1.jpg',1,1),
(DEFAULT,'Song2',200,'https://example.com/cover2.jpg',2,2),
(DEFAULT,'Song3',300,'https://example.com/cover3.jpg',3,3);

INSERT INTO song_genres (song_id, genre_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO UserAccount VALUES
(DEFAULT,'Dev0','Dev0@Dev.com','ADMIN'),
(DEFAULT,'Dev1','Dev1@Dev.com','USER'),
(DEFAULT,'Dev2','Dev2@Dev.com','VIEWER');

INSERT INTO Login VALUES
(1,'Development_Admin','$2a$12$UiNhYbMhxhGZ07xtdMkCgOH6dXyN69Mqya3IzBmSGufY24Umxx/mi'),
(2,'Development_User','$2a$12$UiNhYbMhxhGZ07xtdMkCgOH6dXyN69Mqya3IzBmSGufY24Umxx/mi'),
(3,'Development_Viewer','$2a$12$UiNhYbMhxhGZ07xtdMkCgOH6dXyN69Mqya3IzBmSGufY24Umxx/mi');