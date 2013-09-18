CREATE ROLE admin LOGIN ENCRYPTED PASSWORD 'md5f6fdffe48c908deb0f4c3bd36c032e72'
   VALID UNTIL 'infinity';
COMMENT ON ROLE admin
  IS 'Administrador do banco';
  
CREATE DATABASE musicmate
  WITH ENCODING='UTF8'
       CONNECTION LIMIT=-1;

COMMENT ON DATABASE musicmate
  IS 'Base de dados da aplicação web Music Mate';

ALTER DATABASE musicmate
  OWNER TO admin;