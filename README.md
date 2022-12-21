<h1>Gerador de Propostas</h1>

<p>Uma aplicação web que gerará propostas comerciais.</p>
<p>Decidi chamar os serviços prestados pelo escritório de atuações, para não confundir a palavra serviço com algo atrelado à API.</p>
<p>Todos os testes foram realizados com o Isomnia</p>.

<p>Passos implementados: </p>
<ul>
  <li>Criação do projeto com spring initializer;</li>
  <li>Criação do banco de dados MY SQL, respectivas tabelas e configurações inicias no projeto;</li>
  <li>Criação da organização Controller > DTO > Model de entrada/saída > Service > Entity > Repository;</li>
  <li>Criação do CRUD referente às atuações. Cadastro(POST), consulta(GET), atualização(PATCH/PUT) e (DELETE)inativação das atuações;</li>
  <li>Criação do cadastro(PUT) de proposta, com mapeamento many to many da relação atuações e propostas.</li>
</ul>
  
<p>O próximo passo será: </p>
<ul>
  <li>Criação da consulta de propostas (GET);</li>
  <li>Criação de arquivo PDF, já que o objetivo é retonar o arquivo para o front.</li>
