DROP TABLE IF EXISTS ACCOUNTS CASCADE;
CREATE TABLE ACCOUNTS (
	username varchar(30) PRIMARY KEY,
	password varchar(50) NOT NULL --turns out password isnt a reserved word, looks like it though
	firstName varchar(50),
	lastName varchar(50),
	address varchar(200),
	profilePicture blob,
	accountType varchar(20) DEFAULT 'employee',
);
DROP TABLE IF EXISTS TICKETS CASCADE;
CREATE TABLE TICKETS (
	ticketID serial PRIMARY KEY,
	ticketName varchar(40),
	ticketType varchar(40) DEFAULT 'General',
	ticketDescription varchar(10000) NOT NULL,
	amount numeric NOT NULL,
	status varchar(50) DEFAULT 'Pending',
	supportingImage blob,
	submitterUser varchar(30),
	FOREIGN KEY(submitterUser) REFERENCES ACCOUNTS(username)
	ON DELETE CASCADE
);

/*
--Testing purposes 
INSERT INTO ACCOUNTS(firstName, lastName, username, passcode) VALUES ('this', 'is', 'a', 'test');
INSERT INTO ACCOUNTS(firstName, lastName, username, passcode) VALUES ('this', 'also', 'is', 'test');
SELECT * FROM ACCOUNTS;
DELETE FROM ACCOUNTS WHERE lastName = 'also';
SELECT * FROM ACCOUNTS;
INSERT INTO TICKETS(ticketDescription, amount, submitterid) SELECT 'send help!', 0, username FROM ACCOUNTS WHERE lastName = 'is'; 
SELECT * FROM TICKETS;
*/