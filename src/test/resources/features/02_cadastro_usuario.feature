@cadastro_usuario
Feature: Cadastro de usuário
  Eu como um futuro usuário do site QAzando shop
  Quero realizar o cadastro no site
  Para poder ter acesso completo ao site

  Background: Acessar tela de cadastro de usuários
    Given que esteja na tela de cadastro de usuários

  Scenario: Cadastro de usuário com sucesso
    When eu preencho o nome, email e senha com valores válidos
    And clico em cadastrar
    Then vejo a mensagem de cadastro com sucesso

  Scenario Outline: Cadastro incorreto de usuário: <cenario>
    When eu preencho o nome "<nome>", email "<email>" e senha "<senha>"
    And clico em cadastrar
    Then vejo a mensagem "<mensagem>"

    Examples:
      | nome                       | email                     | senha   | mensagem                                       | cenario                                   |
      |                            | teste_sem_nome@teste.com  | Teste1@ | O campo nome deve ser prenchido                | Cadastro sem nome                         |
      | Usuario Sem Email          |                           | ABC25@t | O campo e-mail deve ser prenchido corretamente | Cadastro sem e-mail                       |
      | Usuário Sem Senha          | teste_sem_senha@teste.com |         | O campo senha deve ter pelo menos 6 dígitos    | Cadastro sem senha                        |
      | Usuário Com Email Inválido | email_invalido.com        | Senha05 | O campo e-mail deve ser prenchido corretamente | Cadastro com email inválido               |
      | Usuário Com Senha Inválida | senha_invalida@teste.com  | Pass1   | O campo senha deve ter pelo menos 6 dígitos    | Cadastro com senha com menos de 6 dígitos |
      # O texto "prenchido" pode ser que altere futuramente
