# dsw1

# DSW-T1
Trabalho 1 da disciplina de Desenvolvimento de Software para WEB da UFSCar, ministrada pelo Professor Delano Beder.


--------------

<b> Requisitos do Projeto </b>

Sistema para criação de promoções em sites de venda de ingressos

O sistema deve possuir um cadastro de sites de venda de ingressos, com os seguintes dados: e- mail, senha, endereço/URL, nome e telefone.
O sistema deve possuir um cadastro de salas de teatro, com os seguintes dados: e-mail, senha, CNPJ, nome e cidade.
O sistema deve possuir um cadastro de promoções, com os seguintes dados: endereço/URL do site de venda de ingressos, CNPJ do teatro, nome da peça, preço e dia/horário.
O sistema deve atender aos seguintes requisitos:

<b> CRUDS </b>
R1: CRUD de sites de venda de ingressos (requer login de administrador) 
R2: CRUD de teatros (requer login de administrador)

<b> Listagens </b>
R3: Listagem de todos os teatros em uma única página (não requer login) 
R4: Listagem de todos os teatros por cidade (não requer login)

<b> Cadastrar </b>
R5: Criação de uma promoção de um teatro (requer login do teatro: via e-mail + senha). Depois de fazer login, o teatro pode cadastrar uma promoção. Para isso, deve escolher o site de venda de ingressos (escolhendo a partir de uma lista), o nome da peça, o preço, e o dia/horário da sessão, e deve ser gravada a promoção na base de dados.
R6: O sistema não deve permitir o cadastro de promoções de um mesmo teatro ou de um mesmo site de venda de ingressos em um mesmo dia/horário.

<b> Listas de Promoções </b>
R7: Listagem de todas as promoções de um teatro (requer login do teatro via e-mail + senha). Depois de fazer login, o teatro pode visualizar todas as suas promoções gravadas. 
R8: Listagem de todas as promoções de um site de venda de ingressos (requer login do site: via e-mail + senha). Depois de fazer login, o site de vendas de ingressos pode visualizar todas as suas promoções gravadas.

<b> Internacionalização </b>
R9: O sistema deve ser internacionalizado em pelo menos dois idiomas: português + outro de sua escolha.
O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemas técnicos, etc) mostrando uma página de erros amigável ao usuário e registrando o erro no console, em arquivo ou na base de dados.
  
 <h1> Requisitos Desenvolvidos </h1>
 
 R1, R2, R3, R4, R5, R6, R7
 
 ----- 
 
  
