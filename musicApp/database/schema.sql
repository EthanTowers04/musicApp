DROP TABLE IF EXISTS login CASCADE;
DROP TABLE IF EXISTS user_account CASCADE;
DROP TABLE IF EXISTS album_songs CASCADE;
DROP TABLE IF EXISTS song_genres CASCADE;
DROP TABLE IF EXISTS song CASCADE;
DROP TABLE IF EXISTS album CASCADE;
DROP TABLE IF EXISTS artist CASCADE;
DROP TABLE IF EXISTS genre CASCADE;
DROP TABLE IF EXISTS album_review CASCADE;
DROP TABLE IF EXISTS song_review CASCADE;
DROP TABLE IF EXISTS song_rating CASCADE;
DROP TABLE IF EXISTS album_rating CASCADE;

-- user_account table with roles
CREATE TABLE user_account (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    role VARCHAR(20) CHECK (role IN ('ADMIN', 'USER', 'VIEWER'))
);

CREATE TABLE login (
    user_id INT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user_account(id) ON DELETE SET NULL
);

CREATE TABLE artist (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    bio VARCHAR(500)
);

CREATE TABLE album (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    artist_id INT,
    cover VARCHAR(255),
    FOREIGN KEY(artist_id) REFERENCES artist(id) ON DELETE SET NULL
);

CREATE TABLE genre (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT
);

CREATE TABLE song (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    runtime INT NOT NULL,
    cover VARCHAR(255),
    artist_id INT,
    FOREIGN KEY(artist_id) REFERENCES artist(id) ON DELETE SET NULL
);

CREATE TABLE album_songs (
    album_id INT NOT NULL REFERENCES album(id) ON DELETE CASCADE,
    song_id INT NOT NULL UNIQUE REFERENCES song(id) ON DELETE CASCADE,
    PRIMARY KEY (album_id, song_id)
);

CREATE TABLE song_genres (
    song_id INT NOT NULL REFERENCES song(id) ON DELETE CASCADE,
    genre_id INT NOT NULL REFERENCES genre(id) ON DELETE CASCADE,
    PRIMARY KEY (song_id, genre_id)
);

CREATE TABLE album_review (
    review_no INT,
    user_id INT NOT NULL REFERENCES user_account(id) ON DELETE CASCADE,
    album_id INT NOT NULL REFERENCES album(id) ON DELETE CASCADE,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    PRIMARY KEY (review_no, user_id, album_id)
);

CREATE TABLE song_review (
    review_no INT,
    user_id INT NOT NULL REFERENCES user_account(id) ON DELETE CASCADE,
    song_id INT NOT NULL REFERENCES song(id) ON DELETE CASCADE,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    PRIMARY KEY (review_no, user_id, song_id)
);

CREATE TABLE song_rating (
    rating INT CHECK (rating >= 1 AND rating <= 5),
    user_id INT NOT NULL REFERENCES user_account(id) ON DELETE CASCADE,
    song_id INT REFERENCES song(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, song_id)
);

CREATE TABLE album_rating (
    rating INT CHECK (rating >= 1 AND rating <= 5),
    user_id INT NOT NULL REFERENCES user_account(id) ON DELETE CASCADE,
    album_id INT REFERENCES album(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, album_id)
);

INSERT INTO artist VALUES
(DEFAULT,'Artist1','Bio for Artist1'),
(DEFAULT,'Artist2','Bio for Artist2'),
(DEFAULT,'Artist3','Bio for Artist3');

INSERT INTO album VALUES
(DEFAULT,'Album1',1,'https://example.com/cover1.jpg'),
(DEFAULT,'Album2',2,'https://example.com/cover2.jpg'),
(DEFAULT,'Album3',3,'https://example.com/cover3.jpg');

INSERT INTO genre VALUES
(DEFAULT,'Rock','Rock music is a genre of popular music that originated as "rock and roll" in the United States in the late 1940s and early 1950s. It has since developed into a range of different styles and subgenres.'),
(DEFAULT,'Pop', 'Pop music is a genre of popular music that originated in its modern form during the mid-1950s in the United States and the United Kingdom. The terms "popular music" and "pop music" are often used interchangeably, although the former describes all music that is popular and includes many disparate styles.'),
(DEFAULT,'Jazz', 'Jazz is a music genre that originated in the African-American communities of New Orleans, United States, in the late 19th and early 20th centuries, with its roots in blues and ragtime. Jazz is seen by many as "Americas classical music". Since the 1920s Jazz Age, it has been recognized as a major form of musical expression. It then emerged in the form of independent traditional and popular musical styles, all linked by the common bonds of African-American and European-American musical parentage with a performance orientation. Jazz is characterized by swing and blue notes, call and response vocals, polyrhythms and improvisation.');

INSERT INTO song VALUES
(DEFAULT,'Song1',100,'https://example.com/cover1.jpg',1),
(DEFAULT,'Song2',200,'https://example.com/cover2.jpg',2),
(DEFAULT,'Song3',300,'https://example.com/cover3.jpg',3),
(DEFAULT,'Song4',240,'https://example.com/cover4.jpg',1),
(DEFAULT,'Song5',260,'https://example.com/cover5.jpg',2),
(DEFAULT,'Song6',280,'https://example.com/cover6.jpg',3);

INSERT INTO album_songs (album_id, song_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6);

INSERT INTO song_genres (song_id, genre_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO user_account VALUES
(DEFAULT,'Dev0','Dev0@Dev.com','ADMIN'),
(DEFAULT,'Dev1','Dev1@Dev.com','USER'),
(DEFAULT,'Dev2','Dev2@Dev.com','VIEWER');

INSERT INTO login VALUES
(1,'Development_Admin','$2a$12$UiNhYbMhxhGZ07xtdMkCgOH6dXyN69Mqya3IzBmSGufY24Umxx/mi'),
(2,'Development_User','$2a$12$UiNhYbMhxhGZ07xtdMkCgOH6dXyN69Mqya3IzBmSGufY24Umxx/mi'),
(3,'Development_Viewer','$2a$12$UiNhYbMhxhGZ07xtdMkCgOH6dXyN69Mqya3IzBmSGufY24Umxx/mi');