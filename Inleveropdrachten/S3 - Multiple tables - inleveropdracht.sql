-- Hoofdstuk 8 opgave 1
SELECT c.code
,      c.lengte
,      u.begindatum
,      m.naam
FROM cursussen c, uitvoeringen u, medewerkers m
WHERE c.code = u.cursus AND m.mnr = u.docent;

-- Hoofdstuk 8 opgave 2
SELECT s.naam student, m.naam docent 
FROM medewerkers m JOIN uitvoeringen u 
ON (u.docent = m.mnr) JOIN inschrijvingen i 
USING (cursus, begindatum) JOIN medewerkers s ON (i.cursist = s.mnr) WHERE cursus = 'S02';

-- Opgave 2
SELECT m.naam
FROM afdelingen a, medewerkers m
WHERE m.mnr = a.hoofd;

-- Opgave 3
SELECT m.naam
,      m.afd
,      a.locatie
FROM medewerkers m, afdelingen a
WHERE m.afd = a.anr;

-- Opgave 4
SELECT m.naam 
FROM medewerkers m, inschrijvingen i
WHERE i.cursist = m.mnr AND i.cursus = 'S02' AND i.begindatum = '12-04-99';

-- Opgave 5
SELECT m.naam as medewerker
,      m.maandsal + s.toelage as jaarlijksetoelage
FROM medewerkers m, schalen s 
WHERE m.maandsal BETWEEN s.ondergrens AND s.bovengrens;