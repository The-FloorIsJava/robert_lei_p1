DROP TABLE IF EXISTS accounts CASCADE;
CREATE TABLE accounts (
	username varchar(30) PRIMARY KEY,
	passcode varchar(50) NOT NULL, --turns out password isnt a reserved word, looks like it though
	first_name varchar(50),
	last_name varchar(50),
	address varchar(200),
	profile_picture bytea,
	account_type varchar(20) DEFAULT 'employee'
);
DROP TABLE IF EXISTS tickets CASCADE;
CREATE TABLE tickets (
	ticket_id serial PRIMARY KEY,
	ticket_name varchar(40),
	ticket_type varchar(40) DEFAULT 'General',
	ticket_description varchar(10000) NOT NULL,
	amount numeric NOT NULL,
	status varchar(50) DEFAULT 'pending',
	supporting_image bytea,
	submitter_user varchar(30),
	FOREIGN KEY(submitter_user) REFERENCES accounts(username)
	ON DELETE CASCADE
);


--Testing purposes 
INSERT INTO ACCOUNTS(first_name, last_name, username, passcode) VALUES ('this', 'is', 'a', 'test');
INSERT INTO ACCOUNTS(first_name, last_name, username, passcode) VALUES ('this', 'also', 'is', 'test');
SELECT * FROM ACCOUNTS;
DELETE FROM ACCOUNTS WHERE last_name = 'also';
SELECT * FROM ACCOUNTS;
INSERT INTO TICKETS(ticket_description, amount, submitter_user) SELECT 'send help!', 0, username FROM ACCOUNTS WHERE last_name = 'is'; 
SELECT * FROM TICKETS;

