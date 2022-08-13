-- CREATE SEQUENCE IF NOT EXISTS user_accounts_seq;

-- CREATE TABLE IF NOT EXISTS user_accounts (
-- 	user_id BIGINT NOT NULL DEFAULT nextval('user_accounts_seq') PRIMARY KEY,
-- 	username varchar(255) NOT NULL,
-- 	email varchar(255) NOT NULL,
-- 	password varchar(255) NOT NULL,
-- 	role varchar(255),
-- 	enabled boolean NOT NULL
-- );



-- if just insert these two accounts, their passwords are not encrypted and hence will cause error when log in 
-- (since the encrypter will try to decrypt them)

-- INSERT INTO user_accounts (username, email, password, role, enabled)
-- VALUES ('admin', 'admin@gmail.com', 'admin', 'ADMIN', True);

-- INSERT INTO user_accounts (username, email, password, role, enabled)
-- VALUES ('nonadmin', 'nonadmin@gmail.com', 'nonadmin', Null, True);

-- DELETE FROM user_accounts
-- WHERE username='nonadmin';

select * from user_accounts;

UPDATE user_accounts
SET role='ADMIN'
WHERE username='admin';