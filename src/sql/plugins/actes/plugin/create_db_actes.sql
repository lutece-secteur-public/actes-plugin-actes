
--
-- Table structure for table actes_nature
--

CREATE TABLE actes_nature (
  id_nature INT NOT NULL,
  code VARCHAR(10) DEFAULT NULL,
  name VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY  (id_nature)
);


--
-- Table structure for table actes_matieres
--

CREATE TABLE actes_matieres (
  code_matiere VARCHAR(10) DEFAULT NULL,
  libelle_matiere VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (code_matiere)
);

--
-- Table structure for table actes_transaction
--

CREATE TABLE actes_transaction (
  id_transaction INT NOT NULL,
  code_transaction VARCHAR(50) DEFAULT NULL,
  nature VARCHAR(50) DEFAULT NULL,
  classification VARCHAR(255) DEFAULT NULL,
  date_decision VARCHAR(50) DEFAULT NULL,
  numero_interne VARCHAR(50) DEFAULT NULL,
  objet LONG VARCHAR DEFAULT NULL,
  status INT DEFAULT NULL,
  PRIMARY KEY (id_transaction)
);