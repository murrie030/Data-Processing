-- 1. Hoofdstuk 4 opgave 6
SELECT mnr
,      functie
,      gbdatum
FROM medewerkers
WHERE gbdatum < TO_DATE('01-01-1960') AND functie = 'TRAINER' OR functie = 'VERKOPER';

-- 1. Hoofdstuk 4 opgave 9
SELECT naam, voorl 
FROM medewerkers 
WHERE naam like '_%';

-- 2. Hoofdstuk 8 opgave 5
SELECT u.code 
,      u.begindatum
,      COUNT() as aantalinschrijvingen
FROM uitvoeringen u
LEFT OUTER JOIN inschrijvingen i
ON (u.cursus = i.cursus AND u.begindatum = i.begindatum)
WHERE EXTRACT(year FROM i.begindatum) = 1999
GROUP BY u.cursus, u.begindatum
HAVING COUNT() >= 3;

-- 2. Hoofdstuk 8 opgave 7
SELECT * FROM medewerkers m 
WHERE 1 < (SELECT COUNT(i.cursus) 
                FROM inschrijvingen i
                WHERE m.mnr = i.cursist
                AND i.cursus = 'S02'
                GROUP BY i.cursus
            );
            
-- Opgave 3
SELECT cursus, COUNT(cursus) 
FROM uitvoeringen
GROUP BY cursus;

-- Opgave 4
SELECT ROUND(MONTHS_BETWEEN(MAX(gbdatum), MIN(gbdatum)) / 12) AS jaren
FROM medewerkers;

SELECT TO_DATE(AVG(TO_NUMBER(TO_CHAR(gbdatum, 'J'))), 'J') AS gemiddelde
FROM medewerkers;

-- Opgave 5
SELECT COUNT(m.mnr) AS aantal_medewerkers
,      AVG(COALESCE(m.comm, 0)) AS avg_comm
,      AVG(CASE
           WHEN m.functie = 'VERKOPER' 
           THEN COALESCE(m.comm, 0) 
           ELSE NULL END) AS avg_per_verkoper_comm
FROM medewerkers m;