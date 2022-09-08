CREATE TABLE IF NOT EXISTS courses (
  id                     VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
  title                   VARCHAR      NOT NULL,
  about                   VARCHAR      NOT NULL,
  offered               VARCHAR      NOT NULL,
  banner                VARCHAR      NOT NULL,
  rating                  FLOAT      NOT NULL,
  price                   FLOAT      NOT NULL,
  modules                 INT      NOT NULL,
  cpd                     INT      NOT NULL,
  duration                INT      NOT NULL
);
