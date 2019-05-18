-- opdracht 1 
CREATE TABLE medewerker_kopie AS SELECT * FROM medewerkers;

ALTER TABLE medewerkers_kopie ADD geslacht VARCHAR(2);

ALTER TABLE medewerkers_kopie ADD CONSTRAINT geslacht_check CHECK(geslacht in ('M', 'V'));

-- opdracht 2
CREATE SEQUENCE afd_nr START WITH 20 INCREMENT BY 10;

INSERT INTO afdelingen(ANR, NAAM, LOCATIE, HOOFD) VALUES(afd_nr.NEXTVAL, 'MUSTAFA', 'UTRECHT', 3564);
INSERT INTO afdelingen(ANR, NAAM, LOCATIE, HOOFD) VALUES(afd_nr.NEXTVAL, 'ISMAIL', 'UTRECHT', 3564);
INSERT INTO afdelingen(ANR, NAAM, LOCATIE, HOOFD) VALUES(afd_nr.NEXTVAL, 'TEST', 'UTRECHT', 3564);
INSERT INTO afdelingen(ANR, NAAM, LOCATIE, HOOFD) VALUES(afd_nr.NEXTVAL, 'TEST', 'UTRECHT', 3564);

-- opdracht 3
CREATE TABLE historische_adressen(
    POSTCODE VARCHAR(6) CONSTRAINT geldig_postcode check(POSTCODE LIKE '[0-9]{4}[A-Z]{2}'),
    HUISNUMMER INT,
    INGANGSDATUM DATE not null,
    EINDDATUM DATE CONSTRAINT validatie check(EINDDATUM >= INGANGSDATUM),
    TELEFOON CHAR(10) unique,
    MED_MNR INT not null,
    PRIMARY KEY(POSTCODE, HUISNUMMER, INGANGSDATUM),
    FOREIGN KEY(MED_MNR) REFERENCES medwerkers(mnr)
);