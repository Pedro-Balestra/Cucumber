Feature: Aprender Cucumber

  Scenario: Deve executar especificação
    Given que criei o arquivo corretamente
    When executa-lo
    Then a especificacao deve finalizar com sucesso

  Scenario: Deve incrementar contador
    Given que o valor do contador e 15
    When eu incrementar em 3
    Then o valor do contador sera 18

  Scenario: Deve incrementar contador
    Given que o valor do contador e 123
    When eu incrementar em 35
    Then o valor do contador sera 158

  @ignore
  Scenario: Deve calcular atraso na entrega
    Given que a entrega e dia 05/04/2024
    When a entrega atrasar em 2 dias
    Then a entrega sera efetuada em 07/04/2024

  @ignore
  Scenario: Deve calcular atraso na entrega da china
    Given que a entrega e dia 05/04/2024
    When a entrega atrasar em 2 meses
    Then a entrega sera efetuada em 05/06/2024

  Scenario: Deve criar steps genéricos para estes passos
    Given que o ticket é AF345
    Given que o valor da passagem é R$ 230,45
    Given que o nome do passageiro é "Fulano da Silva"
    Given que o telefone do passageiro é 9999-9999
    When criar os steps
    Then o teste vai funcionar

  Scenario: Deve reaproveitar os steps "Given" do Scenario anterior
    Given que o ticket é AB167
    Given que o ticket especial é AB167
    Given que o valor da passagem é R$ 1120,23
    Given que o nome do passageiro é "Cicrano de Oliveira"
    Given que o telefone do passageiro é 9888-8888

  @ignore
  Scenario: Deve negar todos os steps "Given" dos Scenarios anteriores
    Given que o ticket é CD123
    Given que o ticket é AG1234
    Given que o valor da passagem é R$ 1.1345,56
    Given que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    Given que o telefone do passageiro é 1234-5678
    Given que o telefone do passageiro é 999-2223