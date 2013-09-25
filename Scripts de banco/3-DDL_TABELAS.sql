--TABELA PERFIL
DROP TABLE "PERFIL";
CREATE TABLE "PERFIL"
(
  papel text NOT NULL,
  email text NOT NULL,
  CONSTRAINT "PERFIL_pkey" PRIMARY KEY (papel , email ),
  CONSTRAINT "PERFIL_email_fkey" FOREIGN KEY (email)
      REFERENCES "USUARIO" (email) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "PERFIL"
  OWNER TO admin;
COMMENT ON TABLE "PERFIL"
  IS 'Tabela com os perfis de usuarios';

--TABELA USUARIO 
DROP TABLE "USUARIO";
CREATE TABLE "USUARIO"
(
  nome text,
  email text NOT NULL,
  senha text,
  CONSTRAINT "USUARIO_pkey" PRIMARY KEY (email )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "USUARIO"
  OWNER TO admin;
COMMENT ON TABLE "USUARIO"
  IS 'Tabela com os registros dos usuários';

--TABELA ARTISTA
CREATE TABLE "ARTISTA"
(
  codigo integer NOT NULL DEFAULT nextval('seq_codigo_artista'::regclass),
  nome text,
  CONSTRAINT pk_artista PRIMARY KEY (codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "ARTISTA"
  OWNER TO admin;
COMMENT ON TABLE "ARTISTA"
  IS 'Tabela com os artistas';

 --TABELA ALBUM
CREATE TABLE "ALBUM"
(
  codigo integer NOT NULL DEFAULT nextval('seq_codigo_album'::regclass),
  titulo text,
  codigo_artista integer,
  CONSTRAINT pk_album PRIMARY KEY (codigo),
  CONSTRAINT fk_album_artista FOREIGN KEY (codigo_artista)
      REFERENCES "ARTISTA" (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "ALBUM"
  OWNER TO admin;
COMMENT ON TABLE "ALBUM"
  IS 'Tabela com os albuns dos artistas';

--TABELA FAIXA
CREATE TABLE "FAIXA"
(
  codigo integer NOT NULL,
  numero integer,
  titulo text,
  duracao integer,
  codigo_album integer,
  CONSTRAINT fk_faixa PRIMARY KEY (codigo),
  CONSTRAINT fk_faixa_album FOREIGN KEY (codigo_album)
      REFERENCES "ALBUM" (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "FAIXA"
  OWNER TO admin;
COMMENT ON TABLE "FAIXA"
  IS 'Tabela com as faixas dos álbuns';
