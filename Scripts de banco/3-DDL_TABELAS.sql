--TABELA PERFIL
CREATE TABLE "PERFIL"
(
  codigo integer NOT NULL DEFAULT nextval('seq_codigo_perfil'::regclass),
  descricao text,
  CONSTRAINT pk_perfil PRIMARY KEY (codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "PERFIL"
  OWNER TO admin;
COMMENT ON TABLE "PERFIL"
  IS 'Tabela com os perfis de usuarios';

--TABELA USUARIO 
 CREATE TABLE "USUARIO"
(
  codigo integer NOT NULL,
  codigo_perfil integer,
  nome text,
  email text,
  senha text,
  CONSTRAINT pk_usuario PRIMARY KEY (codigo),
  CONSTRAINT fk_usuario_perfil FOREIGN KEY (codigo_perfil)
      REFERENCES "PERFIL" (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
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
