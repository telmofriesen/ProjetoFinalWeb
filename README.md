ProjetoFinalWeb
===============

Criar uma aplicação em JSF, com acesso a banco de dados via JPA 2.0 e consultas usando a API de critérios. A aplicação em um recurso para apreciadores de música onde um usuário qualquer pode consultar e/ou cadastrar artistas, álbuns e faixas.
Existem dois perfis de usuários: administrador e colaborador. O administrador pode realizar qualquer modificação em qualquer registro, enquanto o colaborador somente poderá alterar os registros criados por ele.

A aplicação deve prever o cadastro de usuários. Um usuário será autenticado pelo e-mail e senha. 

Implementar a autenticação usando os mecanismos de segurança de aplicação da tecnologia de servlets. Usar autenticação por formulário (FORM).

Qualquer usuário, mesmo sem autenticação, poderá pesquisar artistas, álbuns ou faixas. A aplicação deve prever estas consultas através de uma busca textual, por exemplo, do tipo “like”.

Qualquer usuário poderá criar o seu próprio cadastro, informando nome, e-mail e senha. Aos usuários será atribuído o perfil de colaborador. Inicialmente, existirá um usuário administrador no banco de dados. Este administrador poderá alterar o perfil de qualquer usuário, atribuindo ou removendo o perfil de administrador e demais dados de qualquer usuário. Os administradores poderão também excluir e cadastrar usuários.

Os colaboradores poderão cadastrar artistas, álbuns e faixas porém somente poderão modificar, inclusive excluir, as informações cadastradas por eles próprios.

Ao exibir os resultados das consultas, mostrar todas as informações e o número de estrelas, de acordo com a média aritmética calculada.

Quando o usuário consultar artistas, implementar o recurso de que ao clicar sobre o nome do artista sejam listados os álbuns e quando clicar sobre o álbum, listar as faixas.

Na avaliação do trabalho serão considerados os aspectos estéticos, o uso de componentes adequados em cada situação, o uso correto de CSS, o uso de validadores, conversores, mensagens de erro, a organização dos códigos fonte, o uso adequado de beans e o controle adequado de sessões. Em geral, será considerado o uso adequado da tecnologia de Servlets e JSF.
O trabalho poderá ser desenvolvido em grupos de até 3 alunos e deverá ser apresentado no dia 9/10/2013 em sala de aula.