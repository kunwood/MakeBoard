CREATE DATABASE BOARD;
USE BOARD;

# User(user_email[PK],
#		user_password,
#		user_nickname,
#		user_phone_number,
#		user_address,
#		user_profile)
CREATE TABLE User (
	user_email VARCHAR(50) PRIMARY KEY,
    user_password VARCHAR(20) NOT NULL,
    user_nickname VARCHAR(30) NOT NULL,
    user_phone_number VARCHAR(15) NOT NULL,
    user_address TEXT NOT NULL,
    user_profile TEXT
);

# Board(board_number[PK],
#		board_title,
#		board_content,
#		board_image,
#		board_video,
#		board_file,
#		board_writer_email[FK-User(user_email)],
#		board_write_date,
#		board_click_count,
#		board_writer_profile,
#		board_writer_nickname,
#		board_like_count,
#		board_comment_count)
CREATE TABLE Board (
	board_number INT PRIMARY KEY AUTO_INCREMENT,
    board_title VARCHAR(200) NOT NULL,
    board_content TEXT NOT NULL,
    board_image TEXT,
    board_video TEXT,
    board_file TEXT,
    board_writer_email VARCHAR(50) NOT NULL,
    board_writer_profile TEXT,
    board_writer_nickname VARCHAR(30) NOT NULL,
    board_write_date DATE NOT NULL,
    board_click_count INT DEFAULT 0,
    board_like_count INT DEFAULT 0,
    board_comment_count INT DEFAULT 0
);
# PopularSearch(popular_term[PK],
#				popular_search_count)
CREATE TABLE PopularSearch (
	popular_term VARCHAR(200) PRIMARY KEY,
    popular_search_count INT DEFAULT 1
);
# Liky(board_number[FK-Board(board_number)],
#		user_email[FK-User(user_email)],
#		like_user_profile,
#		like_user_nickname)
CREATE TABLE Liky (
	board_number INT NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    like_user_profile TEXT,
    like_user_nickname VARCHAR(30) NOT NULL
);
# Comment(board_number[FK-Board(board_number)],
#		  user_email[FK-User(user_email)],
#		  comment_write_date,
#		  comment_content,
#		  like_user_profile,
#		  like_user_nickname)
CREATE TABLE Comment (
	board_number INT NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    comment_write_date DATE NOT NULL,
    comment_content TEXT NOT NULL,
    like_user_profile TEXT,
    like_user_nickname VARCHAR(30) NOT NULL
);
# User - Board 관계
# 1. User가 Board를 작성한다.			1 : n
# 2. User가 Board에 좋아요를 행한다.		n : m
# 3. User가 Board에 댓글을 단다.		n : m
