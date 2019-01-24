DROP TABLE borettslag;
DROP TABLE bygg;
DROP TABLE medlem;
DROP TABLE leilighet;

CREATE TABLE borettslag (
  navn varchar(255) NOT NULL,
  adr varchar(255) NOT NULL,
  antBygg int(11) NOT NULL,
  etablert year(4) NOT NULL,
  PRIMARY KEY (navn)
);

CREATE TABLE bygg (
  adr varchar(255) NOT NULL,
  borettslag varchar(255) NOT NULL,
  antLeiligheter int(11) NOT NULL,
  antEtasjer int(11) NOT NULL,
  PRIMARY KEY (adr),
  FOREIGN KEY (borettslag) REFERENCES borettslag(navn) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE medlem (
  id_medlem int(11) NOT NULL AUTO_INCREMENT,
  navn varchar(255) NOT NULL,
  borettslag varchar(255) NOT NULL,
  PRIMARY KEY (id_medlem),
  FOREIGN KEY(borettslag) REFERENCES borettslag(navn) ON UPDATE CASCADE
  );

CREATE TABLE leilighet (
  leilighetsNr int(11) NOT NULL,
  eier int(11) NULL,
  bygg varchar(255) NOT NULL,
  etg int(11) NOT NULL,
  antRom int(11) NOT NULL,
  m2 int(11) NOT NULL,
  PRIMARY KEY (leilighetsNr, bygg),
  FOREIGN KEY (eier) REFERENCES medlem(id_medlem) ON UPDATE CASCADE,
  FOREIGN KEY (bygg) REFERENCES bygg(adr) ON UPDATE CASCADE ON DELETE CASCADE
  );

-- Legger inn eksempel data
INSERT INTO borettslag (navn,adr,antbygg,etablert) VALUES ("Blokksberg","Blokkberg 7",3,2002);
INSERT INTO borettslag (navn,adr,antbygg,etablert) VALUES ("Sollia","Sollia 6",3,2008);
INSERT INTO medlem (navn, borettslag) VALUES ('Joakim', 'Sollia');
INSERT INTO medlem (navn, borettslag) VALUES ('Magnus', 'Sollia');
INSERT INTO medlem (navn, borettslag) VALUES ('Jon', 'Blokksberg');
INSERT INTO medlem (navn, borettslag) VALUES ('Joakim', 'Blokksberg');
INSERT INTO bygg (adr,borettslag,antLeiligheter,antEtasjer) VALUES ("Sollia 6a","Sollia",3,2);
INSERT INTO bygg (adr,borettslag,antLeiligheter,antEtasjer) VALUES ("Sollia 6b","Sollia",3,2);
INSERT INTO bygg (adr,borettslag,antLeiligheter,antEtasjer) VALUES ("Blokksberg 7a","Blokksberg",10,1);
INSERT INTO leilighet (leilighetsNr,eier,bygg,etg,antRom,m2) VALUES (201,5,"Sollia 6b",2,3,25);
INSERT INTO leilighet (leilighetsNr,eier,bygg,etg,antRom,m2) VALUES (101,2,"Sollia 6a",2,3,25);
INSERT INTO leilighet (leilighetsNr,eier,bygg,etg,antRom,m2) VALUES (201,3,"Blokksberg 7a",2,2,15);
INSERT INTO leilighet (leilighetsNr,eier,bygg,etg,antRom,m2) VALUES (103,4,"Blokksberg 7a",1,2,15);

-- Brudd på entitets- og referanseintegritetsreglene.
INSERT INTO borettslag (navn,adr,antbygg,etablert) VALUES ("Sollia","Sollia 3",3,2008);
INSERT INTO leilighet (leilighetsNr,eier,bygg,etg,antRom,m2) VALUES (001,"Thomas","Under bruen",1,1,5);