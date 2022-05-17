drop table if exists request_count cascade;
drop sequence if exists request_count_id_seq cascade;

create sequence request_count_id_seq start 1 increment 1;

CREATE TABLE request_count
(
    request_count_id integer PRIMARY KEY DEFAULT nextval('request_count_id_seq'),
    login            varchar NOT NULL,
    request_count    numeric NOT NULL
);