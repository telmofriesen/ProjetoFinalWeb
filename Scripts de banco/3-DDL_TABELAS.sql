--TABELA USUARIO 
--DROP TABLE "usuario";
--DROP TABLE "USUARIO";
CREATE TABLE usuario
(
  codigo integer NOT NULL DEFAULT nextval('seq_codigo_usuario'::regclass),
  nome text,
  email text NOT NULL,
  senha text,
  CONSTRAINT usuario_pkey PRIMARY KEY (codigo ),
  CONSTRAINT usuario_email_key UNIQUE (email )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO admin;
COMMENT ON TABLE usuario
  IS 'Tabela com os registros dos usuários';

--TABELA PERFIL
--DROP TABLE "PERFIL";
--DROP TABLE "perfil";
CREATE TABLE perfil
(
  papel text NOT NULL,
  email text NOT NULL,
  CONSTRAINT perfil_pkey PRIMARY KEY (papel , email ),
  CONSTRAINT perfil_email_usuario_fkey FOREIGN KEY (email)
      REFERENCES usuario (email) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE perfil
  OWNER TO admin;
COMMENT ON TABLE perfil
  IS 'Tabela com os perfis de usuarios';

--TABELA ARTISTA
--DROP TABLE "ARTISTA";
--DROP TABLE "artista";
CREATE TABLE artista
(
  codigo integer NOT NULL DEFAULT nextval('seq_codigo_artista'::regclass),
  nome text,
  codigo_usuario integer NOT NULL,
  CONSTRAINT pk_artista PRIMARY KEY (codigo ),
  CONSTRAINT artista_codigo_usuario_fkey FOREIGN KEY (codigo_usuario)
      REFERENCES usuario (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE artista
  OWNER TO admin;
COMMENT ON TABLE artista
  IS 'Tabela com os artistas';

--TABELA ALBUM
--DROP TABLE "ALBUM";
--DROP TABLE "album";
CREATE TABLE album
(
  codigo integer NOT NULL DEFAULT nextval('seq_codigo_album'::regclass),
  titulo text,
  codigo_artista integer,
  codigo_usuario integer NOT NULL,
  CONSTRAINT pk_album PRIMARY KEY (codigo ),
  CONSTRAINT album_codigo_usuario_fkey FOREIGN KEY (codigo_usuario)
      REFERENCES usuario (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_album_artista FOREIGN KEY (codigo_artista)
      REFERENCES artista (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE album
  OWNER TO admin;
COMMENT ON TABLE album
  IS 'Tabela com os albuns dos artistas';

--TABELA FAIXA
--DROP TABLE "FAIXA";
--DROP TABLE "faixa";
CREATE TABLE faixa
(
  codigo integer NOT NULL,
  numero integer,
  titulo text,
  duracao integer,
  codigo_album integer,
  codigo_usuario integer NOT NULL,
  CONSTRAINT fk_faixa PRIMARY KEY (codigo ),
  CONSTRAINT faixa_codigo_usuario_fkey FOREIGN KEY (codigo_usuario)
      REFERENCES usuario (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_faixa_album FOREIGN KEY (codigo_album)
      REFERENCES album (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE faixa
  OWNER TO admin;
COMMENT ON TABLE faixa
  IS 'Tabela com as faixas dos álbuns';
