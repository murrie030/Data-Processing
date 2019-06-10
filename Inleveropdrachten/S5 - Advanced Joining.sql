-- Hoofdstuk 4 opgave 4
SELECT * FROM medewerkers m
WHERE EXISTS (SELECT cursist
              FROM inschrijvingen i
              WHERE m.mnr = i.cursist
              AND i.cursus = 'JAV')
AND EXISTS (SELECT cursist 
            FROM inschrijvingen i
            WHERE m.mnr = i.cursist
            AND i.cursus = 'XML');

-- Hoofdstuk 4 opgave 7
SELECT * FROM medewerkers
WHERE afd <> 20; -- Hier kon je ook != gebruiken

-- Hoofdstuk 4 opgave 8
SELECT m.mnr
,      m.naam
,      m.voorl
FROM medewerkers m
WHERE NOT EXISTS (SELECT * FROM inschrijvingen i
                  WHERE m.mnr = i.cursist
                  AND i.cursus = 'JAV');
                  
-- Hoofdstuk 4 opgave 10 (wel ondergeschikten)
SELECT * FROM medewerkers m
WHERE EXISTS (SELECT * FROM medewerkers m2
              WHERE m2.chef = m.mnr);

-- Hoofdstuk 4 opgave 11 (geen ondergeschikten)
SELECT * FROM medewerkers m
WHERE NOT EXISTS (SELECT * FROM medewerkers m2
              WHERE m2.chef = m.mnr);

-- Hoofdstuk 8 opgave 4
SELECT u.cursus
,      u.begindatum
,      COUNT(*) AS aantal_inschrijvingen
FROM uitvoeringen u
JOIN inschrijvingen i ON (u.cursus = i.cursus
                          AND i.begindatum = u.begindatum)
GROUP BY u.cursus, u.begindatum
ORDER BY u.begindatum;

-- Hoofdstuk 8 opgave 9
SELECT m.naam, m.voorl FROM medewerkers m
WHERE EXISTS (
    SELECT * FROM inschrijvingen i
    JOIN uitvoeringen u ON (u.begindatum = i.begindatum AND i.cursus = u.cursus)
    JOIN cursussen c ON (c.code = u.cursus)
    WHERE c.type = 'ALG'
    AND i.cursist = m.mnr
    AND u.docent = m.chef);

-- Hoofdstuk 9 opgave 3
SELECT * FROM medewerkers m
WHERE NOT EXISTS (SELECT * FROM uitvoeringen u
                  WHERE u.docent = m.mnr);
