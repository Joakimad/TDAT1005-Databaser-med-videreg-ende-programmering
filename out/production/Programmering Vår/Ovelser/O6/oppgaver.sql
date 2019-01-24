--1 a) Seleksjon
SELECT * FROM O6_bok WHERE utgitt_aar<1990;

--Projeksjon
SELECT DISTINCT tittel,utgitt_aar FROM O6_bok;

--1 b) Produkt
SELECT * FROM O6_bok,O6_forlag;

--1 c) Equi Join
SELECT * FROM O6_bok
JOIN O6_forlag ON O6_bok.forlag_id=O6_forlag.forlag_id
ORDER BY bok_id;

-- Naturlig forening
SELECT * FROM O6_bok
NATURAL JOIN O6_forlag ON O6_bok.forlag_id=O6_forlag.forlag_id

/**
1 d)

Unionkompatible eksempler:
bok_tittel U forlag_navn
bok_id U forlag_id
bok_id, titel u forlag_id, forlag_navn

For å være unionkompatible må relasjonene ha det samme antallet attributter,
og at attributtene må være definert på samme domene (ha samme datatype).

Unionkompatibiliet er påkrevd av UNION, DIFFERENCE, INTERSECT
**/

--UNION. Gir en liste av alle forekomster uten duplikater
SELECT tittel FROM O6_bok
UNION
SELECT forlag_navn FROM O6_forlag;

--INTERSECT, ikke støttet i SQL. Gir en liste av elementer som forekommer i begge listene.
SELECT DISTINCT bok_id FROM O6_bok
JOIN O6_forlag ON O6_bok.bok_id = O6_forlag.forlag_id
ORDER BY bok_id;

--DIFFERENCE, Finner elementer som er i den første, men ikke i den andre av to lister.
SELECT bok_id FROM O6_bok
LEFT JOIN O6_forlag ON O6_bok.bok_id = O6_forlag.forlag_id
WHERE O6_forlag.forlag_id IS NULL;

--2 a) Navn på alle forlagene. Bruker DISTINCT.
SELECT DISTINCT forlag_navn FROM O6_forlag;

--2 b) Forlag uten bøker. Bruker DIFFERENCE
SELECT DISTINCT O6_forlag.forlag_id,forlag_navn FROM O6_forlag
LEFT JOIN O6_bok ON O6_bok.forlag_id = O6_forlag.forlag_id
WHERE O6_bok.forlag_id IS NULL;

--2 c) Forfatter født i 1948. Bruker bare seleksjon
SELECT fornavn,etternavn FROM O6_forfatter WHERE fode_aar = 1948;

--2 d) Navn og adresse på forlaget bak 'Generation X'. Bruker Inner join og seleksjon
SELECT forlag_navn, adresse FROM O6_forlag
JOIN O6_bok ON O6_bok.forlag_id = O6_forlag.forlag_id
WHERE  tittel = 'Generation X';

--2 e) Bøker av Hamsun. Brukte INNER JOIN og seleksjon
SELECT O6_bok.tittel,etternavn FROM O6_forfatter
JOIN O6_bok_forfatter ON O6_forfatter.forfatter_id = O6_bok_forfatter.forfatter_id
JOIN O6_bok ON O6_bok.bok_id = O6_bok_forfatter.bok_id
WHERE etternavn = 'Hamsun';

--2 f) Bokinfo + forlag. Vi bruker RIGHT JOIN for å sørge for at ønsket data er med selv om noen av felter er null
SELECT tittel,utgitt_aar,forlag_navn,adresse,telefon FROM O6_bok
RIGHT JOIN O6_forlag ON O6_bok.forlag_id = O6_forlag.forlag_id
ORDER BY forlag_navn,tittel;

