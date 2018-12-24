CREATE TABLE cars (
  id      INT                                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(255)                        NOT NULL,
  body    VARCHAR(255)                        NOT NULL,
  engine  VARCHAR(255)                        NOT NULL,
  color   VARCHAR(255)                        NOT NULL,
  price   INT                                 NOT NULL,
  sold    TINYINT(1)                          NOT NULL,
  user_id INT                                 NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
)
  ENGINE = InnoDB;

INSERT INTO cars VALUES (2, 'Dodge', 'Coupe', 'Gas', '#00e6e6', 1000, 0, 1);
INSERT INTO cars VALUES (2, 'BMV', 'Coupe', 'Gas', '#ff6666', 1000, 0, 1);
