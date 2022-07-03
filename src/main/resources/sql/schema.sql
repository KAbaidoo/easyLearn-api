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

CREATE TABLE IF NOT EXISTS activities (
  id                     VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
  course_id              VARCHAR      NOT NULL,
  module_id              VARCHAR      NOT NULL,
  learner_id             VARCHAR      NOT NULL,
  module_type            VARCHAR      NOT NULL,
  activity_date          DATE         NOT NULL,
  activity_start         TIME         NOT NULL,
  activity_end           TIME         NOT NULL,
  completed              BIT          NOT NULL,
  score                  FLOAT        NOT NULL
);