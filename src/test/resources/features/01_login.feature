@login
Feature: Login
  Eu como usuario que possuo cadastro no site QAzando shop
  Quero realizar o login no site
  Para poder ter acesso completo ao site

  Background: Acessar página de login do sistema
    Given que esteja na página de login do sistema

  Scenario Outline: Login correto: <cenario>
    When preencher o usuário "<usuario>" e a senha "<senha>"
    And clicar em login
    Then deve aparecer uma mensagem de boas vindas para o usuário "<usuario>"
    And "<usuario>" deve ser direcionado para a tela inicial do usuário

    Examples:
      | usuario           | senha      | cenario                                          |
      | cristhofer@qa.com | enha | Senha apenas com letras                          |
      | cristhofer@qa.com | 19878 | Senha apenas com números                         |
      | cristhofer@qa.com | Teste001#@ | Senha com letras, números e caracteres especiais |

  Scenario Outline: Login incorreto: <cenario>
    When preencher o usuário "<usuario>" e a senha "<senha>"
    And clicar em login
    Then deve aparecer a mensagem de "<mensagem>" e login não deverá ser realizado

    Examples:
      | usuario           | senha      | mensagem         | cenario          |
      | Cristhofer        | testeSenha | E-mail inválido. | e-mail incorreto |
      |                   | 1234569878 | E-mail inválido. | e-mail vazio     |
      | cristhofer@qa.com |      0154A | Senha inválida.  | senha incorreta  |
      | cristhofer@qa.com |            | Senha inválida.  | senha vazia      |
