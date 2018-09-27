CREATE TABLE IF NOT EXISTS user (
    user_id INT(11) AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    PRIMARY KEY ( user_id )
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS skill (
    skill_id INT(11) AUTO_INCREMENT,
    skill_description VARCHAR(255) NOT NULL,
    PRIMARY KEY ( skill_id )
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS user_skill (
    user_skill_id INT(11) AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    skill_id INT(11) NOT NULL,
    PRIMARY KEY ( user_skill_id ),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (skill_id) REFERENCES skill(skill_id)
)  ENGINE=INNODB;

