Feature: Alugar Filme
  Como usuario
  Eu quero cadastrar alugeis de filmes
  Para controlar preços e datas de entrega

  Scenario: Deve alugar um filme com sucesso
    Given um filme
      | estoque | 2     |
      | preco   | 3     |
      | tipo    | comum |
    When alugar
    Then o preço do aluguel será R$ 3
    And a data de entrega sera em 1 dia
    And o estoque do filme sera 1 unidade

  Scenario: Não deve alugar um filme sem estoque
    Given um filme com estoque de 0 unidades
    When alugar
    Then não sera possivel por falta de estoque
    And o estoque do filme sera 0 unidade

  Scenario Outline: Deve dar condicoes especiais para categoria extendida
    Given um filme com estoque de 2 unidades
    And que o preço do aluguel seja R$ <preco>
    And que o tipo do aluguel seja <tipo>
    When alugar
    Then o preço do aluguel será R$ <valor>
    And a data de entrega sera em <qntDias> dias
    And a pontuacao sera de <pontuacao> pontos

    Examples:
      | preco | tipo      | valor | qntDias | pontuacao |
      | 4     | extendido | 8     | 3       | 2         |
      | 4     | comum     | 4     | 1       | 1         |
      | 10    | extendido | 20    | 3       | 2         |
      | 5     | semanal   | 15    | 7       | 3         |

