CREATE TABLE IF NOT EXISTS bank_account
(
    id        bigserial primary key,
    number    bigint not null unique,
    balance   decimal(12, 2)
);