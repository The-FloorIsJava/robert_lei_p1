DROP TABLE IF EXISTS ACCOUNTS CASCADE;
CREATE TABLE ACCOUNTS (
	userID serial PRIMARY KEY,
	firstName varchar(50),
	lastName varchar(50),
	accountType varchar(20) DEFAULT 'employee',
	username varchar(20),
	passcode varchar(50) --password reserved
);
DROP TABLE IF EXISTS TICKETS CASCADE;
CREATE TABLE TICKETS (
	ticketID serial PRIMARY KEY,
	ticketName varchar(40),
	ticketType varchar(40) DEFAULT 'General',
	ticketDescription varchar(10000),
	submitterID int,
	FOREIGN KEY(submitterID) REFERENCES ACCOUNTS(userID)
	ON DELETE CASCADE
);

/*
--Testing purposes 
INSERT INTO ACCOUNTS(firstName, lastName, username, passcode) VALUES ('this', 'is', 'a', 'test');
INSERT INTO ACCOUNTS(firstName, lastName, username, passcode) VALUES ('this', 'also', 'is', 'test');
SELECT * FROM ACCOUNTS;
DELETE FROM ACCOUNTS WHERE lastName = 'also';
SELECT * FROM ACCOUNTS;
INSERT INTO TICKETS(ticketName, submitterid) SELECT 'send help!', userid FROM ACCOUNTS WHERE lastName = 'is'; 
SELECT * FROM TICKETS;
*/