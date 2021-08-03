DROP TABLE IF EXISTS auth_token;

CREATE TABLE auth_token (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              access_token VARCHAR(250) NOT NULL,
                              expires_in VARCHAR(250) NOT NULL,
                              token_type VARCHAR(250) DEFAULT NULL
);