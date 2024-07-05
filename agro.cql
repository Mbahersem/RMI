CREATE KEYSPACE user WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE user.user_by_mail (
	userMail text,
	userId uuid,
	PRIMARY KEY ((userMail), userId)
) WITH comment = 'Q1. Chercher un utilisateur par son mail' 
AND CLUSTERING ORDER BY (userId ASC);

CREATE TABLE user.user (
	userId uuid,
	userMail text,
	userName text,
	userPassword text,
	PRIMARY KEY (userId)
) WITH comment = 'Q2. Afficher un utilisateur'; 


CREATE KEYSPACE device WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE device.devices_by_user (
	userId uuid,
	deviceName text,
	deviceId uuid,
	PRIMARY KEY ((userId), deviceName)
) WITH comment = 'Q3. Afficher les devices créés par un utilisateur' 
AND CLUSTERING ORDER BY (deviceName ASC);

CREATE TABLE device.device_by_name (
	deviceName text,
	userId uuid,
	deviceId uuid,
	PRIMARY KEY ((deviceName), userId)
) WITH comment = 'Q4.Name Chercher un device par son nom'; 

CREATE TABLE device.device (
	deviceId uuid,
	deviceName text,
	typeMcu text,
	api text,
	support text,
	PRIMARY KEY (deviceId)
) WITH comment = 'Q5. Afficher un device';


 CREATE KEYSPACE query WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE query.device_data_by_date (
	deviceId uuid,
	date timestamp,
	n int,
	p int,
	k int,
	ph int,
	h int,
	t int,
	soilType text,
	PRIMARY KEY ((deviceId), date)
) WITH comment = 'Q6. Afficher les données d'un device suivant une date';

 CREATE KEYSPACE ingestion WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE ingestion.data_by_token (
	api text,
	deviceId uuid,
	date timestamp DEFAULT toTimestamp(now()),
	n text,
	p text,
	k text,
	ph text,
	h text,
	t text,
	soilType text,
	PRIMARY KEY ((token), deviceId)
) WITH comment = 'Q7. Chercher un device par son token';
	
	

