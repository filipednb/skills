CREATE TABLE IF NOT EXISTS skill_entity (
    id bigint NOT NULL,
    description VARCHAR(255),
    user_id bigint NOT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS user_entity (
    id bigint not null,
    email varchar(255),
    name varchar(255),
    password varchar(255),
    primary key (id)
) ENGINE=INNODB;

ALTER TABLE skill_entity
    ADD CONSTRAINT FK_user_skill
    FOREIGN KEY (user_id) REFERENCES user_entity (id);