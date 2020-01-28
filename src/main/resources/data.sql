DROP TABLE IF EXISTS claims;

CREATE TABLE claims (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  created_by VARCHAR(250) NOT NULL,
  claim_id VARCHAR(250) NOT NULL

);

INSERT INTO claims (created_by, claim_id) VALUES
  ('Ganesh Sahu', 'FYO90877'),
  ('Bill', 'HJ8909234'),
  ('Folrunsho', 'YT67534');